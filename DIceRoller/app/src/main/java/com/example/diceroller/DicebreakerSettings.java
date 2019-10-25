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
        TextView qstnNum = this.findViewById(R.id.qstnNum);
        TextView newQstn = this.findViewById(R.id.newQstn);

        if( newQstn.getText().toString() != "" && qstnNum.getText().toString() != ""){
            String y = newQstn.getText().toString();
            int x = Integer.valueOf(qstnNum.getText().toString());
            switch(x){

                case 1:
                    MainActivity.qstn1 = y;
                    break;
                case 2:
                    MainActivity.qstn2 = y;
                    break;
                case 3:
                    MainActivity.qstn3 = y;
                    break;
                case 4:
                    MainActivity.qstn4 = y;
                    break;
                case 5:
                    MainActivity.qstn5 = y;
                    break;
                case 6:
                    MainActivity.qstn6 = y;
                    break;




            }
        }else{
            newQstn.setText("Please enter which question (1-6) you want to edit in the field above, then enter your changes in this field");
        }
        startActivity(new Intent(DicebreakerSettings.this, MainActivity.class));

    }
    public void onClickCancel (View view){
        startActivity(new Intent(DicebreakerSettings.this, MainActivity.class));
    }
}
