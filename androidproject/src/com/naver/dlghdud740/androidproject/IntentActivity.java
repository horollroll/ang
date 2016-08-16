package com.naver.dlghdud740.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;

public class IntentActivity extends Activity{
	Button close;
	Button naver;
	Button google;
	Button daum;
	WebView webview;
	InputMethodManager imm;
	final Context context = this;
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.intent_activity);
	     imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	     close= (Button) findViewById(R.id.close);
	     naver= (Button) findViewById(R.id.naver);
	     google= (Button) findViewById(R.id.google);
	     daum= (Button) findViewById(R.id.daum);
	     webview= (WebView) findViewById(R.id.webview);
	     naver.setOnClickListener(bClick);
	     google.setOnClickListener(bClick);
	     daum.setOnClickListener(bClick);
	     close.setOnClickListener(bClick);
	 }
	 Button.OnClickListener bClick = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				switch (v.getId()){
				case R.id.close:
					AlertDialog.Builder alert = new AlertDialog.Builder(context);
					
					alert.setMessage("Close?");
					alert.setIcon(R.drawable.money);
					alert.setTitle("no way");
					alert.setPositiveButton("no",new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							return;
						}
					})
					.setNegativeButton("yes", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					});
					alert.create();
					alert.show();
					break;
				case R.id.naver:
					webview.loadUrl("http://naver.com");
					break;
				case R.id.google:
					webview.loadUrl("http://google.com");
					break;
				case R.id.daum:
					webview.loadUrl("http://daum.net");
					break;
				default :
					break;
				}
			}
	 };
//	 @Override
//	 public void onResume(){
//		 super.onResume();
//		 Log.d("","resume....");
//	 }
//	 @Override
//	 public void onStart(){
//		 super.onDestroy();
//		 Log.d("","start....");
//	 }
//	 @Override
//	 public void onDestroy(){
//		 super.onDestroy();
//		 Log.d("","destory....");
//	 }
}
