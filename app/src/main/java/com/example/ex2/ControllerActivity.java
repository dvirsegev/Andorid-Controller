package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ControllerActivity extends AppCompatActivity implements ObserverInterface {
    String message;
    Tcp tcp = new Tcp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        Intent intent = getIntent();
        String ip = intent.getStringExtra("Ip");
        String port = intent.getStringExtra("Port");
        try {
            tcp.execute(ip, port, null);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        DrawShapes drawShapes = new DrawShapes(this);
        drawShapes.addToObserver(this);
        setContentView(drawShapes);

    }

    @Override
    public void update() {
        tcp.Send("hi");
    }
}