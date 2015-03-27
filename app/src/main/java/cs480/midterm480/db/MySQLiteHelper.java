package cs480.midterm480.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{

    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_ID = "rowid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EID = "eid";
    public static final String COLUMN_MAJOR = "major";
    public static final String COLUMN_GENDER = "gender";

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "CREATE TABLE " + TABLE_STUDENTS
          + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, "
          + COLUMN_NAME + " TEXT NOT NULL, "
          + COLUMN_EID + " TEXT NOT NULL, "
          + COLUMN_MAJOR + " TEXT NOT NULL, "
          + COLUMN_GENDER + " TEXT NOT NULL);";

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
                "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }
}
