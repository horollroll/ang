package com.naver.dlghdud740.androidproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
	LinearLayout baselayout;
	InputMethodManager imm;
	EditText id;
	Button button1;
	Button button2;
	
	ImageView imgview;
	ImageView imageview1;
	ImageView imageview2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baselayout = (LinearLayout) findViewById(R.id.baselayout);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        id = (EditText) findViewById(R.id.id);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imageview1 = (ImageView) findViewById(R.id.imageview1);
        imageview2 = (ImageView) findViewById(R.id.imageview2);
        button1.setOnClickListener(bClick);
        button2.setOnClickListener(bClick);
        baselayout.setOnClickListener(bClick);
        imageview1.setOnClickListener(bClick);
        imageview2.setOnClickListener(bClick);
        imageview1.setOnTouchListener(touch);
        imageview2.setOnTouchListener(touch);
    }
    
    Button.OnClickListener bClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			switch (v.getId()){
			case R.id.button1:
				Toast.makeText(MainActivity.this,"YO",Toast.LENGTH_SHORT).show();
				break;
			case R.id.button2:
				Toast.makeText(MainActivity.this,"WASS UP",Toast.LENGTH_SHORT).show();
				break;
			case R.id.imageview1:
				Toast.makeText(MainActivity.this,"image1",Toast.LENGTH_SHORT).show(); 
				break;
			case R.id.imageview2:
				Toast.makeText(MainActivity.this,"image2",Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};
	
	OnTouchListener touch = new OnTouchListener() {
		public boolean onTouch(View v, MotionEvent event) {
			switch(v.getId()){
			case R.id.imageview1:
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					imageview1.setPadding(2, 2, 2, 2);
					imageview1.setColorFilter(111111,Mode.SRC_OVER);
				} else if (event.getAction()==MotionEvent.ACTION_UP){
					imageview1.setPadding(0, 0, 0, 0);
					imageview1.setColorFilter(111111,Mode.SRC_OVER);
					Intent intent = new Intent(MainActivity.this,IntentActivity.class);
					startActivity(intent);
				}
				
				break;
				
			case R.id.imageview2:
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					imageview2.setPadding(2, 2, 2, 2);
					imageview2.setColorFilter(111111,Mode.SRC_OVER);
				} else if (event.getAction()==MotionEvent.ACTION_UP){
					imageview2.setPadding(0, 0, 0, 0);
					imageview2.setColorFilter(111111,Mode.SRC_OVER);
					Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
					startActivity(intent);
				}
				
				break;
			}
			return true;
		}
	};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

