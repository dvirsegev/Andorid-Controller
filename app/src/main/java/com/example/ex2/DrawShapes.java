package com.example.ex2;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import androidx.core.view.MotionEventCompat;

import java.util.LinkedList;
import java.util.List;

public class DrawShapes extends View implements ObservableInterface {
    Canvas canvas;
    float x;
    float y;
    int radious;
    RectF rectF;
    boolean firsttime = true;
    private final String alironCommand = "set /controls/flight/aileron ";
    private final String elevatorCommand = "set /controls/flight/elevator ";
    private List<ObserverInterface> obs = new LinkedList<>();

    public DrawShapes(Context context) {
        super(context);

    }

    @Override
    public void onDraw(Canvas canvas) {

        this.canvas = canvas;
        DrawTheShapes();
    }

    private void DrawTheShapes() {
        if (firsttime) {
            x = getWidth() / 2;
            y = getHeight() / 2;
            firsttime = false;
        }
        int color = 0xFF03A9F4;
        setBackgroundColor(color);
        Paint paint = new Paint();
        paint.setColor(0xFFA8BABB);
        paint.setStrokeWidth(3);
        this.rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawOval(rectF, paint);
        paint.setColor(0xFF126D17);
        this.radious = 150;
        canvas.drawCircle(x, y, radious, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                float xEvent = event.getX();
                float yEvent = event.getY();
                if (insideRect(xEvent, yEvent)) {
                    x = event.getX();
                    y = event.getY();
                }
                notifyObservers(normelizeAilron(x) + "" + alironCommand);
                notifyObservers(normelizeElevator(y) + "" +  elevatorCommand);
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                restrart();
                invalidate();
                break;
        }
        return true;
    }

    private boolean insideRect(float xEvent, float yEvent) {
        return (this.rectF.contains(xEvent, yEvent) &&
                this.rectF.contains(xEvent, yEvent + this.radious) &&
                this.rectF.contains(xEvent, yEvent - this.radious) &&
                this.rectF.contains(xEvent + this.radious, yEvent) &&
                this.rectF.contains(xEvent - this.radious, yEvent));
    }

    public void restrart() {
        x = getWidth() / 2;
        y = getHeight() / 2;
        notifyObservers("0 " + this.elevatorCommand);
        notifyObservers("0 " + this.alironCommand);
    }

    @Override
    public void addToObserver(ObserverInterface obs) {
        this.obs.add(obs);
    }

    @Override
    public void notifyObservers(String s) {
        for (ObserverInterface obs : this.obs) {
            obs.update(s);
        }
    }

    public float normelizeAilron(float x) {
        return (x - ((getWidth() / 4)) / (getWidth() / 2));
    }

    public float normelizeElevator(float y) {
        return (y - (getHeight() / 4)) / (getHeight() / 2);
    }
}
