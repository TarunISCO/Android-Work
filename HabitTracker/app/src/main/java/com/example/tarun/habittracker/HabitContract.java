package com.example.tarun.habittracker;

import android.provider.BaseColumns;

/**
 * Created by tarun on 10/7/17.
 */

public class HabitContract {

    public HabitContract() {
        // Empty required constructor.
    }

    public class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "Habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_COMMENT = "comment";

        public final static int HABIT_WORKOUT = 0;
        public final static int HABIT_PROGRAMMING = 1;
    }
}
