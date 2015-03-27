package cs480.midterm480.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper helper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_EID, MySQLiteHelper.COLUMN_MAJOR, MySQLiteHelper.COLUMN_GENDER};

    public StudentDataSource(Context context) {
        helper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public Student createStudent(String name, int eid, String major, String gender) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NAME,name);
        values.put(MySQLiteHelper.COLUMN_EID,eid);
        values.put(MySQLiteHelper.COLUMN_MAJOR,major);
        values.put(MySQLiteHelper.COLUMN_GENDER,gender);

        long insertId = database.insert(MySQLiteHelper.TABLE_STUDENTS, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_STUDENTS, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Student newStudent = cursorToStudent(cursor);
        cursor.close();
        return newStudent;
    }

    public void deleteStudent(Student student) {
        long id = student.getId();
        database.delete(MySQLiteHelper.TABLE_STUDENTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_STUDENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Student student = cursorToStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return students;
    }

    private Student cursorToStudent(Cursor cursor) {
        Student student = new Student();
        student.setId(cursor.getInt(0));
        student.setName(cursor.getString(1));
        student.setEid(cursor.getInt(2));
        student.setMajor(cursor.getString(3));
        student.setGender(cursor.getString(4));
        return student;
    }

}
