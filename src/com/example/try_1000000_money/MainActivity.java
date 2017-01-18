package com.example.try_1000000_money;

import com.example.try_gameengine.framework.Config;
import com.example.try_1000000_money.R;
import com.example.try_1000000_money.utils.CommonUtil;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
//		imageView.setBackgroundResource(R.drawable.ddefault);
		
		if(CommonUtil.screenHeight<=0){
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			
			CommonUtil.screenHeight = dm.heightPixels;
			CommonUtil.screenWidth = dm.widthPixels;
			CommonUtil.statusBarHeight = CommonUtil.getStatusBarHeight(this);
			CommonUtil.screenHeight -= CommonUtil.statusBarHeight;
		}
		
		Config.enableFPSInterval = true;
		Config.showMovementActionThreadNumber = true;
		Config.showAllThreadNumber = true;
		Config.debugMessageColor = Color.WHITE;
		Config.fps = 40;
		Config.showFPS = true;
//		Config.destanceType = DestanceType.ScreenPersent;
		Config.currentScreenWidth = CommonUtil.screenWidth;
		Config.currentScreenHeight = CommonUtil.screenHeight;
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				startActivity(new Intent(MainActivity.this, GameActivity.class));
				finish();
			}
		}).start();
		
//		Button button = (Button) findViewById(R.id.button1);
//		button.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				startActivity(new Intent(MainActivity.this, GameActivity.class));
//			}
//		});
	}

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
