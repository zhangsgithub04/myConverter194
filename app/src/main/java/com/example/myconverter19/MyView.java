package com.example.myconverter19;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {

    Bitmap bitmap;

    // Store circles to draw each time the user touches down
    private List<Point> circlePoints;


    // Append new circle each time user presses on screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        circlePoints.add(new Point(Math.round(touchX), Math.round(touchY)));
        // indicate view should be redrawn
        postInvalidate();
        return true;
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        circlePoints=new ArrayList<Point>();


        }



    @Override
    protected void onDraw(Canvas canvas) {
        bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888);

        canvas.drawBitmap(bitmap, 0, 0, null);
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);

        float left = 20;
        float top = 20;
        float right = 50;
        float bottom = 100;
        // Draw each circle onto the view

        canvas.drawLine(left, top, right, bottom, paint);

            canvas.drawCircle(50, 50, 20, paint);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(50, 150, 20, paint);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(50, 250, 20, paint);

            for (Point p : circlePoints) {
                canvas.drawCircle(p.x, p.y, 5, paint);
            }

        }
}
