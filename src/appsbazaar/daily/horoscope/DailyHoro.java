package appsbazaar.daily.horoscope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appsbazaar.astrology.R;
import com.feedback.FeedActivity;

public class DailyHoro extends Activity{
	
	HashMap<String, String> setHoroscope = new HashMap<String, String>();
	private ImageView image;
	//ProgressBar pb;
	private TextView horoName ,desc,year_text;
	String sign=null;
	Button query;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.daily);
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#005f71")));
		bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#000000'>Horoscope 2015</font>"));
		//tasks = new ArrayList<>();
		image = (ImageView)findViewById(R.id.imgeView);
		horoName =(TextView)findViewById(R.id.horoscope_name);
		desc =(TextView)findViewById(R.id.textView);
		year_text=(TextView) findViewById(R.id.year_textview);
		query=(Button)findViewById(R.id.query);
		
		sign=getIntent().getStringExtra("sign").toString();
		//pb = (ProgressBar) findViewById(R.id.progressBar1);
		//pb.setVisibility(View.INVISIBLE);
		Log.d("sign",sign);
	checkSign(sign);
	query.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in=new Intent(DailyHoro.this,FeedActivity.class);
			startActivity(in);
		}
	});
	}
	private void checkSign(String sign2) {
		// TODO Auto-generated method stub
		if (isOnline()) {
			
			if(sign.equals("aquarius"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Aquarius");
				image.setBackgroundResource(R.drawable.aquarius_text_icon);
				horoName.setText("AQUARIUS");
				
			}
			else if(sign.equals("aries"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Aries");
				image.setBackgroundResource(R.drawable.aries_text_icon);
				horoName.setText("ARIES");
			}
			else if(sign.equals("cancer"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Cancer");
				image.setBackgroundResource(R.drawable.cancer_text_icon);
				horoName.setText("CANCER");
			}
			else if(sign.equals("capricorn"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Capricorn");
				image.setBackgroundResource(R.drawable.capricorn_text_icon);
				horoName.setText("CAPRICORN");
			}
			else if(sign.equals("gemini"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Gemini");
				image.setBackgroundResource(R.drawable.gemini_text_icon);
				horoName.setText("GEMINI");
			}
			else if(sign.equals("leo"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Leo");
				image.setBackgroundResource(R.drawable.leo_text_icon);
				horoName.setText("LEO");
			}
			else if(sign.equals("libra"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Libra");
				image.setBackgroundResource(R.drawable.libra_text_icon);
				horoName.setText("LIBRA");
			}
			else if(sign.equals("pisces"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Pisces");
				image.setBackgroundResource(R.drawable.libra_text_icon);
				horoName.setText("PISCES");
			}
			else if(sign.equals("sagittarius"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Sagittarius");
				image.setBackgroundResource(R.drawable.sagittarius_text_icon);
				horoName.setText("SAGITTARIUS");
			}
			else if(sign.equals("scorpio"))
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Scorpio");
				image.setBackgroundResource(R.drawable.scorpius_text_icon);
				horoName.setText("SCORPIO");
			}
			else if(sign.equals("taurus"))	
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Taurus");
				image.setBackgroundResource(R.drawable.scorpius_text_icon);
				horoName.setText("TAURUS");
			}
			else if(sign.equals("virgo"))	
			{
				requestData("http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=Virgo");
				image.setBackgroundResource(R.drawable.virgo_text_icon);
				horoName.setText("VIRGO");
			}
			
			
		} else {
			Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
		}
		
		
		
	}
	protected boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}
	}
	private void requestData(String uri) {
		MyTask task = new MyTask();
		task.execute(uri);
	}
	private class MyTask extends AsyncTask<String, String, String> {
		private ProgressDialog progressDialog2 = null;


		@Override
		protected void onPreExecute() {
			//updateDisplay();
			
			progressDialog2= new ProgressDialog(DailyHoro.this, AlertDialog.THEME_HOLO_DARK);
			progressDialog2.setMessage("Loading...");
			progressDialog2.show();
			super.onPreExecute();
			//pb.setVisibility(View.VISIBLE);
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String content = HttpManager.getData(params[0]);
			return content;
		}
		
		@Override
		protected void onPostExecute(String result) {
			
		setHoroscope.putAll(FlowerXMLParser.parseFeed(result));
		
		
			//updateDisplay();
		try{
		year_text.setText(setHoroscope.get("title"));
		desc.setText(setHoroscope.get("description"));
		progressDialog2.dismiss();
		}
		catch(Exception e)
		
		{
		e.printStackTrace();	
		}
			//	pb.setVisibility(View.INVISIBLE);
		

		}
		
		/*@Override
		protected void onProgressUpdate(String... values) {
			//updateDisplay(values[0]);
		}
		*/
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
}
