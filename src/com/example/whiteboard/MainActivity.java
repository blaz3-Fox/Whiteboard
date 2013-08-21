package com.example.whiteboard;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*RelativeLayout relativeLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams lParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.FILL_PARENT,
                        RelativeLayout.LayoutParams.FILL_PARENT);*/
        try {
        Board view = new Board(this);
        
        setContentView(view);
        view.requestFocus();
        
        //relativeLayout.addView(view);
        
        //setContentView(relativeLayout, lParams);
        } catch ( Exception e ) {
        	Log.e("lars",e.getMessage());
        }
    }
    @Override
    protected void onPause() {
    	super.onPause();
    	finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
