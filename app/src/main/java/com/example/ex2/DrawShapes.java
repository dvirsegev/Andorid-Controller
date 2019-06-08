package com.example.ex2;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.graphics.Canvas;

import androidx.core.view.MotionEventCompat;

public class DrawShapes extends View {
    Canvas canvas;
    float x ;
    float y ;

    public DrawShapes(Context context) {
        super(context);
        x = getWidth() / 2;
        y = getHeight() / 2;
    }

    @Override
    public void onDraw(Canvas canvas) {
        this.canvas = canvas;
        DrawTheShapes();
    }

    private void DrawTheShapes() {
        int color = 0xFF03A9F4;
        setBackgroundColor(color);
        Paint paint = new Paint();
        paint.setColor(0xFFA8BABB);
        paint.setStrokeWidth(3);
        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawOval(rect, paint);
        paint.setColor(0xFF126D17);
        canvas.drawCircle(x, y, 150, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                int pointerIndex = MotionEventCompat.getActionIndex(event);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                 x = event.getX();
                y = event.getY();
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                x = getWidth() / 2 ;
                y = getHeight() / 2 ;
                invalidate();
                break;
        }
        return true;
    }
}
