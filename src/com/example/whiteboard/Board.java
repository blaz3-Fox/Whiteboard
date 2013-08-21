package com.example.whiteboard;

import java.net.UnknownHostException;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class Board extends View implements WhiteboardReceiver {

	private Paint brush = new Paint();
	private Path path = new Path();
	
	private Path otherPath = new Path();
	private Paint otherBrush = new Paint();
	
	receivedInput networkGroup;
	
	public Board(Context context) throws UnknownHostException {
		super(context);
		brush.setColor(Color.BLACK);
		brush.setStyle(Paint.Style.STROKE);
		brush.setStrokeJoin(Paint.Join.ROUND);
		brush.setStrokeWidth(10);
		
		otherBrush.setColor(Color.BLUE);
		otherBrush.setStyle(Paint.Style.STROKE);
		otherBrush.setStrokeJoin(Paint.Join.ROUND);
		otherBrush.setStrokeWidth(10);
		
		networkGroup = new receivedInput("Lars Playhouse");
		networkGroup.board = this;
	}
	
	@Override
	public void onDraw( Canvas canvas ) {
		canvas.drawPath(path, brush);
		canvas.drawPath(otherPath, otherBrush);
	}
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		float pointX = event.getX();
		float pointY = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(pointX, pointY);
			networkGroup.moveTo(pointX, pointY);
			
			return true;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(pointX, pointY);
			networkGroup.lineTo(pointX, pointY);
			
			break;
		default:
			return false;
			}
		
		postInvalidate();
		
		
		return false;
	}

	@Override
	public void moveTo(float pointX, float pointY) {
		otherPath.moveTo(pointX, pointY);
		
	}

	@Override
	public void drawLineTo(float pointX, float pointY) {
		otherPath.lineTo(pointX, pointY);
		
	}
	
	
	
	
}
