package com.example.whiteboard;

public interface WhiteboardReceiver {
	public void moveTo( float pointX, float pointY );
	public void drawLineTo( float pointX, float pointY );
}
