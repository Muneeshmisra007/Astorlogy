package com.aries;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsbazaar.astrology.R;
import com.aquarius.AquariusAugust;
import com.aquarius.AquariusJune;
import com.astro.swipe.SimpleGestureFilter;
import com.astro.swipe.SimpleGestureFilter.SimpleGestureListener;
import com.astrology.menu.splash.AboutActivity;
import com.astrology.menu.splash.Disclaimer;
import com.astrology.menu.splash.MainActivity;
import com.astrology.menu.splash.MyAppRater;
import com.feedback.FeedActivity;

public class AriesJuly extends Activity implements SimpleGestureListener{
	private com.astro.swipe.SimpleGestureFilter detector;


//	String astro[] = {R.string.aries_july
//	};

	String horo_name[] ={"Aries"};

	private ImageView image;
	private TextView HoroName ,Desc,year_text;
	Typeface tf1,tf2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		detector = new com.astro.swipe.SimpleGestureFilter(this,this);
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));

		
		tf1=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"snell.ttf");
		tf2=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"sourcebold.otf");
		  Button qury = (Button)findViewById(R.id.query_btn);
	        qury.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getApplicationContext(),FeedActivity.class);
					startActivity(i);
				}
			});
		image = (ImageView)findViewById(R.id.imgeView);
		HoroName =(TextView)findViewById(R.id.horoscope_name);
		Desc =(TextView)findViewById(R.id.textView);
		year_text=(TextView) findViewById(R.id.year_textview);
		String udata= getString(R.string.july_ap);
		SpannableString content = new SpannableString(udata);
		content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
		year_text.setText(content);
		year_text.setTypeface(tf2);
		Desc.setTypeface(tf2);
		HoroName.setTypeface(tf1);
		
		HoroName.setText(R.string.aries_monthly);
		Desc.setText(R.string.aries_july);
		image.setImageResource(R.drawable.aries_text_icon);
		ImageView arrow1 =(ImageView)findViewById(R.id.arrow1);
		ImageView arrow2 =(ImageView)findViewById(R.id.arrow2);
		arrow1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),AriesJune.class);
				startActivity(i);
				overridePendingTransition(R.anim.lefttoright,R.anim.stable);
				finish();
			}
			
		});
		arrow2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent ii = new Intent(getApplicationContext(),AriesAugust.class);
				startActivity(ii);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				finish();}
			
		});
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent me){
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
	@Override
	public void onSwipe(int direction) {

		switch (direction) {

		case SimpleGestureFilter.SWIPE_RIGHT :
			Intent i = new Intent(getApplicationContext(),AriesJune.class);
			startActivity(i);
			overridePendingTransition(R.anim.lefttoright,R.anim.stable);
			finish();
			break;
		case SimpleGestureFilter.SWIPE_LEFT :
			Intent ii = new Intent(getApplicationContext(),AriesAugust.class);
			startActivity(ii);
			overridePendingTransition(R.anim.righttoleft,R.anim.stable);
			finish();
			break;
		}
	}
	public void onDoubleTap() {

	}
	@Override
	public void onBackPressed() {
		Intent menu = new Intent(getApplicationContext(),AriesMonthly.class);
		startActivity(menu);
	}
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
			{ Intent i = new Intent(Intent.ACTION_SEND);  
			i.setType("text/plain");
			i.putExtra(Intent.EXTRA_SUBJECT, "HoroScope 2015: Android app");
			String sAux = "\n\n Hi,\nCurrently I am using this very good app so I recommend you this application\n\n";
			sAux = sAux + "https://play.google.com/store/apps/details?id=com.appsbazaar.astrology&hl=en\n\n";
			i.putExtra(Intent.EXTRA_TEXT, sAux);  
			startActivity(Intent.createChooser(i, "Shared via..."));
			}
			catch(Exception e)
			{ //e.toString();
			} 
			break;
        case R.id.more:
        	//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=AppsBazaar")));
        	Intent j=new Intent(getApplicationContext(),applist.MainActivity.class);
			startActivity(j);
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

}


