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
	Grid grid = new Grid();
	boolean player = true;
	private float x = 0;
	private float y = 0;

	public GUI(Context context) {
		super(context);
		mcontext = context;
		setOnTouchListener(this);
	}

	public boolean onTouch(View v, MotionEvent event) {
		int Action = event.getAction();
		switch (Action) {
		case MotionEvent.ACTION_DOWN:
			x = event.getX();
			y = event.getY();
			gameengine(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			
			break;
		case MotionEvent.ACTION_UP:
			
			break;
		}

		return true;
	}

	public void gameengine(float x, float y) {
		checkCoord((int) x, (int) y);
	}

	public Boolean checkCoord(int x, int y) {
		for (int i = 1; i < 14; i++) {
			for (int j = 1; j < 14; j++) {
				int left = grid.grid[i][j].left;
				int right = grid.grid[i][j].right;
				int bot = grid.grid[i][j].bottom;
				int top = grid.grid[i][j].top;
				if (left < x && right > x && top < y && bot > y && grid.grid[i][j].getPlayer() == 0) {
					if (player) {
						grid.grid[i][j].setPlayer(1);
						grid.grid[i][j].r = 255;
						grid.grid[i][j].b = 0;
						grid.grid[i][j].g = 0;
						if(grid.checkWin(1)) grid.createGrid();
						player = false;
					} else {
						grid.grid[i][j].setPlayer(2);
						grid.grid[i][j].r = 0;
						grid.grid[i][j].b = 255;
						grid.grid[i][j].g = 0;
						if(grid.checkWin(2)) grid.createGrid();						
						player = true;
					}
					return true;
				}
			}
		}
		return false;
	}

	public void onDraw(Canvas canvas) {
		drawBoard(canvas);
	}

	public void drawBoard(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		paint.setTextSize(30);
		paint.setAntiAlias(true);
		canvas.drawColor(Color.BLACK);
		Rect tester = new Rect(10, 10, 40, 40);
		for (int i = 1; i < 14; i++) {
			for (int j = 1; j < 14; j++) {
				paint.setColor(Color.rgb(grid.grid[i][j].r, grid.grid[i][j].g,
						grid.grid[i][j].b));
				tester.bottom = grid.grid[i][j].bottom;
				tester.top = grid.grid[i][j].top;
				tester.right = grid.grid[i][j].right;
				tester.left = grid.grid[i][j].left;
				canvas.drawRect(tester, paint);
			}
		}
	}
}