package com.example.mydiceap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Defining UI Component
    @BindView(R.id.btn_RollDice)
    Button btnRollDice;
    @BindView(R.id.img_DiceOne)
    ImageView imgDiceOne;
    @BindView(R.id.img_DiceTwo)
    ImageView imgDiceTwo;


    //Defining All the images
    int[] mImageList = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };

   static  int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar mAppBar =  findViewById(R.id.tool_MainBar);
        mAppBar.setTitle("Dice Game");
        mAppBar.setTitleTextColor(getResources().getColor(R.color.white));
        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Random object for generating rndom number
                Random mRandom = new Random();

                //variable storeing random number from 0 to 5
                int mRandomNumber1 = mRandom.nextInt(6); //This generate Number From 0... to ... 6( to n -1)
                int mRandomNumber2 = mRandom.nextInt(6); //This generate Number From 0... to ... 6( to n -1)

                //Setting images to the Image View
                imgDiceOne.setImageDrawable(getResources().getDrawable(mImageList[mRandomNumber1]));
                imgDiceTwo.setImageDrawable(getResources().getDrawable(mImageList[mRandomNumber2]));

                //Comparing integer variable to check equality
                String win = mRandomNumber1 == mRandomNumber2 ? "You Wing the Match" : "Better Luck nextTime";

                //Toast string on the result status
                showToast(win);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Log.i("BackPressed",i+" Sheshank");
        if (i == 2) {
            super.onBackPressed();
            this.onPause();
        } else {
            showToast("Press again to Exit!");
            i++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    i=1;
                }
            },3000);
        }


    }

    /**
     * Function For toast Message
     * @param message
     */
    public void showToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}
