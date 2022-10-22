package com.example.dteam_dpots.ItemView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

public class MySeekBar extends androidx.appcompat.widget.AppCompatSeekBar {
    public int[][] state = new int[6][2];
    public int current;
    public String[] colors = new String[]{
            "#FF0000",
            "#FF7F00",
            "#FFFF00",
            "#00FF00",
            "#0000FF",
            "#4B0082"
    };


    public MySeekBar(Context context) {
        super(context);

    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        drawingFunc(c);
    }

    private void drawingFunc(Canvas c) {
        /*Value necessary*/
        //get thumb height
        int thumb_height = this.getThumb().getIntrinsicHeight();

        //left offset position
        int offsetLeft = this.getPaddingLeft();

        //get center Height of seekbar
        int center = this.getHeight() / 2;

        //get thumb position
        int thumb_x = getThumb().getBounds().left + offsetLeft;
        Log.d("Draw for", "current: " + current);
        /*Drawing*/
        paint.setStrokeWidth(10);

        if (this.current == 0) {
            state[this.current][0] = offsetLeft;
        }
        /*draw the value before*/
        for (int i = 0; i < this.current; i++) {
            paint.setColor(Color.parseColor(colors[i]));
            Log.d("Color ", String.valueOf(colors[i]));
            Log.d("Draw for pot number:  ", String.valueOf(i));
            Log.d("start at:  ", String.valueOf(state[i][0]));
            Log.d("End at:  ", String.valueOf(state[i][1]));
            c.drawLine(state[i][0], center, state[i][1], center, paint);
        }
        if (this.current < 6) {
            if (this.current > 0)
                state[this.current][0] = state[this.current - 1][1]; //set the start position
            state[this.current][1] = thumb_x; //set end position

            paint.setColor(Color.parseColor(colors[current])); //set color
            c.drawLine(state[this.current][0], center, thumb_x, center, paint);
            Log.d("drawing bot number: ", String.valueOf(this.current));
            Log.d("start at:  ", String.valueOf(state[this.current][0]));
            Log.d("End at:  ", String.valueOf(state[this.current][1]));

        }
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        //draw text center of the thumb
        float textWidth = paint.measureText(String.valueOf(this.getProgress()));
        c.drawText(String.valueOf(this.getProgress()), thumb_x - textWidth / 2, center + thumb_height, paint);

    }
}