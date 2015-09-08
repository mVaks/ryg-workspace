package com.something.redyellowgreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.swarmconnect.SwarmActivity;

public class GreenActivity extends SwarmActivity {
	private Button button1;
	private Button button2;
	private Button button3;
	private TextView text2;
	private TextView text3;
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
	        setContentView(R.layout.green);
	        text3 = (TextView)findViewById(R.id.textView3);
	        //AdView mAdView = (AdView) findViewById(R.id.adView);
	        //AdRequest adRequest = new AdRequest.Builder().build();
	        //mAdView.loadAd(adRequest);
	        boolean time = Global.checkTime();
	        if (!time){
	        	final Intent i = new Intent(GreenActivity.this,GameOverActivity.class);
    	        startActivity(i);
	        }
	        new CountDownTimer(10000-(System.currentTimeMillis()-MyApplication.started), 1000) {//CountDownTimer(edittext1.getText()+edittext2.getText()) also parse it to long

	        	 public void onTick(long millisUntilFinished) {
	        	     text3.setText("" + (millisUntilFinished / 1000.0));
	        	  //here you can have your logic to set text to edittext
	        	 }

	        	 public void onFinish() {
	        		 boolean time = Global.checkTime();
	     	        if (!time){	
	     	        	final Intent i = new Intent(GreenActivity.this,GameOverActivity.class);
	         	        startActivity(i);
	     	        }
	        	 }
	        	}
	        	.start();
	        text2 = (TextView)findViewById(R.id.textView2);
	        text2.setText("" + Global.ivar1);
	        button1 = (Button) findViewById(R.id.button1);
	        button2 = (Button) findViewById(R.id.button2);
	        button3= (Button) findViewById(R.id.button3);
	        //text1 = (TextView)findViewById(R.id.textView1);
	     // text1.setText((""+(10-(System.currentTimeMillis() - MyApplication.started)/1000.0)));
	        
       	    button3.setOnClickListener(new View.OnClickListener() {
       	     public void onClick(View v) {
       	    	boolean time = Global.checkTime();
    	        if (!time){
    	        	final Intent i = new Intent(GreenActivity.this,GameOverActivity.class);
    	        	onDestroy();
        	        startActivity(i);
    	        }
       	    	Global.ivar1+=1;
       	    	Global.ivar4+=1;
       	    	final Intent i = new Intent(GreenActivity.this,MainActivity.class);
       	    	onDestroy();
    	        startActivity(i);
       	     }
       	 });
       	 button1.setOnClickListener(new View.OnClickListener() {
      	     public void onClick(View v) {
      	    	final Intent i = new Intent(GreenActivity.this,GameOverActivity.class); 
      	    	onDestroy();
   	        startActivity(i);
      	     }
      	 });
       	 button2.setOnClickListener(new View.OnClickListener() {
      	     public void onClick(View v) {
      	    	final Intent i = new Intent(GreenActivity.this,GameOverActivity.class);
      	    	onDestroy();
   	        startActivity(i);
      	     }
      	 });
	        
	 }
	    
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
	       button2=null;
	       button3=null;
	       finish();
	   }
}