package com.sudarshan5171.quizzer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.sudarshan5171.quizzer.Fragments.RangeFragment;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    NavigationView nav;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView linktext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.navMenu);
        drawerLayout = findViewById(R.id.drawer_layout);
        setNavigationDrawer();

        linktext = findViewById(R.id.linkTv);
        linktext.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void goToTest(View view) {

        startActivity(new Intent(this,QuizActivity.class));
    }

    public void goToSquares(View view) {
        RangeFragment rangeFragment = new RangeFragment(1,101,"Select the range",4);
        rangeFragment.show(getSupportFragmentManager(),"Select the range");
    }

    public void goToTables(View view) {
        RangeFragment rangeFragment = new RangeFragment(1,51,"Select the table",3);
        rangeFragment.show(getSupportFragmentManager(),"Select the range");

    }

    public void goToSums(View view) {
        RangeFragment rangeFragment = new RangeFragment(2,1001,"Select the range",2);
        rangeFragment.show(getSupportFragmentManager(),"Select the range");

    }

    public void goToMultiply(View view) {
        RangeFragment rangeFragment = new RangeFragment(2,101,"Select the range",1);
        rangeFragment.show(getSupportFragmentManager(),"Select the range");
    }

    void setNavigationDrawer()
    {
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.settings_menu:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.high_score_menu:
                        Toast.makeText(MainActivity.this, "High Score", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.themes_menu:
                        Toast.makeText(MainActivity.this, "Themes", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
}