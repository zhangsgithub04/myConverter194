package com.example.myconverter19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.button:
                // Do something
                EditText milesinput = (EditText) findViewById(R.id.min);
                milesinput.setText("100");

        }
    }
}
