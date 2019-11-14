package com.example.diceroller;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText userInput;
    static int score = 0;
    int num = 0;


    public static int getBound() {
        return bound;
    }

    static int bound = 6;
    static ArrayList questions = new ArrayList<String>();

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

        initialise();

    }

    private void initialise() {

        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spend the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
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
    public void onButtonSettings(View view ){
        startActivity(new Intent(MainActivity.this, DicebreakerSettings.class));
    }
    public void dicebrkr(int x ){
        TextView qstn = this.findViewById(R.id.questionDisplay);
      String y =   (String) questions.get(x -1);
       qstn.setText(y);



        }


    public int rndNum(){
        Random r = new Random();
        return r.nextInt(bound)+1;
    }
    public static void setBound(int bound) {
        MainActivity.bound = bound;
    }
}
