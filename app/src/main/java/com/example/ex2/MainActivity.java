package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = (Button) findViewById(R.id.button);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText IP =
                        (EditText)findViewById(R.id.editText);
                EditText Port =
                        (EditText)findViewById(R.id.editText2);
                String ip = IP.getText().toString();
                String port = Port.getText().toString();
                Intent intent = new Intent(MainActivity.this, ControllerActivity.class);
                intent.putExtra("Ip", ip);
                intent.putExtra("Port", port);

                startActivity ( intent );
            }
        });
    }
}
