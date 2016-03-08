package info.sayederfanarefin.lab4part1erfan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class addNewTask extends ActionBarActivity {
    String task ;
    EditText et;
    Button bt ;
    DatePicker dp;
    TimePicker tp;
    int day,month,year,hour,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        bt = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);
        dp = (DatePicker) findViewById(R.id.datePicker);
        tp = (TimePicker) findViewById(R.id.timePicker);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = et.getText().toString();
                day = dp.getDayOfMonth();
                month = dp.getMonth() + 1;
                year = dp.getYear();
                hour = tp.getCurrentHour();
                min = tp.getCurrentMinute();

                Toast toast  = Toast.makeText(getApplicationContext(), task+" due->"+day+"/"+month+"/"+year+"("+hour+":"+min+")", Toast.LENGTH_SHORT);
                toast.show();
                //Toast toast  = Toast.makeText(getApplicationContext(), ""+hour+":"+min, Toast.LENGTH_SHORT);
                //toast.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_task, menu);
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
