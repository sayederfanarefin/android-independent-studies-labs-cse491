package info.sayederfanarefin.lab4part1erfan;

/**
 * Created by SayedErfan on 7/4/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TASKS = "tasks";
    public static final int COLUMN_YEAR= 0;
    public static final int COLUMN_MONTH= 0;
    public static final int COLUMN_DAY= 0;
    public static final String COLUMN_TODOTASK = "toDoTask";
    public static final int COLUMN_HOUR = 0;
    public static final int COLUMN_MIN= 0;

    public static final String COLUMN_ID = "_id";

    private static final String DATABASE_NAME = "tasks.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_TASKS + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TODOTASK + " text not null, "
            + COLUMN_YEAR + " integer not null, "
            + COLUMN_MONTH + " integer not null, "
            + COLUMN_DAY + " integer not null, "
            + COLUMN_HOUR + " integer not null, "
            + COLUMN_MIN + " integer not null, "
            +");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }
}
