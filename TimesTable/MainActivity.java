package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;
    int startingPosition = 10;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j = 1; j <= startingPosition; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);

        int max = 20;

        generateTimesTable(startingPosition);

        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(progress < min){
                    timesTableNumber = min;
                } else {
                    timesTableNumber = progress;
                }
                Log.i("SeekBar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}