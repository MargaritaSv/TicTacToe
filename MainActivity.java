package com.example.magy.second_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    Button[] buttons;

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

        mTurn = 1;

        buttons = new Button[]{btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        //   String button = view.toString();
        if (view.getId() == R.id.btn11) {
            processClick(btn11);
        }

        if (view.getId() == R.id.btn12) {
            processClick(btn12);
        }

        if (view.getId() == R.id.btn13) {
            processClick(btn13);
        }

        if (view.getId() == R.id.btn21) {
            processClick(btn21);
        }
        if (view.getId() == R.id.btn22) {
            processClick(btn22);
        }

        if (view.getId() == R.id.btn23) {
            processClick(btn23);
        }
        if (view.getId() == R.id.btn31) {
            processClick(btn31);
        }

        if (view.getId() == R.id.btn32) {
            processClick(btn32);
        }
        if (view.getId() == R.id.btn33) {
            processClick(btn33);
        }
    }

    private void processClick(Button button) {
        if (button.getText().toString().equals("")) {
            if (mTurn == 1) {
                mTurn = 2;
                button.setText("X");
            } else {
                mTurn = 1;
                button.setText("O");
            }
        }

        endGame();
    }


    private void endGame() {
        String[] tempScore = new String[buttons.length];
        boolean end = false;

        for (int i = 0; i < tempScore.length; i++) {
            tempScore[i] = buttons[i].getText().toString();
        }

    }
}