package com.naver.dlghdud740.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListViewActivity extends Activity{
	Button close;
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.listviewactivity);
	     close= (Button) findViewById(R.id.close);
	     close.setOnClickListener(bClick);
	}
	
	 Button.OnClickListener bClick = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()){
				case R.id.close:
					finish();
					break;
				default :
					break;
				}
			}
	 };
}
