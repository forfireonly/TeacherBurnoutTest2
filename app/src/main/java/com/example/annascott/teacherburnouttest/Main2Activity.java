package com.example.annascott.teacherburnouttest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public static String name;
    public static String purpose;

    @BindView(R.id.next)
    Button next;

    @BindView(R.id.yourname)
    EditText nameView;

    @BindView((R.id.purpose))
    EditText purposeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        next.setOnClickListener((View.OnClickListener) this);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View view) {

        name = nameView.getText().toString();
        purpose = purposeView.getText().toString();

        Intent myIntent = new Intent(Main2Activity.this, Main3Activity.class);
        Main2Activity.this.startActivity(myIntent);

    }
}

