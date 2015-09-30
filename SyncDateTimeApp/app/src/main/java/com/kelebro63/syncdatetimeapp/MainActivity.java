package com.kelebro63.syncdatetimeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kelebro63.syncdatetimeapp.dateTimeConverter.UniversalDateTime;

import org.joda.time.DateTime;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGetServerTime;
    private TextView tvDeviseTimeToServer;
    private TextView tvDisplacement;
    private TextView tvDeviseTime;
    private TextView tvServiceTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetServerTime = (Button) findViewById(R.id.button_server_time);
        tvDisplacement = (TextView) findViewById(R.id.tv_displacement);
        tvDeviseTime = (TextView) findViewById(R.id.tv_time_getter_from_device);
        tvDeviseTimeToServer = (TextView) findViewById(R.id.tv_time_getter_from_device_for_server);
        tvServiceTime = (TextView) findViewById(R.id.tv_server_time);
        btnGetServerTime.setOnClickListener(this);
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
            case R.id.button_server_time:
                DateTime dateTime = new DateTime(new Date(1443547200000L));
                UniversalDateTime universalDateTime = UniversalDateTime.universalDateTimeGetterFromServer(dateTime); //create instance UniversalDateTime with serverTime
                tvServiceTime.setText(String.valueOf(universalDateTime.getServerTime().toString("MM/dd/yyyy HH:mm:ss")));
                universalDateTime.CalculateDisplacementTime(new DateTime(new Date()));
                tvDisplacement.setText(String.valueOf(UniversalDateTime.displacementTime));
                tvDeviseTimeToServer.setText(String.valueOf(UniversalDateTime.universalDateTimeGetterFromDevice(new DateTime(new Date())).getServerTime().toString("MM/dd/yyyy HH:mm:ss")));
                tvDeviseTime.setText(String.valueOf(new Date()));
                break;
        }
    }
}
