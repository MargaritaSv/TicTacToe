package com.example.magy.second_homework;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    Button[] buttons;

    private String player;

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

        player = "X";

        buttons = new Button[]{btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn11:
                processClick(btn11);
                break;
            case R.id.btn12:
                processClick(btn12);
                break;
            case R.id.btn13:
                processClick(btn13);
                break;
            case R.id.btn21:
                processClick(btn21);
                break;
            case R.id.btn22:
                processClick(btn22);
                break;
            case R.id.btn23:
                processClick(btn23);
                break;
            case R.id.btn31:
                processClick(btn31);
                break;
            case R.id.btn32:
                processClick(btn32);
                break;
            case R.id.btn33:
                processClick(btn33);
                break;
        }
    }

    private void processClick(Button button) {
        if (button.getText().toString().equals("")) {

            String text = player.equals("X") ? "X" : "O";
            button.setText(text);
            endGame();

            player = player.equals("X") ? "O" : "X";
        }
    }


    private void endGame() {

        String[] tempScore = new String[buttons.length];
        boolean noWinner = true;

        for (int i = 0; i < tempScore.length; i++) {
            tempScore[i] = buttons[i].getText().toString();

            if (tempScore[i].equals("")) {
                noWinner = false;
            }
        }

        if (checkHasAWinner(tempScore)) {
            Toast.makeText(MainActivity.this, "Winner is: Player " + player, Toast.LENGTH_SHORT).show();
            resetGame();
        }

        if (noWinner) {
            Toast.makeText(MainActivity.this, " No Winner", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void resetGame() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                player = "X";
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText("");
                }
            }
        }, 2000);
    }


    private boolean checkHasAWinner(String[] position) {
        return (position[0].equals(position[1]) && position[0].equals(position[2]) && position[0].equals(player)) || //first hor
                (position[3].equals(position[4]) && position[3].equals(position[5]) && position[3].equals(player)) ||
                (position[6].equals(position[7]) && position[6].equals(position[8]) && position[6].equals(player)) ||
                (position[0].equals(position[3]) && position[0].equals(position[6]) && position[0].equals(player)) || //first vertical
                (position[1].equals(position[4]) && position[1].equals(position[7]) && position[1].equals(player)) ||
                (position[2].equals(position[5]) && position[2].equals(position[8]) && position[2].equals(player)) ||
                (position[2].equals(position[4]) && position[2].equals(position[6]) && position[2].equals(player)) ||//first diagonal
                (position[0].equals(position[4]) && position[0].equals(position[8]) && position[0].equals(player));
    }
}