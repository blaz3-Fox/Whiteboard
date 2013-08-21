package com.example.whiteboard;

import java.net.UnknownHostException;

import com.alex.framework.Message;
import com.alex.framework.client.AsyncGroup;

public class receivedInput extends AsyncGroup{

	public receivedInput(String groupName) throws UnknownHostException {
		super(groupName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMessageReceived(Message msg) {
		if ( msg.Payload != null ) {
		if ( msg.Payload.startsWith("0") ) {
			String[] parts = msg.Payload.split(":");
			board.moveTo(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]));
		}
		if (msg.Payload.startsWith("1")) {
			String[] parts = msg.Payload.split(":");
			board.drawLineTo(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]));
			}
		}
	}
	
	
	public WhiteboardReceiver board;
	
	
	
	public void moveTo( float pointX, float pointY ) {
		sendMessage("0:" + pointX + ":" + pointY);
	}
	
	public void lineTo( float pointX, float pointY ) {
		sendMessage("1:" + pointX + ":" + pointY );
	}

}
