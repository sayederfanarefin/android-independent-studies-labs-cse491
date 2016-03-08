package info.sayederfanarefin.lab4part1erfan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SayedErfan on 7/10/2015.
 */
public class TasksDataSource {
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_TODOTASK,
            String.valueOf(MySQLiteHelper.COLUMN_YEAR),
            String.valueOf(MySQLiteHelper.COLUMN_MONTH),
            String.valueOf(MySQLiteHelper.COLUMN_DAY),
            String.valueOf(MySQLiteHelper.COLUMN_HOUR),
            String.valueOf(MySQLiteHelper.COLUMN_MIN)
    };

    public TasksDataSource(Context context) {

        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {

        dbHelper.close();
    }

    public Task createTask(String task, int year, int month, int day, int hour, int min) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TODOTASK, task);
        values.put(String.valueOf(MySQLiteHelper.COLUMN_YEAR), String.valueOf(year));
        values.put(String.valueOf(MySQLiteHelper.COLUMN_MONTH), String.valueOf(month));
        values.put(String.valueOf(MySQLiteHelper.COLUMN_DAY), String.valueOf(day));
        values.put(String.valueOf(MySQLiteHelper.COLUMN_HOUR), String.valueOf(hour));
        values.put(String.valueOf(MySQLiteHelper.COLUMN_MIN), String.valueOf(min));


        long insertId = database.insert(MySQLiteHelper.TABLE_TASKS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TASKS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Task newTask = cursorToComment(cursor);
        cursor.close();
        return newTask;
    }

    public void deleteComment(Task t) {
        long id = t.getId();
        //System.out.println("Comment deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_TASKS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Task> getAllTasks() {
        List<Task> taskss = new ArrayList<Task>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_TASKS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Task comment = cursorToComment(cursor);
            taskss.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return taskss;
    }

    private Task cursorToComment(Cursor cursor) {
        Task tsk = new Task();
        tsk.setId(cursor.getLong(0));
        tsk.setToDoTask(cursor.getString(1));
        tsk.setYear(cursor.getInt(2));
        tsk.setMonth(cursor.getInt(3));
        tsk.setDay(cursor.getInt(4));
        tsk.setHour(cursor.getInt(5));
        tsk.setMin(cursor.getInt(6));
        return tsk;
    }
}
