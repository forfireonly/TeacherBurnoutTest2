package com.example.annascott.teacherburnouttest;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.annascott.teacherburnouttest.Main2Activity.name;
import static com.example.annascott.teacherburnouttest.Main2Activity.purpose;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    public static int score;
    public static String nametwo;
    @BindView(R.id.thoughts_text)
    EditText thoughtText;
    @BindView(R.id.insomnia_box)
    CheckBox insomniaBox;
    @BindView(R.id.appetite_box)
    CheckBox appetiteBox;
    @BindView(R.id.fatigue_box)
    CheckBox fatigueBox;
    @BindView(R.id.anger_yes_radio)
    RadioButton angerYesRadio;
    @BindView(R.id.anger_no_radio)
    RadioButton angerNoRadio;
    @BindView(R.id.anger_sometimes_radio)
    RadioButton angerSometimesRadio;
    @BindView(R.id.social_yes_radio)
    RadioButton socialYesRadio;
    @BindView(R.id.social_no_radio)
    RadioButton socialNoRadio;
    @BindView(R.id.social_sometimes_radio)
    RadioButton socialSometimesRadio;
    @BindView(R.id.complaining_yes_radio)
    RadioButton complainingYesRadio;
    @BindView(R.id.complaining_no_radio)
    RadioButton complainingNoRadio;
    @BindView(R.id.complaining_sometimes_radio)
    RadioButton complainingSometimesRadio;
    @BindView(R.id.focusing_yes_radio)
    RadioButton focusingYesRadio;
    @BindView(R.id.focusing_no_radio)
    RadioButton focusingNoRadio;
    @BindView(R.id.focusing_sometime_radio)
    RadioButton focusingSometimeRadio;
    @BindView(R.id.results)
    Button results;
    @BindView(R.id.explanation_grading)
    Button explanation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        results.setOnClickListener((View.OnClickListener) this);
        explanation.setOnClickListener((View.OnClickListener) this);

        explanation.setVisibility(View.GONE);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void boxesScore(CheckBox box1, CheckBox box2, CheckBox box3) {
        if (box1.isChecked() && !box2.isChecked() && !box3.isChecked()) {
            score++;
        }
        if (box2.isChecked() && !box1.isChecked() && !box3.isChecked()) {
            score++;
        }
        if (box3.isChecked() && !box1.isChecked() && !box2.isChecked()) {
            score++;
        }
        if (box1.isChecked() && box2.isChecked() && !box3.isChecked()) {
            score += 2;
        }
        if (box1.isChecked() && box3.isChecked() && !box2.isChecked()) {
            score += 2;
        }
        if (box2.isChecked() && box3.isChecked() && !box1.isChecked()) {
            score += 2;
        }
        if (box1.isChecked() && box2.isChecked() && box3.isChecked()) {
            score += 3;
        }

    }

    public void scoreCalculate() {

        String answer = thoughtText.getText().toString();
        if (answer.equalsIgnoreCase("yes")) {
            score += 2;
        }
        if (answer.equalsIgnoreCase("Maybe")) {
            score++;
        }

        boxesScore(insomniaBox, appetiteBox, fatigueBox);

        if (angerYesRadio.isChecked()) {
            score += 2;
        }
        if (angerSometimesRadio.isChecked()) {
            score++;
        }

        if (socialYesRadio.isChecked()) {
            score += 2;
        }
        if (socialSometimesRadio.isChecked()) {
            score++;
        }

        if (complainingYesRadio.isChecked()) {
            score += 2;
        }
        if (complainingSometimesRadio.isChecked()) {
            score++;
        }

        if (focusingYesRadio.isChecked()) {
            score += 2;
        }
        if (focusingSometimeRadio.isChecked()) {
            score++;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.results:
                // code for button when user clicks buttonOne.

                explanation.setVisibility(View.VISIBLE);
                results.setVisibility(View.GONE);
                scoreCalculate();
                if (score < 5) {
                    noBurnout(name, score);
                }
                if (score >= 5 && score < 9) {
                    borderlineBurnout(name, score);
                }
                if (score >= 9) {
                    burnout(name, score);
                }

                break;

            case R.id.explanation_grading:
                // do your code
                Intent myIntent = new Intent(Main3Activity.this, Main4Activity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                Main3Activity.this.startActivity(myIntent);
                nametwo = name;
                break;
        }
    }

    public void noBurnout(String name, int score) {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.noburnout,
                (ViewGroup) findViewById(R.id.no_burnout));

// set a message
        TextView text = (TextView) layout.findViewById(R.id.name);
        text.setText(name);

        TextView text2 = (TextView) layout.findViewById(R.id.your_score_number);
        text2.setText(String.valueOf(score));

// Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


    }

    public void borderlineBurnout(String name, int score) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.borderline,
                (ViewGroup) findViewById(R.id.borderline_toast));

// set a message
        TextView text = (TextView) layout.findViewById(R.id.name);
        text.setText(name);

        TextView text2 = (TextView) layout.findViewById(R.id.your_score_number);
        text2.setText(String.valueOf(score));

// Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    public void burnout(String name, int score) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.burnout,
                (ViewGroup) findViewById(R.id.burnout_toast));

// set a message
        TextView text = (TextView) layout.findViewById(R.id.name);
        text.setText(name);

        TextView text2 = (TextView) layout.findViewById(R.id.your_score_number);
        text2.setText(String.valueOf(score));

// Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}


