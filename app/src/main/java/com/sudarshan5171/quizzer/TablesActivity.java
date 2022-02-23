package com.sudarshan5171.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TablesActivity extends AppCompatActivity {

    QuestionData data;
    TextView questionView,timerTextView,scoreTextView;
    Button option1,option2,option3,option4;
    Operations operations;
    CountDownTimer mtimer;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply);

        questionView = findViewById(R.id.questionTextView);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        timerTextView =findViewById(R.id.timerView);
        scoreTextView = findViewById(R.id.scoreView);

        Intent intent = getIntent();
        int minVal = intent.getIntExtra("min",0);
        int maxVal = intent.getIntExtra("max",100);

        operations = new Operations(minVal,maxVal);

        nextProblem();
        startTimer();
    }

    void intializeViews(QuestionData data)
    {
        questionView.setText(data.getQuestion());
        option4.setText(data.getOption4());
        option3.setText(data.getOption3());
        option2.setText(data.getOption2());
        option1.setText(data.getOption1());
    }
    void nextProblem()
    {
        data=operations.nextTablesProblem();
        intializeViews(data);
    }

    public void optionSelected(View view)
    {
        Button b = (Button) view;
        if(data.getCorrectAns().equals(b.getText().toString()))
        {
            score++;
            showCorrectToast();
        }
        else
        {
            score--;
            showWrongToast();
        }
        scoreTextView.setText(String.valueOf(score));
        nextProblem();
        startTimer();
    }

    //timer for left time
    public void startTimer() {

        if (mtimer != null) {
            mtimer.cancel();
            mtimer.start();
            return;
        }
        mtimer = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                score--;
                scoreTextView.setText(String.valueOf(score));
                nextProblem();
                startTimer();
                showTimeoutToast();
            }
        }.start();
    }

    //custom toast
    void showCorrectToast()
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.toastBg));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
    void showWrongToast()
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.toastBg));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView v=layout.findViewById(R.id.toastText);
        v.setText("Incorrect!");
        layout.setBackgroundResource(R.color.coral);
        toast.setView(layout);
        toast.show();
    }
    void showTimeoutToast()
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.toastBg));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView v=layout.findViewById(R.id.toastText);
        v.setText("Time Out!");
        layout.setBackgroundResource(R.color.coral);
        toast.setView(layout);
        toast.show();
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(TablesActivity.this);

        builder.setMessage("Do you want to exit quiz?");

        // Set Alert Title
        builder.setTitle("Alert !");

        builder.setCancelable(false);

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                mtimer.cancel();
                                startActivity(new Intent(TablesActivity.this,MainActivity.class));
                            }
                        });
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}