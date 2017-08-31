package com.example.testsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AccelSensorActivity extends Activity implements SensorEventListener {

	private SensorManager manager = null;
	private TextView textView01 = null;
	private TextView textView02 = null;
	private TextView textView03 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelsensor);
		
		textView01 = (TextView)findViewById(R.id.text01_id);
		textView02 = (TextView)findViewById(R.id.text02_id);
		textView03 = (TextView)findViewById(R.id.text03_id);
		
		manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE); 
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		manager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			textView01.setText("x: " + String.valueOf(event.values[0]));
			textView02.setText("y: " + String.valueOf(event.values[1]));
			textView03.setText("z: " + String.valueOf(event.values[2]));
		}
		
	}
}
