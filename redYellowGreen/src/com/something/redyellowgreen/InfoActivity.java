package com.something.redyellowgreen;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.swarmconnect.Swarm;
import com.swarmconnect.SwarmActivity;
import com.swarmconnect.SwarmLeaderboard;



public class InfoActivity extends SwarmActivity   {

	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private TextView textView2;

    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
    
        super.onCreate(savedInstanceState);
        if (Global.ivar5 ==0){
        	Swarm.setAllowGuests(true);
    	  Swarm.init(this, 17005, "453d3dfa8ea326346c7dde2620584e19");
        }
        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
        
        
        
        setContentView(R.layout.infoactivity);


        
        
        
        textView2 = (TextView) findViewById(R.id.textView2);

        
        
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
  	    button1.setOnClickListener(new View.OnClickListener() {
  	     public void onClick(View v) {
  	    	Intent intent = new Intent(Intent.ACTION_MAIN);
  	    	intent.addCategory(Intent.CATEGORY_HOME);
  	    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  	    	startActivity(intent);
  	     }
  	 });
  	  button2.setOnClickListener(new View.OnClickListener() {
   	     public void onClick(View v) {
   	    	final Intent i = new Intent(InfoActivity.this,Information.class);
	        startActivity(i);
   	     }
   	 });
  	 button3.setOnClickListener(new View.OnClickListener() {
  	     public void onClick(View v) {
  	    	 overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
  	    	final Intent i = new Intent(InfoActivity.this,GoActivity.class);
	        startActivity(i);
  	     }
  	 });
  	 button4.setOnClickListener(new View.OnClickListener() {
  	     public void onClick(View v) {
  	          SwarmLeaderboard.showLeaderboard(19285);
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
//@Override
//public void onResume() {
 //   super.onResume();
//
    // Resume the AdView.
 //   adView.resume();
//}
//
//@Override
//public void onPause() {
    // Pause the AdView.
 //   adView.pause();
//
  //  super.onPause();
//}

//@Override
//public void onDestroy() {
    // Destroy the AdView.
 //   adView.destroy();
//
  //  super.onDestroy();
//}
}
