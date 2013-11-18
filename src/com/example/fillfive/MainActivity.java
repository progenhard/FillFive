package com.example.fillfive;

import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {
	GUI gui;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gui = new GUI(MainActivity.this);
		setContentView(gui);
	}


}