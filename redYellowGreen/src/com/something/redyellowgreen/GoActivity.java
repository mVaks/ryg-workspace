package com.something.redyellowgreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ImageView;

import com.swarmconnect.SwarmActivity;

public class GoActivity extends SwarmActivity {
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
	        setContentView(R.layout.go);
	        final Intent i = new Intent(GoActivity.this,RedActivity.class);
	        
			Thread splashscreen = new Thread(){
				public void run(){
					try {
						sleep(400);
					} catch (InterruptedException e) {
						
					}finally{		
						Global.ivar4=0;
						Global.ivar1=0;
						MyApplication.started = System.currentTimeMillis();
						 overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
						 onDestroy();
						startActivity(i);
						finish();
					}
				}
			};
			splashscreen.start();}
	 
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    @SuppressWarnings("deprecation")
	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event)  {
	        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
	                && keyCode == KeyEvent.KEYCODE_BACK
	                && event.getRepeatCount() == 0) {
	            Log.d("CDA", "onKeyDown Called");
	            onBackPressed();
	        }

	        return super.onKeyDown(keyCode, event);
	    }

	    @Override
	    public void onBackPressed() {
	       Log.d("CDA", "onBackPressed Called");
	       Intent setIntent = new Intent(Intent.ACTION_MAIN);
	       setIntent.addCategory(Intent.CATEGORY_HOME);
	       setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	       startActivity(setIntent);
	    }
	    public void onDestroy()
	    {

	       super.onDestroy();

	       ImageView imageview1 = (ImageView) findViewById(R.id.imageView1);
	       imageview1=null;
	       finish();
	   }
}
