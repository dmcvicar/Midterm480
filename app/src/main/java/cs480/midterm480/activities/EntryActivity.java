package cs480.midterm480.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.sql.SQLException;

import cs480.midterm480.R;
import cs480.midterm480.db.StudentDataSource;


public class EntryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
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

    public void onSubmit(View view) {

        StudentDataSource dataSource = new StudentDataSource(getApplicationContext());

        try {
            dataSource.open();
        } catch (SQLException sqle) {}

        EditText text = (EditText)findViewById(R.id.edit1);
        String name = text.getText().toString();

        text = (EditText)findViewById(R.id.edit2);
        int eid = Integer.parseInt(text.getText().toString());

        text = (EditText)findViewById(R.id.edit3);
        String major = text.getText().toString();

        RadioGroup buttons = (RadioGroup)findViewById(R.id.gender_buttons);
        RadioButton checkedButton = (RadioButton)findViewById(buttons.getCheckedRadioButtonId());
        String gender = checkedButton.getText().toString();

        dataSource.createStudent(name,eid,major,gender);
        dataSource.close();

    }

    public void onDisplay(View view) {

        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);

    }
}
