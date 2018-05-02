package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2;
    CheckBox checkBox1, checkBox2;
    EditText editTextName, editAnswer4;
    Button buttonresult ,buttonSubmit;
    int mscore1 ;
    int mscore2 ;
    int mscore3  ;
    int mscore4 ;
    int totalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGrpQuestion1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGrpQuestion2);
        buttonresult = (Button) findViewById(R.id.total);
        buttonSubmit = (Button) findViewById(R.id.Submit);
    }
    // Question1 RadioGroup1
    public void onRadioGrpQuestion1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.question1_option1:
                if (checked) {
                    mscore1 = 1 ;  //correct answer
                    break;  }
            case R.id.question1_option2:
                if (checked) {
                    mscore1=0;
                    break;  }
            case R.id.question1_option3:
                if (checked) {
                    mscore1=0;
                    break;   }
        }
    }
    // Question2 RadioGroup12
    public void onRadioGrpQuestion2(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question2_option1:
                if (checked) {
                    mscore2 = 2;  //correct answer
                    break;  }
            case R.id.question2_option2: {
                if (checked) {
                    mscore2=0;
                    break;  }
            }
            case R.id.question2_option3:
                if (checked) {
                    mscore2=0;
                    break;   }
        }
    }
    // Question3 checkBox
    public void onClickcheckBox(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question3_option1);
        boolean ischeckBox1 = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question3_option2);
        boolean ischeckBox2 = checkBox2.isChecked();

        boolean Checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.question3_option1:
                if (Checked)
                mscore3 =3 ;
                break;
            case R.id.question3_option2:
                if (Checked)
                    break;
                mscore3 = mscore3;
        }
    }
    // Question4  editText
    public void editText(View view) {
        editTextName = (EditText) findViewById(R.id.name_field);
        String name = editTextName.getText().toString();

        editAnswer4 = (EditText)  this.findViewById(R.id.Answer);
        String answer4 = editAnswer4.getText().toString().toLowerCase();
        if(answer4.equals("iron")){
            mscore4 = 4;
       }else{
            mscore4 = 0;
    }}
    // Display total and calculate on click to edittext
    public void Total(View view) {
        totalScore = mscore1 + mscore2 + mscore3 + mscore4 ;
        TextView scoreView = (TextView) findViewById(R.id.total);
        scoreView.setText(String.valueOf(totalScore));
    }

    public void Submit(View view) {
        Toast.makeText(getApplicationContext(), "Thank You , Your Total : " + totalScore, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz" + editTextName );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}