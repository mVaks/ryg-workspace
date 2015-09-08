package com.something.redyellowgreen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.swarmconnect.SwarmActivity;

public class Information extends SwarmActivity {
	private Button button1;
	private MediaPlayer mp;
    protected void onCreate(Bundle savedInstanceState) {
    	//Added a comment
    	
   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
        mp.setLooping(false);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
        button1 = (Button) findViewById(R.id.infobutton1);
        button1.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
   	        	final Intent i = new Intent(Information.this,Information2.class);
   	        	mp.release(); mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
    	        mp.start();
   	        	onDestroy();
       	        startActivity(i);
    }
        });
    }
    @Override
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
       button1=null;
       finish();
   }

}
