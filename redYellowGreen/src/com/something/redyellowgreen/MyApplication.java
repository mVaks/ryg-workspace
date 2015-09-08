package com.something.redyellowgreen;

import android.app.Application;

public class MyApplication extends Application {
	public static long started;
    private int someVariable;

    public int getSomeVariable() {
        return someVariable;
    }
    

    public void setSomeVariable(int someVariable) {
        this.someVariable = someVariable;
    }
}