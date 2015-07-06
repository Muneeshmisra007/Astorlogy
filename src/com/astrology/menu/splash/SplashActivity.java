package com.astrology.menu.splash;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import appsbazaar.daily.horoscope.MainMenu;

import com.appsbazaar.astrology.R;
import com.startapp.android.publish.StartAppSDK;

public class SplashActivity extends Activity {

	private int mSplashTime = 4000;
	private Timer mTimer;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		StartAppSDK.init(this, "112248655", "212168756", true);
		setContentView(R.layout.splash);
		

		mTimer = new Timer();
		mTimer.schedule(
				new TimerTask() {
					public void run() {
						finish();
						Intent intent = new Intent(getApplicationContext(), MainMenu.class);
						startActivity(intent);
					}
				},
				mSplashTime);
	}
}
