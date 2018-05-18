package com.example.annascott.teacherburnouttest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

import static com.example.annascott.teacherburnouttest.Main2Activity.purpose;
import static com.example.annascott.teacherburnouttest.Main3Activity.nametwo;
import static com.example.annascott.teacherburnouttest.Main3Activity.score;

public class Main4Activity extends AppCompatActivity {

    TextView text1;

    TextView text2;

    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        text1 = (TextView) findViewById(R.id.yourname_one);
        text1.setText(nametwo);

        text2 = (TextView) findViewById(R.id.your_number_score);
        text2.setText(String.valueOf(score));

        text3 = (TextView) findViewById(R.id.your_reason);
        text3.setText(purpose);

        score = 0;

    }
}
