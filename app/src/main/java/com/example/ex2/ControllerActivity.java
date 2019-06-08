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

public class ControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        Intent intent = getIntent();
        String ip = intent.getStringExtra("Ip");
        String port = intent.getStringExtra("Port");
        setContentView(new DrawShapes(this));
//        conncetServer(ip,port);
    }

    public void conncetServer(String ip, String port) {
        try {
            InetAddress serverAddr = InetAddress.getByName(ip);
            Socket socket = new Socket(ip, Integer.parseInt(port));
            try {
                BufferedWriter writer;
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            writer.write();
                writer.flush();
            } catch (IOException e) {
                Log.e("TCP", "S: Error", e);
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            Log.e("TCP", "C: Error", e);
        }

    }

}