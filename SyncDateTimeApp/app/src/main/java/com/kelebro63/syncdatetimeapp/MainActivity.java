package com.kelebro63.syncdatetimeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGetServerTime;
    private Button btnGetDeviceTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetServerTime = (Button) findViewById(R.id.button_server_time);
        btnGetDeviceTime = (Button) findViewById(R.id.button_device_time);
        btnGetServerTime.setOnClickListener(this);
        btnGetDeviceTime.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.button_server_time:
//                long millisFromServer = DateTimeGetter.getDateTimeGetter(DateTimeGetter.TYPE_SERVER).getTime().getMillis();
//                break;
//
//            case R.id.button_device_time:
//                long millisFromDevice = DateTimeGetter.getDateTimeGetter(DateTimeGetter.TYPE_DEVICE).getTime().getMillis();
//                break;
        }
    }
}
