package com.astrology.menu.splash;

import com.appsbazaar.astrology.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MonthsUpdatedActivity extends Activity implements OnClickListener {

	ImageView horo_image;
	TextView horo_text;
	Button jan,feb,mar,apr,may,jun,july,aug,sep,oct,nov,dec;
	Typeface tf1,tf2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));

		tf1=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"snell.ttf");
		tf2=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"sourcebold.otf");
		horo_image=(ImageView) findViewById(R.id.horo_imageview);

		horo_text=(TextView) findViewById(R.id.horo_textview);
		horo_text.setTypeface(tf1);

		jan=(Button) findViewById(R.id.jan);
		feb=(Button) findViewById(R.id.feb);
		mar=(Button) findViewById(R.id.mar);
		apr=(Button) findViewById(R.id.apr);
		may=(Button) findViewById(R.id.may);
		jun=(Button) findViewById(R.id.jun);
		july=(Button) findViewById(R.id.jul);
		aug=(Button) findViewById(R.id.aug);
		sep=(Button) findViewById(R.id.sep);
		oct=(Button) findViewById(R.id.oct);
		nov=(Button) findViewById(R.id.nov);
		dec=(Button) findViewById(R.id.dec);


		jan.setTypeface(tf2);
		feb.setTypeface(tf2);
		mar.setTypeface(tf2);
		apr.setTypeface(tf2);
		may.setTypeface(tf2);
		jun.setTypeface(tf2);
		july.setTypeface(tf2);
		aug.setTypeface(tf2);
		sep.setTypeface(tf2);
		oct.setTypeface(tf2);
		nov.setTypeface(tf2);
		dec.setTypeface(tf2);
		
		jan.setOnClickListener(this);
		feb.setOnClickListener(this);
		mar.setOnClickListener(this);
		apr.setOnClickListener(this);
		may.setOnClickListener(this);
		jun.setOnClickListener(this);
		july.setOnClickListener(this);
		aug.setOnClickListener(this);
		sep.setOnClickListener(this);
		oct.setOnClickListener(this);
		nov.setOnClickListener(this);

		dec.setOnClickListener(this);




	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.jan:

			break;
		case R.id.feb:

			break;
		case R.id.mar:

			break;
		case R.id.apr:

			break;
		case R.id.may:

			break;
		case R.id.jun:

			break;
		case R.id.jul:

			break;
		case R.id.aug:

			break;
		case R.id.sep:

			break;
		case R.id.oct:

			break;
		case R.id.nov:

			break;
		case R.id.dec:

			break;


		default:
			break;
		}

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

			break;
		case R.id.friend:

			break;
		case R.id.more:

			break;
		case R.id.feedback:

			break;

		default:
			break;
		}


		return super.onOptionsItemSelected(item);
	}


}
