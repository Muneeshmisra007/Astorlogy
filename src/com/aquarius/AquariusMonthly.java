package com.aquarius;

import com.appsbazaar.astrology.R;
import com.astrology.menu.splash.AboutActivity;
import com.astrology.menu.splash.Disclaimer;
import com.astrology.menu.splash.MainActivity;
import com.astrology.menu.splash.MyAppRater;
import com.feedback.FeedActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AquariusMonthly extends Activity{
	private Button jan ,fab, mar,apr,may,jun,jul,aug,sep,oct,nov,dec;
	Typeface tf1,tf2;
	TextView horo_text;
	ImageView horo_image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.months_name_updated);
		
		
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));

		tf1=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"snell.ttf");
		tf2=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"sourcebold.otf");
		horo_image=(ImageView) findViewById(R.id.horo_imageview);

		horo_image.setImageResource(R.drawable.aquarius);
		horo_text=(TextView) findViewById(R.id.horo_textview);
		horo_text.setText(R.string.aquarius_monthly);
		horo_text.setTypeface(tf1);
		
		jan =(Button)findViewById(R.id.jan);
		fab =(Button)findViewById(R.id.feb);
		mar =(Button)findViewById(R.id.mar);
		apr =(Button)findViewById(R.id.apr);
		may =(Button)findViewById(R.id.may);
		jun =(Button)findViewById(R.id.jun);
		jul =(Button)findViewById(R.id.jul);
		aug =(Button)findViewById(R.id.aug);
		sep =(Button)findViewById(R.id.sep);
		oct =(Button)findViewById(R.id.oct);
		nov =(Button)findViewById(R.id.nov);
		dec =(Button)findViewById(R.id.dec);
		
		
		jan.setTypeface(tf2);
		fab.setTypeface(tf2);
		mar.setTypeface(tf2);
		apr.setTypeface(tf2);
		may.setTypeface(tf2);
		jun.setTypeface(tf2);
		jul.setTypeface(tf2);
		aug.setTypeface(tf2);
		sep.setTypeface(tf2);
		oct.setTypeface(tf2);
		nov.setTypeface(tf2);
		dec.setTypeface(tf2);
		
		
		jan.setOnClickListener(onClickListener);
		fab.setOnClickListener(onClickListener);
		mar.setOnClickListener(onClickListener);
		apr.setOnClickListener(onClickListener);
		may.setOnClickListener(onClickListener);
		jun.setOnClickListener(onClickListener);
		jul.setOnClickListener(onClickListener);
		aug.setOnClickListener(onClickListener);
		sep.setOnClickListener(onClickListener);
		oct.setOnClickListener(onClickListener);
		nov.setOnClickListener(onClickListener);
		dec.setOnClickListener(onClickListener);
	}
	private OnClickListener onClickListener = new OnClickListener()
	{
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.jan:
				Intent jan = new Intent(getApplicationContext(),AquariusJanuary.class);
				startActivity(jan);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.feb:

				Intent feb = new Intent(getApplicationContext(),AquariusFebuary.class);
				startActivity(feb);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.mar:

				Intent mar = new Intent(getApplicationContext(),AquariusMarch.class);
				startActivity(mar);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.apr:

				Intent apr = new Intent(getApplicationContext(),AquariusApril.class);
				startActivity(apr);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.may:

				Intent may = new Intent(getApplicationContext(),AquariusMay.class);
				startActivity(may);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.jun:

				Intent jun = new Intent(getApplicationContext(),AquariusJune.class);
				startActivity(jun);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.jul:

				Intent jul = new Intent(getApplicationContext(),AquariusJuly.class);
				startActivity(jul);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.aug:

				Intent aug = new Intent(getApplicationContext(),AquariusAugust.class);
				startActivity(aug);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.sep:

				Intent sep = new Intent(getApplicationContext(),AquariusSeptember.class);
				startActivity(sep);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.oct:

				Intent oct = new Intent(getApplicationContext(),AquariusOctober.class);
				startActivity(oct);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.nov:

				Intent nov = new Intent(getApplicationContext(),AquariusNovember.class);
				startActivity(nov);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			case R.id.dec:

				Intent dec = new Intent(getApplicationContext(),AquariusDecember.class);
				startActivity(dec);
				overridePendingTransition(R.anim.righttoleft,R.anim.stable);
				break;
			}
		}
	};
	@Override
	public void onBackPressed() {
		Intent menu = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(menu);
		finish();
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
