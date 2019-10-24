package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText userInput;
    static int score = 0;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @SuppressLint("SetTextI18n")
    public void on_button(View view) {

        TextView tv = this.findViewById(R.id.rndNumDisplay);
        TextView grats = this.findViewById(R.id.congratsDisplay);
        TextView scoreCntr = this.findViewById(R.id.pointCounter);
        num = rndNum();


        tv.setText(Integer.toString(num));
        userInput = findViewById(R.id.userInput);

        String input = userInput.getText().toString();

        if (input.matches("\\D*")) {
            grats.setText("Please enter numbers only");
        } else {

            if (num == Integer.valueOf(input)) {


                scoreCntr.setText(""+(++score));
                grats.setText("Congratulations");
            } else {
                grats.setText("Try again");
            }


        }
    }
    public void onButtonBreaker (View view ){
        dicebrkr(num);
    }
    public void dicebrkr(int x ){
        TextView qstn = this.findViewById(R.id.questionDisplay);
        switch(x){
            case 0:
                qstn.setText("Roll the die first!!");
                break;
            case 1:
                qstn.setText("If you could go anywhere in the world, where would you go?");
                break;
            case 2:
                qstn.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                break;
            case 3:
                qstn.setText("If you could eat only one food for the rest of your life, what would that be?");
                break;
            case 4:
                qstn.setText("If you won a million dollars, what is the first thing you would buy?");
                break;
            case 5:
                qstn.setText("If you could spend the day with one fictional character, who would it be?");
                break;
            case 6:
                qstn.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                break;




        }

    }
    public int rndNum(){
        Random r = new Random();
        int num = r.nextInt(6)+1;
        return num;
    }
}
