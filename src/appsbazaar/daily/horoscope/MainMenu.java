package appsbazaar.daily.horoscope;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appsbazaar.astrology.R;
import com.astrology.menu.splash.MainActivity;

public class MainMenu extends Activity{
	private Button monthly, daily;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#000000'>Horoscope 2015</font>"));

		monthly =(Button)findViewById(R.id.image);
		daily =(Button)findViewById(R.id.image2);
		
		monthly.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainMenu.this,MainActivity.class);
				startActivity(i);
			}
			
		});
		daily.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainMenu.this,AllSignes.class);
				startActivity(i);
			}
			
		});
		
}
}