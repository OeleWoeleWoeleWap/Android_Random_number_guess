package com.example.martijn.randomnumberguess;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView hintField;
    private TextView lastGuessField;
    private EditText inputField;

    private long trueNumber;
    private long minNumber = 1;
    private long maxNumber = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRandomNumber(minNumber, maxNumber);

        inputField = (EditText) findViewById(R.id.newGuessInput);
        hintField = (TextView) findViewById(R.id.hintField);
        lastGuessField = (TextView) findViewById(R.id.lastGuessField);



    }

    protected void createRandomNumber(long min, long max){
        trueNumber = minNumber + (long) (Math.random() * (maxNumber - minNumber));
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

    public void checkGuess(View view) {
        long value = 0;
        try {
            value = Long.parseLong(inputField.getText().toString());
        }catch (Exception e){
            lastGuessField.setText("Enter a value please");
            return;
        }
      inputField.setText("");
      lastGuessField.setText(Long.toString(value));
      if (value > trueNumber){
          hintField.setText("Lower");
      }
      else if ( value < trueNumber){
          hintField.setText("Higher");
      }
      else{
          hintField.setText("You guessed correctly!");
      }

    }

    public void restart(View view) {
        createRandomNumber(minNumber, maxNumber);
        hintField.setText("");
        lastGuessField.setText("");
        inputField.setText("");
    }
}
