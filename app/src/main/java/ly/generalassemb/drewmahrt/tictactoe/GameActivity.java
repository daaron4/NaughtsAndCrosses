package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private TextView turnDisplay;

    private TextView zeroZero;
    private TextView zeroOne;
    private TextView zeroTwo;
    private TextView oneZero;
    private TextView oneOne;
    private TextView oneTwo;
    private TextView twoZero;
    private TextView twoOne;
    private TextView twoTwo;

    private Player player1;
    private Player player2;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        turnDisplay = (TextView) findViewById(R.id.game_message_text);
        zeroZero = (TextView) findViewById(R.id.zero_zero);
        zeroOne = (TextView) findViewById(R.id.zero_one);
        zeroTwo = (TextView) findViewById(R.id.zero_two);
        oneZero = (TextView) findViewById(R.id.one_zero);
        oneOne = (TextView) findViewById(R.id.one_one);
        oneTwo = (TextView) findViewById(R.id.one_two);
        twoZero = (TextView) findViewById(R.id.two_zero);
        twoOne = (TextView) findViewById(R.id.two_one);
        twoTwo = (TextView) findViewById(R.id.two_two);

        if (savedInstanceState != null) {
            zeroZero.setText(savedInstanceState.getString("zeroZero"));
            zeroOne.setText(savedInstanceState.getString("zeroOne"));
            zeroTwo.setText(savedInstanceState.getString("zeroTwo"));
            oneZero.setText(savedInstanceState.getString("oneZero"));
            oneOne.setText(savedInstanceState.getString("oneOne"));
            oneTwo.setText(savedInstanceState.getString("oneTwo"));
            twoZero.setText(savedInstanceState.getString("twoZero"));
            twoOne.setText(savedInstanceState.getString("twoOne"));
            twoTwo.setText(savedInstanceState.getString("twoTwo"));
            player1 = new Player(savedInstanceState.getString("playerOneName"));
            player2 = new Player(savedInstanceState.getString("playerTwoName"));
            player1.setMyTurn(savedInstanceState.getBoolean("playerOneTurn"));
            player2.setMyTurn(savedInstanceState.getBoolean("playerTwoTurn"));
            if (checkForWinner()) {
                disableClickableItems();
                turnDisplay.setText(savedInstanceState.getString("turnDisplay"));
            }
            else if (savedInstanceState.getInt("count", count) == 9) {
                disableClickableItems();
                turnDisplay.setText(savedInstanceState.getString("turnDisplay"));
            }
            else {
                displayCurrentPlayer();
            }
        }
        else {
            Intent intent = getIntent();
            String playerOneName = intent.getStringExtra("playerOneName");
            String playerTwoName = intent.getStringExtra("playerTwoName");
            player1 = new Player(playerOneName);
            player1.setMyTurn(true);
            player2 = new Player(playerTwoName);
            displayCurrentPlayer();
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putString("zeroZero", zeroZero.getText().toString());
        outState.putString("zeroOne", zeroOne.getText().toString());
        outState.putString("zeroTwo", zeroTwo.getText().toString());
        outState.putString("oneZero", oneZero.getText().toString());
        outState.putString("oneOne", oneOne.getText().toString());
        outState.putString("oneTwo", oneTwo.getText().toString());
        outState.putString("twoZero", twoZero.getText().toString());
        outState.putString("twoOne", twoOne.getText().toString());
        outState.putString("twoTwo", twoTwo.getText().toString());
        outState.putString("playerOneName", player1.getName());
        outState.putString("playerTwoName", player2.getName());
        outState.putBoolean("playerOneTurn", player1.isMyTurn());
        outState.putBoolean("playerTwoTurn", player2.isMyTurn());
        outState.putString("turnDisplay", turnDisplay.getText().toString());
    }

    public void displayCurrentPlayer() {
        if (player1.isMyTurn()) {
            turnDisplay.setText(player1.getName() + "'s Turn");
        }
        else {
            turnDisplay.setText(player2.getName() + "'s Turn");
        }

        if (count == 9) {
            turnDisplay.setText("Cat's Game!");
        }
    }

    public void clickedZeroZero(View view) {
        count++;
        if (player1.isMyTurn()) {
            zeroZero.setText("X");
            zeroZero.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            zeroZero.setText("O");
            zeroZero.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedZeroOne(View view) {
        count++;
        if (player1.isMyTurn()) {
            zeroOne.setText("X");
            zeroOne.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            zeroOne.setText("O");
            zeroOne.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedZeroTwo(View view) {
        count++;
        if (player1.isMyTurn()) {
            zeroTwo.setText("X");
            zeroTwo.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            zeroTwo.setText("O");
            zeroTwo.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedOneZero(View view) {
        count++;
        if (player1.isMyTurn()) {
            oneZero.setText("X");
            oneZero.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            oneZero.setText("O");
            oneZero.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedOneOne(View view) {
        count++;
        if (player1.isMyTurn()) {
            oneOne.setText("X");
            oneOne.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            oneOne.setText("O");
            oneOne.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedOneTwo(View view) {
        count++;
        if (player1.isMyTurn()) {
            oneTwo.setText("X");
            oneTwo.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            oneTwo.setText("O");
            oneTwo.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedTwoZero(View view) {
        count++;
        if (player1.isMyTurn()) {
            twoZero.setText("X");
            twoZero.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            twoZero.setText("O");
            twoZero.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedTwoOne(View view) {
        count++;
        if (player1.isMyTurn()) {
            twoOne.setText("X");
            twoOne.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            twoOne.setText("O");
            twoOne.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void clickedTwoTwo(View view) {
        count++;
        if (player1.isMyTurn()) {
            twoTwo.setText("X");
            twoTwo.setClickable(false);
            player1.setMyTurn(false);
            player2.setMyTurn(true);
        }
        else {
            twoTwo.setText("O");
            twoTwo.setClickable(false);
            player2.setMyTurn(false);
            player1.setMyTurn(true);
        }
        if (checkForWinner()) {
            disableClickableItems();
            saveWinner();
        }
        else {
            displayCurrentPlayer();
        }
    }

    public void saveWinner() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("secretTicTacToeKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String display = turnDisplay.getText().toString();
        editor.putString("previousWinner", display.substring(0, display.length()-" Wins!".length()));
        editor.commit();
    }

    public void disableClickableItems() {
        zeroZero.setClickable(false);
        zeroOne.setClickable(false);
        zeroTwo.setClickable(false);
        oneZero.setClickable(false);
        oneOne.setClickable(false);
        oneTwo.setClickable(false);
        twoZero.setClickable(false);
        twoOne.setClickable(false);
        twoTwo.setClickable(false);
    }

    public boolean checkForWinner() {
        String[][] game = new String[3][3];
        game[0][0] = zeroZero.getText().toString();
        game[0][1] = zeroOne.getText().toString();
        game[0][2] = zeroTwo.getText().toString();
        game[1][0] = oneZero.getText().toString();
        game[1][1] = oneOne.getText().toString();
        game[1][2] = oneTwo.getText().toString();
        game[2][0] = twoZero.getText().toString();
        game[2][1] = twoOne.getText().toString();
        game[2][2] = twoTwo.getText().toString();

        // row check:
        int x;
        int o;
        for (int i = 0; i < game.length; i++) {
            x = 0;
            o = 0;
            for (int j = 0; j < game.length; j++) {
                if (game[i][j].equals("X")) {
                    x++;
                }
                else if (game[i][j].equals("O")) {
                    o++;
                }
                if (x == 3) {
                    turnDisplay.setText(player1.getName() + " Wins!");
                    return true;
                }
                if (o == 3) {
                    turnDisplay.setText(player2.getName() + " Wins!");
                    return true;
                }
            }

        }

        //col check:
        for (int i = 0; i < game.length; i++) {
            x = 0;
            o = 0;
            for (int j = 0; j < game.length; j++) {
                if (game[j][i].equals("X")) {
                    x++;
                }
                else if (game[j][i].equals("O")) {
                    o++;
                }
                if (x == 3) {
                    turnDisplay.setText(player1.getName() + " Wins!");
                    return true;
                }
                if (o == 3) {
                    turnDisplay.setText(player2.getName() + " Wins!");
                    return true;
                }
            }

        }

        //diagonal checks:
        if (game[0][0].equals("X") && game[1][1].equals("X") && game[2][2].equals("X")) {
            turnDisplay.setText(player1.getName() + " Wins!");
            return true;
        }

        if (game[0][0].equals("O") && game[1][1].equals("O") && game[2][2].equals("O")) {
            turnDisplay.setText(player2.getName() + " Wins!");
            return true;
        }

        if (game[0][2].equals("X") && game[1][1].equals("X") && game[2][0].equals("X")) {
            turnDisplay.setText(player1.getName() + " Wins!");
            return true;
        }

        if (game[0][2].equals("O") && game[1][1].equals("O") && game[2][0].equals("O")) {
            turnDisplay.setText(player2.getName() + " Wins!");
            return true;
        }

        return false;

    }


}
