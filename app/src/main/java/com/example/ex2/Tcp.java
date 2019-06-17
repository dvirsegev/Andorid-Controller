package com.example.ex2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Tcp  extends AsyncTask<String, String, Void>  {
    private BlockingQueue<String> queue = new LinkedBlockingDeque<>();

    @Override
    protected Void doInBackground(String... strings) {
                    try {
                        Socket socket = new Socket(strings[0], Integer.parseInt(strings[1]));
                        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                        try {
                            while(true) {
                                writer.write((queue.take() + "\r\n").getBytes());
                                writer.flush();
                            }
            } catch (IOException e) {
                Log.e("TCP", "S: Error", e);
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            Log.e("TCP", "C: Error", e);
        }
        return null;
    }
    public void Send(String str) {
        try {
            this.queue.put(str);
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
