package com.something.redyellowgreen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.swarmconnect.SwarmActivity;

public class RedActivity extends SwarmActivity {
	private Button button1;
	private Button button2;
	private Button button3;
	private TextView text2;
	private TextView text3;
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private  CountDownTimer timer;
	private int count;
	private MediaPlayer mp;

	 protected void onCreate(Bundle savedInstanceState) {
	
	        super.onCreate(savedInstanceState);
	        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
	        setContentView(R.layout.red);
	        count = 0;
	       mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
	         mp.setLooping(false);
	        int y = generateNumber();
	        imageView1=(ImageView) findViewById(R.id.imageView1);
	        imageView2=(ImageView) findViewById(R.id.imageView2);
	        imageView3=(ImageView) findViewById(R.id.imageView3);
	        if (y==1){
   	    		imageView2.setVisibility(View.INVISIBLE);
  	        	imageView3.setVisibility(View.INVISIBLE);
  	   	        imageView1.setVisibility(View.VISIBLE);
  	        }
  	        else if(y==2){
  	        	imageView1.setVisibility(View.INVISIBLE);
  	        	imageView3.setVisibility(View.INVISIBLE);
  	   	        imageView2.setVisibility(View.VISIBLE);
  	        }
  	        else{
  	        	imageView1.setVisibility(View.INVISIBLE);
  	        	imageView2.setVisibility(View.INVISIBLE);
  	   	        imageView3.setVisibility(View.VISIBLE);
  	        }
	        text3 = (TextView)findViewById(R.id.textView3);
	        
	        //AdView mAdView = (AdView) findViewById(R.id.adView);
	        //AdRequest adRequest = new AdRequest.Builder().build();
	        //mAdView.loadAd(adRequest);
	       // boolean time = Global.checkTime();
	       // if (!time){	
	       // 	final Intent i = new Intent(RedActivity.this,GameOverActivity.class);
    	   //     startActivity(i);
	     //   }
	        if (timer != null) {
	            timer.cancel();
	        }
	       timer = new CountDownTimer(10000, 10) {//CountDownTimer(edittext1.getText()+edittext2.getText()) also parse it to long

	        	 public void onTick(long millisUntilFinished) {
	        	     text3.setText("" + (millisUntilFinished / 1000.0));
	        	  //here you can have your logic to set text to edittext
	        	 }

	        	 public void onFinish() {
	        		// boolean time = Global.checkTime();
	     	        if (!(Global.ivar4>=15)){	
	     	        	final Intent i = new Intent(RedActivity.this,GameOverActivity.class);
	     	        	 this.cancel();
	     	        	 finish();
	         	        startActivity(i);
	         	      
	     	        }
	     	        Global.ivar4=0;
	     	        this.start();
	        	 }
	        	}
	        	.start();
	        text2 = (TextView)findViewById(R.id.textView2);
	        text2.setText("Score: " + Global.ivar1);
	        button1 = (Button) findViewById(R.id.button1);
	        button2 = (Button) findViewById(R.id.button2);
	        button3= (Button) findViewById(R.id.button3);
	      
	        //text1 = (TextView)findViewById(R.id.textView1);
	        //text1.setText((""+(10-(System.currentTimeMillis() - MyApplication.started)/1000.0)));
      	    button1.setOnClickListener(new View.OnClickListener() {
      	     public void onClick(View v) {
      	    	
      	    	//boolean time = Global.checkTime();
      	    	  
      	    	
      	    	boolean x = findViewById(R.id.imageView1).getVisibility() == View.INVISIBLE;
    	        if ((x)){	
    	        	final Intent i = new Intent(RedActivity.this,GameOverActivity.class);
    	        	onDestroy();
        	        startActivity(i);
    	        }
    	        else{
    	        int y = generateNumber();
      	    	Global.ivar1+=1;
      	    	Global.ivar4+=1;
      	    	text2.setText("Score: " + Global.ivar1);
      	    	
      	    	 if (y==1){
      	    		 
      	    		
      	    		imageView2.setVisibility(View.INVISIBLE);
     	        	imageView3.setVisibility(View.INVISIBLE);
     	   	        imageView1.setVisibility(View.VISIBLE);
     	        }
     	        else if(y==2){
     	        	 
     	       	
     	        	imageView1.setVisibility(View.INVISIBLE);
     	        	imageView3.setVisibility(View.INVISIBLE);
     	   	        imageView2.setVisibility(View.VISIBLE);
     	        }
     	        else{
     	       	
     	        	imageView1.setVisibility(View.INVISIBLE);
     	        	imageView2.setVisibility(View.INVISIBLE);
     	   	        imageView3.setVisibility(View.VISIBLE);
     	        
     	   	   
     	        }
    	        }
    	        mp.release(); mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
    	        mp.start();
      	     }
      	 });
      	  button2.setOnClickListener(new View.OnClickListener() {
       	     public void onClick(View v) {
       	    
       	    	//boolean time = Global.checkTime();
       	    	boolean x2 = findViewById(R.id.imageView2).getVisibility() == View.INVISIBLE;
       	    	 if ((x2)){	
     	        	final Intent i = new Intent(RedActivity.this,GameOverActivity.class);
     	        	onDestroy();
         	        startActivity(i);
     	        }
       	    	 else{
     	        int y = generateNumber();
       	    	Global.ivar1+=1;
       	    	Global.ivar4+=1;
       	    	text2.setText("Score: " + Global.ivar1);
       	    	 if (y==1){
       	    		 
       	    		
       	    		imageView2.setVisibility(View.INVISIBLE);
      	        	imageView3.setVisibility(View.INVISIBLE);
      	   	        imageView1.setVisibility(View.VISIBLE);
      	        }
      	        else if(y==2){
      	        	 
      	      	
      	      	imageView1.setVisibility(View.INVISIBLE);
      	        	imageView3.setVisibility(View.INVISIBLE);
      	   	        imageView2.setVisibility(View.VISIBLE);
      	        }
      	        else{
      	        	 
      	        		
      	        	imageView1.setVisibility(View.INVISIBLE);
      	        	imageView2.setVisibility(View.INVISIBLE);
      	   	        imageView3.setVisibility(View.VISIBLE);
      	        
      	   	   
      	        }
       	    	 }
       	    	mp.release(); mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
   	        mp.start();
       	     }
       	 });
      	  button3.setOnClickListener(new View.OnClickListener() {
        	     public void onClick(View v) {
        	    	 
        	    		 
        	    	//boolean time = Global.checkTime();
        	    	boolean x3 = findViewById(R.id.imageView3).getVisibility() == View.INVISIBLE;
        	    	 if ((x3)){	
      	        	final Intent i = new Intent(RedActivity.this,GameOverActivity.class);
      	        	onDestroy();
          	        startActivity(i);
      	        }
        	    	 else{
      	        int y = generateNumber();
        	    	Global.ivar1+=1;
        	    	Global.ivar4+=1;
        	    	text2.setText("Score: " + Global.ivar1);
        	    	 if (y==1){
        	    		 
        	    		 
        	    		imageView2.setVisibility(View.INVISIBLE);
       	        	imageView3.setVisibility(View.INVISIBLE);
       	   	        imageView1.setVisibility(View.VISIBLE);
       	        }
       	        else if(y==2){
       	       
       	     	
       	        	imageView1.setVisibility(View.INVISIBLE);
       	        	imageView3.setVisibility(View.INVISIBLE);
       	   	        imageView2.setVisibility(View.VISIBLE);
       	        }
       	        else{
       	         
       	        	
       	        	imageView1.setVisibility(View.INVISIBLE);
       	        	imageView2.setVisibility(View.INVISIBLE);
       	   	        imageView3.setVisibility(View.VISIBLE);
       	        
       	   	   
       	        }
        	    	
        	     }
        	    	 
        	    	 mp.release(); mp = MediaPlayer.create(getApplicationContext(), R.raw.switchsound);
        	        mp.start();
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
           if (timer!= null){
        	   timer.cancel();
           }
           timer = null;
button1=null;
button2=null;
button3=null;
imageView1=null;
imageView2=null;
imageView3=null;
	      
	       finish();
	       this.finish();
	   }
	    public static int generateNumber(){
	    	int x = (int) ((Math.random()*3+1));
	    	return x;
	    }


}