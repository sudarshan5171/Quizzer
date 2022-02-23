package com.sudarshan5171.quizzer.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sudarshan5171.quizzer.MultiplyActivity;
import com.sudarshan5171.quizzer.R;
import com.sudarshan5171.quizzer.SquaresActivity;
import com.sudarshan5171.quizzer.SumsActivity;
import com.sudarshan5171.quizzer.TablesActivity;


public class RangeFragment extends DialogFragment {

    SeekBar rangeSeekBar;
    TextView rangeTextView;
    TextView msgTextView;
    int maxVal=100,minVal=0;
    Button letsGoBtn;
    String msg="";
    int activityId;
    public RangeFragment() {
        // Required empty public constructor
    }

    public RangeFragment(int minValue,int maxValue,String str,int actId)
    {
        this.maxVal=maxValue;
        this.minVal=minValue;
        this.msg=str;
        this.activityId=actId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_range, container, false);
        rangeSeekBar = view.findViewById(R.id.rangeSeekBar);
        rangeSeekBar.setMax(maxVal);
        rangeSeekBar.setMin(minVal);
        rangeSeekBar.setProgress(15);
        rangeTextView = view.findViewById(R.id.rangeTextView);
        msgTextView = view.findViewById(R.id.msgText);
        msgTextView.setText(msg);

        rangeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rangeTextView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        letsGoBtn = view.findViewById(R.id.startBtn);
        letsGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(activityId==1)
                {
                    Intent intent = new Intent(getActivity(), MultiplyActivity.class);
                    intent.putExtra("min",minVal);
                    intent.putExtra("max",rangeSeekBar.getProgress());
                    startActivity(intent);
                }
                else if(activityId==2)
                {
                    Intent intent = new Intent(getActivity(), SumsActivity.class);
                    intent.putExtra("min",minVal);
                    intent.putExtra("max",rangeSeekBar.getProgress());
                    startActivity(intent);
                }
                else if(activityId==3)
                {
                    Intent intent = new Intent(getActivity(), TablesActivity.class);
                    intent.putExtra("min",minVal);
                    intent.putExtra("max",rangeSeekBar.getProgress());
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), SquaresActivity.class);
                    intent.putExtra("min",minVal);
                    intent.putExtra("max",rangeSeekBar.getProgress());
                    startActivity(intent);
                }
            }
        });

        return view;

    }
}