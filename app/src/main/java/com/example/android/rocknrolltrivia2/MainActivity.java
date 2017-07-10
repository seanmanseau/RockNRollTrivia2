package com.example.android.rocknrolltrivia2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    Boolean isZiggy = false;
    Boolean isThin = false;
    Boolean isIggy = false;
    String nico = "";
    String dolls = "";
    String pretenders = "";

    // Gets the answer for Question One. Three checkboxes.
    // Checks state of Ziggy checkbox
    public void ziggyCheckbox(View view) {
        CheckBox ziggyCheckbox = (CheckBox) findViewById(R.id.answerA);
        isZiggy = ziggyCheckbox.isChecked();
    }

    // Checks state of Thin White Duke checkbox
    public void thinCheckbox(View view) {
        CheckBox thinCheckbox = (CheckBox) findViewById(R.id.answerB);
        isThin = thinCheckbox.isChecked();
    }

    // Checks state of Iggy checkbox
    public void iggyCheckbox(View view) {
        CheckBox iggyCheckbox = (CheckBox) findViewById(R.id.answerC);
        isIggy = iggyCheckbox.isChecked();
    }

    // Gets the answer for Question 2
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.nico:
                if (checked)
                    nico = "nico";
                break;
            case R.id.lola:
                if (checked)
                    nico = "lola";
                break;
            case R.id.brigitte:
                if (checked)
                    nico = "brigitte";
                break;
        }

    }

    //Gets the answer for Question 3
    public void thunders(View view) {
        EditText nameView = (EditText) findViewById(R.id.name_view);
        String dolls = nameView.getText().toString();

        Log.d("MainActivity", dolls);
    }

    // Gets the answer for Question 4
    public void onPretendersRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.tattooed:
                if (checked)
                    pretenders = "tattooed";
                    Log.d("MainActivity", pretenders);
                break;
            case R.id.crawl:
                if (checked)
                    pretenders = "crawl";
                    Log.d("MainActivity", pretenders);
                break;
            case R.id.middle:
                if (checked)
                    pretenders = "middle";
                    Log.d("MainActivity", pretenders);
                break;
        }

    }
    // Calculates total score
    public void getScore(View view) {
        // Calculates score for Question One
        if ((isZiggy & isThin) & (!isIggy)) {
            score = score + 1;
            Log.d("MainActivity", "Question 1 " + score);
        }

        // Calculates score for Question Two
        if (nico.equals("nico")) {
            score = score + 1;
            Log.d("MainActivity", "Question 2 " + score);
        }

        // Calculates score for Question Three
        if (dolls.equals("Dolls")) {
            score = score + 1;
            Log.d("MainActivity", "Question 3 " + score);
        }

        // Calculates score for Question Four
        if (pretenders.equals("crawl")) {
            score = score + 1;
            Log.d("MainActivity", "Question 4 " + score);
        }

        //Here's the toast
        Context context = getApplicationContext();
        CharSequence text = "Your score is " + score + "/4!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}


