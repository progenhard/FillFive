package com.example.fillfive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GUI extends View implements OnTouchListener {
	Context mcontext;
	private float x = 0;
	private float y = 0;
	
	public GUI(Context context) {
		super(context);
		mcontext = context;
		setOnTouchListener(this);
	}

	public boolean onTouch(View v, MotionEvent event)
	{
	  int Action=event.getAction();
	  switch(Action)
	  {
	    case MotionEvent.ACTION_DOWN: 
	    	x = event.getX();
	    	y = event.getY();
	    	invalidate ();
	    break;
	    case MotionEvent.ACTION_MOVE: ; break;
	    case MotionEvent.ACTION_UP: ; break;
	  }

	  return true;
	}

	
	public void onDraw(Canvas canvas) {
		drawBoard(canvas);
	}
	
	public void drawBoard(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		paint.setTextSize(30);
		paint.setAntiAlias(true);
		canvas.drawColor(Color.BLACK);
    	Rect tester = new Rect(10, 10, 40, 40);
        for(int i = 1; i < 14; i++){
        	tester.bottom += 31;
            tester.top += 31;
            tester.left = 10;
            tester.right = 40;
	        for(int j = 1; j < 14; j++){
	        	tester.left += 31;
	            tester.right += 31;
	        	canvas.drawRect(tester, paint);
           }
        }
	}
}