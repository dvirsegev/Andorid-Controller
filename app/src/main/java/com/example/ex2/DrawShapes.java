package com.example.ex2;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.graphics.Color;
import android.graphics.Canvas;

public class DrawShapes extends View {
        public DrawShapes(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas) {
            int color =0xFF03A9F4;
            setBackgroundColor(color);
            Paint paint=new Paint();
            paint.setColor(Color.GRAY);
            paint.setStrokeWidth(3);
            RectF rect = new RectF(0,0,getWidth(),getHeight());
            canvas.drawOval(rect, paint);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(getWidth()/2, getHeight()/2, 150,paint);
        }
}
