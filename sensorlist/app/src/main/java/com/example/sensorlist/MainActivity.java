package com.example.sensorlist;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView T1;
    SensorManager sensorManager;
    List<Sensor> devicesensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        T1=(TextView)  findViewById(R.id.textView);
        sensorManager=(SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        devicesensor=sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor: devicesensor)
        {
            T1.setText(T1.getText()+"\n"+sensor.getName());
        }
    }
}