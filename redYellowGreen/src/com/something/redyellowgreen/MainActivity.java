package com.something.redyellowgreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.swarmconnect.SwarmActivity;



public class MainActivity extends SwarmActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout); 
        doshit();
       
    }
    public static int generateNumber(){
    	int x = (int) ((Math.random()*3+1));
    	return x;
    }



public void doshit(){
	 boolean q = true;

     while(q){
     
	        int y = generateNumber();
	        if (y==1){
	        	final Intent i = new Intent(MainActivity.this,RedActivity.class);
	   	        startActivity(i);

	        }
	        else if(y==2){
	        	final Intent i = new Intent(MainActivity.this,RedActivity.class);
	        	 
	   	        startActivity(i);
	   	  
	        }
	        else{
	        	
	        	final Intent i = new Intent(MainActivity.this,RedActivity.class);
	        	 
	   	        startActivity(i);
	   	   
	        }
	     q=false;

     }
     
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
}
