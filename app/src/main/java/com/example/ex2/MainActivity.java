package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = (Button) findViewById(R.id.button);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Button btn = (Button)v;
                TextView tv = (TextView) findViewById(R.id.textView7);
                tv.setText("You pressed " + btn.getText());
            }
        });
    }
}
