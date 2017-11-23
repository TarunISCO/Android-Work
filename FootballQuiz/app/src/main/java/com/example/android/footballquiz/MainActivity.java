package com.example.android.footballquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

class Question {
    String que;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    char ans;

    Question(String q, String a, String b, String c, String d,char ch) {
        this.que = q;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.ans = ch;

    }

    private char getAnswer() {
        return this.ans;
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Question[] questions = new Question[4];
    questions[0] = new Question("Which of the following country won the Football World Cup maximum times?", "Germany", "Italy", "Argentina", "Brazil", 'D');
    questions[1] = new Question("Who among the following players scored the maximum goals in Football World Cup?", "Jurgen Klinsmann", "Maradona", "Miroslave Klose", "Pele", 'C');
    questions[2] = new Question("Which of the following team does not play in stripes?", "Newcastle", "Southampton", "Tottenham Hotspur", "Lincoln City", 'C');
    questions[3] = new Question("Which country hosted the first Football World Cup?", "America", "Argentina", "Brazil", "Uruguay", 'D');
    questions[4] = new Question("Who among the following achieved the first World Cup hat-trick?", "Johino", "Bert Patenaude", "Lucian Laurent", "Pele", 'C');

    RadioGroup optionsGroup = (RadioGroup) findViewById(R.id.options_radioGroup);
    int i;
    int correctAnswers = 0;
    public void displayQuestion(int i) {
        TextView ques = (TextView) findViewById(R.id.question_text_view);
        RadioButton optionA = (RadioButton) findViewById(R.id.option_A);
        RadioButton optionB = (RadioButton) findViewById(R.id.option_B);
        RadioButton optionC = (RadioButton) findViewById(R.id.option_C);
        RadioButton optionD = (RadioButton) findViewById(R.id.option_D);
        ques.setText(questions[i].que);
        optionA.setText(questions[i].optionA);
        optionB.setText(questions[i].optionB);
        optionC.setText(questions[i].optionC);
        optionD.setText(questions[i].optionD);
    }

    public void startQuiz(View view) {
        i = 0;
        Button bt = (Button) findViewById(R.id.start_quiz);
        bt.setVisibility(View.INVISIBLE);
        optionsGroup.setVisibility(View.VISIBLE);
        Button sb = (Button) findViewById(R.id.submit_button);
        sb.setVisibility(View.VISIBLE);
        displayQuestion(i);
    }

    public void printResult() {
        Button bt = (Button) findViewById(R.id.start_quiz);
        bt.setVisibility(View.VISIBLE);
        optionsGroup.setVisibility(View.INVISIBLE);
        Button sb = (Button) findViewById(R.id.submit_button);
        sb.setVisibility(View.INVISIBLE);
        String result = "You scored " + correctAnswers + " out of 5!";
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }

    public void submitAnswer(View view) {
        char selected;
        switch(optionsGroup.getCheckedRadioButtonId()) {
            case R.id.option_A : selected = 'A';break;
            case R.id.option_B : selected = 'B';break;
            case R.id.option_C : selected = 'C';break;
            case R.id.option_D : selected = 'D';break;
        }
        if(selected == questions[i].getAnswer()) {
            correctAnswers++;
            Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();

        i++;
        if(i > 4) {
            printResult();
        }
        else
            displayQuestion(i);
    }



}
