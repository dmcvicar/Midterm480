package cs480.midterm480.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.sql.SQLException;
import java.util.List;

import cs480.midterm480.R;
import cs480.midterm480.db.Student;
import cs480.midterm480.db.StudentDataSource;

public class DisplayActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        StudentDataSource dataSource = new StudentDataSource(this);
        try { dataSource.open(); } catch(SQLException sqle){};

        List<Student> students = dataSource.getAllStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this,
                android.R.layout.simple_list_item_1, students);
        setListAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
