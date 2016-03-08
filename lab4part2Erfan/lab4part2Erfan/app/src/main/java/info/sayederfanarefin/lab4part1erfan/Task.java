package info.sayederfanarefin.lab4part1erfan;

import android.widget.DatePicker;

/**
 * Created by SayedErfan on 7/10/2015.
 */
public class Task {
    private long id;
    private String toDoTask;
    private int day,month,year,hour,min;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getToDoTask() {

        return toDoTask;
    }

    public void setToDoTask(String ss) {

        this.toDoTask = ss;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int temp) {

        this.year = temp;
    }
    public int getMonth() {

        return month;
    }

    public void setMonth(int temp) {

        this.month = temp;
    }


    public int getDay() {

        return day;
    }

    public void setDay(int temp) {

        this.day = temp;
    }

    public int getHour() {

        return hour;
    }

    public void setHour(int temp) {

        this.hour = temp;
    }

    public int getMin() {

        return min;
    }

    public void setMin(int temp) {

        this.min = temp;
    }
    public String toString()
    {
        return toDoTask;
    }
}
