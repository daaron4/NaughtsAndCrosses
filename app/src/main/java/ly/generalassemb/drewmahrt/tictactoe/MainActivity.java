package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lastWinnerText;
    private EditText playerOneEditText;
    private EditText playerTwoEditText;
    private Button startGameButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastWinnerText = (TextView) findViewById(R.id.last_winner_text);
        playerOneEditText = (EditText) findViewById(R.id.player_one_name);
        playerTwoEditText = (EditText) findViewById(R.id.player_two_name);
        startGameButton = (Button) findViewById(R.id.start_game_button);

        sharedPreferences = getApplicationContext().getSharedPreferences("secretTicTacToeKey", Context.MODE_PRIVATE);
        lastWinnerText.setText("Previous Winner: " + sharedPreferences.getString("previousWinner", ""));

    }

    @Override
    protected void onResume() {
        super.onResume();
        lastWinnerText.setText("Previous Winner: " + sharedPreferences.getString("previousWinner", ""));
    }

    public void clickedStart(View view) {
        Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
        gameIntent.putExtra("playerOneName", playerOneEditText.getText().toString());
        gameIntent.putExtra("playerTwoName", playerTwoEditText.getText().toString());
        startActivity(gameIntent);
    }

}
