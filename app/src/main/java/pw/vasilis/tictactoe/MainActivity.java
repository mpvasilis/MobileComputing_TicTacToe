package pw.vasilis.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public EditText plyr1;
    public EditText plyr2;

    public CharSequence player1 = "Player 1";
    public CharSequence player2 = "Player 2";

    public CharSequence cloneplayer2;
    boolean player1ax = true;
    boolean selectedSinglePlayer;
    public CheckBox p1x, p1o, p2x, p2o, singleplayer, twoplayer;

    int game=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        game = getIntent().getIntExtra("GAME", 3);


        plyr1 = (EditText) findViewById(R.id.playerone);
        plyr2 = (EditText) findViewById(R.id.playertwo);


        p1x = (CheckBox) findViewById(R.id.player1x);
        p1o = (CheckBox) findViewById(R.id.player1o);
        p2x = (CheckBox) findViewById(R.id.player2x);
        p2o = (CheckBox) findViewById(R.id.player2o);
        singleplayer = (CheckBox) findViewById(R.id.splayer);
        twoplayer = (CheckBox) findViewById(R.id.tplayer);

        p1x.setOnClickListener(checkboxClickListener);
        p1o.setOnClickListener(checkboxClickListener);
        p2x.setOnClickListener(checkboxClickListener);
        p2o.setOnClickListener(checkboxClickListener);
        singleplayer.setOnClickListener(checkboxClickListener);
        twoplayer.setOnClickListener(checkboxClickListener);

        p1x.setChecked(true);
        p2o.setChecked(true);
        twoplayer.setChecked(true);


        plyr1.addTextChangedListener(new TextWatcher() {                               /*this code take player1's name characterwise i.e it takes one character at a time and
                                                                                         saved to string variable player1*/
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player1 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        plyr2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player2 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    View.OnClickListener checkboxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {
                switch (view.getId()) {
                    case R.id.player1x:
                        p1o.setChecked(false);
                        p2x.setChecked(false);
                        p2o.setChecked(true);
                        player1ax = true;
                        break;
                    case R.id.player1o:
                        p1x.setChecked(false);
                        p2o.setChecked(false);
                        p2x.setChecked(true);
                        player1ax = false;
                        break;
                    case R.id.player2x:
                        p2o.setChecked(false);
                        p1x.setChecked(false);
                        p1o.setChecked(true);
                        player1ax = false;
                        break;
                    case R.id.player2o:
                        p2x.setChecked(false);
                        p1o.setChecked(false);
                        p1x.setChecked(true);
                        player1ax = true;
                        break;
                    case R.id.splayer:
                        twoplayer.setChecked(false);
                        selectedSinglePlayer = true;
                        cloneplayer2 = player2;
                        plyr2.setText("CPU");

                        plyr1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        plyr1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);


                        break;
                    case R.id.tplayer:
                        singleplayer.setChecked(false);
                        selectedSinglePlayer = false;
                        plyr2.setText(cloneplayer2);
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                        plyr1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                        break;
                }

            } else {
                switch (view.getId()) {
                    case R.id.player1x:
                        p1o.setChecked(true);
                        p2x.setChecked(true);
                        p2o.setChecked(false);
                        player1ax = false;
                        break;
                    case R.id.player1o:
                        p1x.setChecked(true);
                        p2o.setChecked(true);
                        p2x.setChecked(false);
                        player1ax = true;
                        break;
                    case R.id.player2x:
                        p2o.setChecked(true);
                        p1x.setChecked(true);
                        p1o.setChecked(false);
                        player1ax = true;
                        break;
                    case R.id.player2o:
                        p2x.setChecked(true);
                        p1o.setChecked(true);
                        p1x.setChecked(false);
                        player1ax = false;
                        break;
                    case R.id.splayer:
                        twoplayer.setChecked(true);
                        selectedSinglePlayer = false;
                        plyr2.setText(cloneplayer2);
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                        plyr1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                        break;
                    case R.id.tplayer:
                        singleplayer.setChecked(true);
                        selectedSinglePlayer = true;
                        plyr2.setText("CPU");
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        plyr1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);
                        break;
                }

            }

        }
    };


    public void startgame(View view) {

        if (!selectedSinglePlayer)
            if (player2.length() == 0)
                player2 = "player 2";
        if (player1.length() == 0)
            player1 = "player 1";

        CharSequence[] players = {player1, player2};
        if(game==3){
            Intent i = new Intent(this, TicTacToe3x3.class);
            i.putExtra("playersnames", players);
            i.putExtra("player1ax", player1ax);
            i.putExtra("selectedsingleplayer", selectedSinglePlayer);
            startActivity(i);

        }
        else{
            Intent i = new Intent(this, TicTacToe4x4.class);
            i.putExtra("playersnames", players);
            i.putExtra("player1ax", player1ax);
            i.putExtra("selectedsingleplayer", selectedSinglePlayer);
            startActivity(i);
        }



    }

}