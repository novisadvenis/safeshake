package com.safeshake3.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.safeshake3.R;

import java.util.List;

public class Generator extends ParentActivity implements SensorEventListener {
    private  SensorManager sensorMgr;
    private Sensor shake;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        sensorMgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        shake = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



        sensorMgr = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors =
                sensorMgr.getSensorList(Sensor.TYPE_ACCELEROMETER);
        super.onCreate(savedInstanceState);
    }

    final int MENU_ID = R.id.generator;
    final int LAYOUT_ID = R.layout.activity_generator;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        TextView textView = (TextView) findViewById(R.id.textView4);

        float acceleration = sensorEvent.values[0];
        textView.setText("Schüttel durchgeführt"+acceleration);
        //text.invalidate();
    }

    @Override
    protected void onResume() {
        sensorMgr.registerListener(this, shake, SensorManager.SENSOR_ACCELEROMETER);
        super.onResume();
    }

    @Override
    protected void onPause() {
        sensorMgr.unregisterListener(this, shake);

        super.onPause();
    }
    @Override
    protected int getResourceLayoutId() {
        return LAYOUT_ID;
    }

    @Override
    protected int getResourceMenuId() {
        return MENU_ID;
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}