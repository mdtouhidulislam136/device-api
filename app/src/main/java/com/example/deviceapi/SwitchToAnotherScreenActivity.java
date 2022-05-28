package com.example.deviceapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SwitchToAnotherScreenActivity extends AppCompatActivity
        implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_to_another_screen);
    }

    public void startMonitoringSensors(View view) {
        // start accelerometer sensors monitoring here
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometerSensor != null) {
            // we have an accelerometer on our device
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // i get sensor events here
        float xSensorValue = event.values[0];
        float ySensorValue = event.values[1];

        TextView xSensorTextView = (TextView) findViewById(R.id.xSensorTextview);
        TextView ySensorTextView = (TextView) findViewById(R.id.ySensorTextview);

        xSensorTextView.setText( " X:" + xSensorValue);
        ySensorTextView.setText( " Y:" + ySensorValue);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}