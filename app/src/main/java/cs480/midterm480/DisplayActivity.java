package cs480.midterm480;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTextViews();
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

    private void setTextViews() {
        TextView textView = (TextView)findViewById(R.id.text1);
        textView.setText(getIntent().getStringExtra("1"));
        textView = (TextView)findViewById(R.id.text2);
        textView.setText(getIntent().getStringExtra("2"));
        textView = (TextView)findViewById(R.id.text3);
        textView.setText(getIntent().getStringExtra("3"));
        textView = (TextView)findViewById(R.id.text4);
        textView.setText(getIntent().getStringExtra("4"));
        textView = (TextView)findViewById(R.id.text5);
        textView.setText(getIntent().getStringExtra("5"));
        textView = (TextView)findViewById(R.id.text6);
        textView.setText(getIntent().getStringExtra("6"));
    }
}
