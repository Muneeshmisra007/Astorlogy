package appsbazaar.daily.horoscope;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appsbazaar.astrology.R;
import com.aquarius.AquariusMonthly;
import com.aries.AriesMonthly;
import com.astrology.menu.splash.AboutActivity;
import com.astrology.menu.splash.Disclaimer;
import com.astrology.menu.splash.MyAppRater;
import com.cancer.CancerMonthly;
import com.capricorn.CapricornMonthly;
import com.feedback.FeedActivity;
import com.gemini.GeminiMonthly;
import com.leo.LeoMonthly;
import com.libra.LibraMonthly;
import com.pisces.PiscesMonthly;
import com.sagittarius.SagittariusMonthly;
import com.scorpio.ScorpioMonthly;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdDisplayListener;
import com.startapp.android.publish.StartAppAd;
import com.taurus.TaurusMonthly;
import com.virgo.VirgoMonthly;


public class AllSignes extends Activity {

	SharedPreferences sharedPreferences;
	private Button aquarius;
	private Button aries;
	private Button cancer;
	private Button capricorn;
	private Button gemini;
	private Button leo;
	private Button libra;
	private Button pisces;
	private Button sagittarius;
	private Button scorpio;
	private Button taurus;
	private Button virgo;
	StartAppAd	startAppAd = new StartAppAd(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testing);
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));
		
		SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
		boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
		if (isFirstRun)
		{ 
			Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
	        shortcutintent.putExtra("duplicate", false);
	        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.baby_care));
	        Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.babycare);
	        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
	        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.appsbazaar.babycare&hl=en")));
	        sendBroadcast(shortcutintent);
			SharedPreferences.Editor editor = wmbPreference.edit();
		    editor.putBoolean("FIRSTRUN", false);
		    editor.commit();
		}
		
		StartAppAd.showSlider(this);
		aquarius =(Button)findViewById(R.id.aquarius);
		aries =(Button)findViewById(R.id.aries);
		cancer =(Button)findViewById(R.id.cancer);
		capricorn =(Button)findViewById(R.id.capricorn);
		gemini =(Button)findViewById(R.id.gemini);
		leo =(Button)findViewById(R.id.leo);
		libra =(Button)findViewById(R.id.libra);
		pisces =(Button)findViewById(R.id.pisces);
		sagittarius =(Button)findViewById(R.id.sagittarius);
		scorpio =(Button)findViewById(R.id.scorpio);
		taurus =(Button)findViewById(R.id.taurus);
		virgo =(Button)findViewById(R.id.virgo);

		aquarius.setOnClickListener(onClickListener);
		aries.setOnClickListener(onClickListener);
		cancer.setOnClickListener(onClickListener);
		capricorn.setOnClickListener(onClickListener);
		gemini.setOnClickListener(onClickListener);
		leo.setOnClickListener(onClickListener);
		libra.setOnClickListener(onClickListener);
		pisces.setOnClickListener(onClickListener);
		sagittarius.setOnClickListener(onClickListener);
		scorpio.setOnClickListener(onClickListener);
		taurus.setOnClickListener(onClickListener);
		virgo.setOnClickListener(onClickListener);
		
		ObjectAnimator cloudAnim = 
				ObjectAnimator.ofFloat(findViewById(R.id.horo_imageview), "rotation", 0,360);
		cloudAnim.setDuration(25000);
		cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
		cloudAnim.setRepeatMode(ValueAnimator.INFINITE);
		cloudAnim.start();
	}
	private OnClickListener onClickListener = new OnClickListener()
	{
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.aquarius:
/*
				Intent aq = new Intent(getApplicationContext(),AquariusMonthly.class);
				startActivity(aq);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				*/
				NextActivityClick(AllSignes.this,new DailyHoro(),"aquarius");
				
				break;
			case R.id.aries:

				NextActivityClick(AllSignes.this,new DailyHoro(),"aries");
				break;
			case R.id.cancer:

				NextActivityClick(AllSignes.this,new DailyHoro(),"cancer");
				break;
			case R.id.capricorn:

				NextActivityClick(AllSignes.this,new DailyHoro(),"capricorn");
				break;
			case R.id.gemini:

				NextActivityClick(AllSignes.this,new DailyHoro(),"gemini");
				break;
			case R.id.leo:

				NextActivityClick(AllSignes.this,new DailyHoro(),"leo");
				break;
			case R.id.libra:

				NextActivityClick(AllSignes.this,new DailyHoro(),"libra");
				break;
			case R.id.pisces:

				NextActivityClick(AllSignes.this,new DailyHoro(),"pisces");
				break;
			case R.id.sagittarius:

				NextActivityClick(AllSignes.this,new DailyHoro(),"sagittarius");
				break;
			case R.id.scorpio:

				NextActivityClick(AllSignes.this,new DailyHoro(),"scorpio");
				break;
			case R.id.taurus:

				NextActivityClick(AllSignes.this,new DailyHoro(),"taurus");
				break;
			case R.id.virgo:

				NextActivityClick(AllSignes.this,new DailyHoro(),"virgo");
				break;
			}
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_save, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.rate_us:
			MyAppRater.showRateDialog(this, null);
			break;
		case R.id.friend:
			try
			{ final Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("text/plain");
			i.putExtra(Intent.EXTRA_SUBJECT, "HoroScope 2015: Android app");
			String sAux = "\n\n Hi,\nCurrently I am using this very good app so I recommend you this application\n\n";
			sAux = sAux + "https://play.google.com/store/apps/details?id=com.appsbazaar.astrology&hl=en\n\n";
			i.putExtra(Intent.EXTRA_TEXT, sAux);
			startActivity(Intent.createChooser(i, "Shared via..."));
			}
			catch(final Exception e)
			{ //e.toString();
			}
			break;
		
		case R.id.feedback:
			Intent i = new Intent(getApplicationContext(),FeedActivity.class);
			startActivity(i);
			break;
		case R.id.about:
			Intent	intent1 = new Intent(this, AboutActivity.class);
			startActivity(intent1);
			break;
		case R.id.disclaimer:
			Intent dis = new Intent(getApplicationContext(),Disclaimer.class);
			startActivity(dis);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent106 = new Intent(this,
				AllSignes.class);
		intent106.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent106);
		overridePendingTransition(R.anim.righttoleft, R.anim.stable);
		finish();
		/*startAppAd.onBackPressed();
*/
		
		super.onBackPressed();

	}

	@Override
	public void onResume() {
		super.onResume();
		startAppAd.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		startAppAd.onPause();
	}
	
	public void NextActivityClick(final Context context,final Activity page,String sign_id) {
		// Show an Ad
		
		Intent nextActivity = new Intent(AllSignes.this,
				page.getClass());
		nextActivity.putExtra("sign", sign_id);
		context.startActivity(nextActivity);
		overridePendingTransition(R.anim.lefttoright,R.anim.stable);
		startAppAd.showAd(new AdDisplayListener() {
			
			/**
			 * Callback when Ad has been hidden
			 * @param ad
			 */
			@Override
			public void adHidden(Ad ad) {
				
				// Run second activity right after the ad was hidden
				
				//((Activity) context).finish();
			}

			/**
			 * Callback when ad has been displayed
			 * @param ad
			 */
			@Override
			public void adDisplayed(Ad ad) {
				
			}

			/**
			 * Callback when ad has been clicked
			 * @param ad
			 */
			@Override
			public void adClicked(Ad arg0) {
				
			}

			


			
		});	
		
}
}

