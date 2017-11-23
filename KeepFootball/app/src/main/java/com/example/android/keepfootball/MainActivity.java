package com.example.android.keepfootball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int goal_one = 0;       // goals of team A
    int goal_two = 0;       // goals of team B
    int ycard_one = 0;      // yellow cards of team A
    int rcard_one = 0;      // red cards of team A
    int ycard_two = 0;      // yellow cards of team B
    int rcard_two = 0;      // red cards of team B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to increase count of goals for team A
    public void goal_A(View v) {
        goal_one = goal_one + 1;
        display_goal_A(goal_one);
    }

    // Method to display goals of team A
    public void display_goal_A(int n) {
        TextView view = (TextView) findViewById(R.id.team_A_goals);
        view.setText(String.valueOf(n));
    }

    // Method to increase count of yellow cards for team A
    public void yellow_card_A(View v) {
        ycard_one = ycard_one + 1;
        display_yellow_A(ycard_one);
    }

    // Method to display yellow cards for team A
    public void display_yellow_A(int n) {
        TextView view = (TextView) findViewById(R.id.team_A_yellow_cards);
        view.setText(String.valueOf(n));
    }

    // Method to increase count of red cards for team A
    public void red_card_A(View v) {
        rcard_one = rcard_one + 1;
        display_red_A(rcard_one);
    }

    // Method to display red cards for team A
    public void display_red_A(int n) {
        TextView view = (TextView) findViewById(R.id.team_A_red_cards);
        view.setText(String.valueOf(n));
    }


    // Method to increase count of goals for team B
    public void goal_B(View v) {
        goal_two = goal_two + 1;
        display_goal_B(goal_two);
    }

    // Method to display goals of team B
    public void display_goal_B(int n) {
        TextView view = (TextView) findViewById(R.id.team_B_goals);
        view.setText(String.valueOf(n));
    }

    // Method to increase count of yellow cards for team B
    public void yellow_card_B(View v) {
        ycard_two = ycard_two + 1;
        display_yellow_B(ycard_two);
    }

    // Method to display yellow cards for team B
    public void display_yellow_B(int n) {
        TextView view = (TextView) findViewById(R.id.team_B_yellow_cards);
        view.setText(String.valueOf(n));
    }

    // Method to increase count of red cards for team B
    public void red_card_B(View v) {
        rcard_two = rcard_two + 1;
        display_red_B(rcard_two);
    }

    // Method to display red cards for team B
    public void display_red_B(int n) {
        TextView view = (TextView) findViewById(R.id.team_B_red_cards);
        view.setText(String.valueOf(n));
    }

    // Method to reset all the counts to zero
    public void reset(View v) {
        goal_one = 0;
        goal_two = 0;
        ycard_one = 0;
        rcard_one = 0;
        ycard_two = 0;
        rcard_two = 0;
        display_goal_A(goal_one);
        display_goal_B(goal_two);
        display_yellow_A(ycard_one);
        display_red_A(rcard_one);
        display_yellow_B(ycard_two);
        display_red_B(rcard_two);

    }

}
