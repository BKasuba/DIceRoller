package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DicebreakerSettings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicebreaker_settings);
    }

    public void onCLickSave(View view){

        TextView newQstn = this.findViewById(R.id.newQstn);

        if( newQstn.getText().toString() != "" ){
            String y = newQstn.getText().toString();

           MainActivity.questions.add(y);
           MainActivity.setBound(MainActivity.getBound() + 1);
        }else{
            newQstn.setText("Please enter which question (1-6) you want to edit in the field above, then enter your changes in this field");
        }
        //startActivity(new Intent(DicebreakerSettings.this, MainActivity.class));
        finish();

    }
    public void onClickCancel (View view){
       // startActivity(new Intent(DicebreakerSettings.this, MainActivity.class));
        finish();
    }
}
