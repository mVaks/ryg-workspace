package com.something.redyellowgreen;

public class Global {
    public static int ivar1,ivar2,ivar3,ivar4,ivar5;
    public static String svar1,svar2;
    public static int[] myarray1=new int[10];
    public static void main (String args[]){
    	Global.ivar5=0;
    	Global.ivar4=0;
        Global.ivar3=1;
    	Global.ivar1=0;
    	Global.ivar2=2;
    }
    
    public static boolean checkTime(){
    	long z = System.currentTimeMillis();
    	if (z-MyApplication.started>=20000){
    		return false;
    	}
    	if(z-MyApplication.started>=10000 &&(Global.ivar4>=10)){
    		Global.ivar4=0;
    		Global.ivar3+=1;
    		MyApplication.started = System.currentTimeMillis() - ((z-MyApplication.started)-10000);
    		return true;
    	}
    	 if (z-MyApplication.started>=10000 && (Global.ivar4<10)){
    		return false;
    	}
    	return true;
    
    }

}