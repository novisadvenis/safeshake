package com.safeshake3.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.safeshake3.R;
import com.safeshake3.model.Password;
import com.squareup.seismic.ShakeDetector;

public class Generator extends ParentActivity implements ShakeDetector.Listener {
    private SensorManager sensorMgr;
    private ShakeDetector shake;
    private SeekBar seekBar;
    private TextView seekBarValue, passwordField;
    final int MENU_ID = R.id.generator;
    final int LAYOUT_ID = R.layout.activity_generator;
    private Switch uppercaseSwitch, lowercaseSwitch, numberSwitch, specialSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorMgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        shake = new ShakeDetector(this);
        shake.start(sensorMgr);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        uppercaseSwitch = (Switch) findViewById(R.id.generator_uppercase_switch);
        lowercaseSwitch = (Switch) findViewById(R.id.generator_lowercase_switch);
        numberSwitch = (Switch) findViewById(R.id.generator_number_switch);
        specialSwitch = (Switch) findViewById(R.id.generator_special_switch);
        seekBarValue = (TextView) findViewById(R.id.seekValue);
        passwordField = (TextView) findViewById(R.id.generator_password_value);

        uppercaseSwitch.setOnCheckedChangeListener(new onCheckedListener());
        lowercaseSwitch.setOnCheckedChangeListener(new onCheckedListener());
        numberSwitch.setOnCheckedChangeListener(new onCheckedListener());
        specialSwitch.setOnCheckedChangeListener(new onCheckedListener());


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(100);
                seekBar.setMin(10);

                Log.d("Seek bar value", seekBar.getProgress() + "");
                seekBarValue.setText(seekBar.getProgress() + "");
                setPasswordField();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

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
    public void hearShake() {
        Toast.makeText(this, "Don't shake me, bro!", Toast.LENGTH_SHORT).show();
    }

    private class onCheckedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            setPasswordField();
        }
    }


    private void setPasswordField() {
        int length = Integer.parseInt(seekBarValue.getText().toString());
        boolean upper = uppercaseSwitch.isChecked();
        boolean lower = lowercaseSwitch.isChecked();
        boolean number = numberSwitch.isChecked();
        boolean special = specialSwitch.isChecked();
        passwordField.setText(Password.generatePassword(length, upper, lower, number, special));
    }


}