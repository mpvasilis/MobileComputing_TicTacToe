package pw.vasilis.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SelectGameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_selectgame);

        final Button tictactoe3x3 = findViewById(R.id.tictactoe3x3);
        tictactoe3x3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SelectGameActivity.this, MainActivity.class);
                i.putExtra("GAME",3); // gia 3x3 tic tac toe
                startActivity(i);
            }
        });

        final Button tictactoe4x4 = findViewById(R.id.tictactoe4x4);
        tictactoe4x4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SelectGameActivity.this, MainActivity.class);
                i.putExtra("GAME",4); // gia 4x4 tic tac toe
                startActivity(i);
            }
        });


    }

}