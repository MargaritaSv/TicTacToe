package com.example.magy.second_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    private int mTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn21 = (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23 = (Button) findViewById(R.id.btn23);
        btn31 = (Button) findViewById(R.id.btn31);
        btn32 = (Button) findViewById(R.id.btn32);
        btn33 = (Button) findViewById(R.id.btn33);


        Button[] buttons = {btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

    }
}