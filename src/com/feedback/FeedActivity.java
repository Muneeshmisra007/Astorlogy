package com.feedback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.appsbazaar.astrology.R;
import com.blundell.tutorial.simpleinappbillingv3.ui.base.BlundellActivity;
import com.blundell.tutorial.simpleinappbillingv3.ui.utils.Navigator;
import com.blundell.tutorial.simpleinappbillingv3.ui.xml.MainMenu;
import com.startapp.android.publish.gson.JsonObject;

public class FeedActivity extends BlundellActivity implements MainMenu, OnClickListener {
	private Calendar cal;
	private int day;
	private int month;
	private int year;
	EditText name, sex, dob, tob, city, state, country, mob, e_mail, query;
	int hour,minute;
	String query_type="FREE";
	Button sub_btn,brief,detailed;
	 Dialog dialog;
	Typeface tf1;
	 ImageView close;
	String particular_subject;
	Person person;
	DatePickerDialog.OnDateSetListener myDateListener ;
	TimePickerDialog.OnTimeSetListener timePickerListener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feed);
	//example:	http://hmkcode.com/android-send-json-data-to-server/	
		final ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
		bar.setTitle(Html
				.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));
		tf1=Typeface.createFromAsset(getBaseContext().getAssets(), "font/"+"sourcebold.otf");
		( name=(EditText) findViewById(R.id.name)).setTypeface(tf1);
		 (sex=(EditText) findViewById(R.id.sex)).setTypeface(tf1);
	    ( dob=(EditText) findViewById(R.id.dob)).setTypeface(tf1);
	     (tob=(EditText) findViewById(R.id.tob)).setTypeface(tf1);
	   
	     (city=(EditText) findViewById(R.id.city)).setTypeface(tf1);
	     (state=(EditText) findViewById(R.id.state)).setTypeface(tf1);
	     (country=(EditText) findViewById(R.id.country)).setTypeface(tf1);
	     (mob=(EditText) findViewById(R.id.mob)).setTypeface(tf1);
	     (e_mail=(EditText) findViewById(R.id.e_mail)).setTypeface(tf1);
	     (query=(EditText) findViewById(R.id.query)).setTypeface(tf1);
		
		dialog = new Dialog(FeedActivity.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setBackgroundDrawable( new ColorDrawable(android.graphics.Color.TRANSPARENT));
		dialog.setContentView(R.layout.popup);
		close=(ImageView)dialog.findViewById(R.id.close);
		//dialog.setTitle("Query Type");
		brief=(Button)dialog.findViewById(R.id.brief);
		detailed=(Button)dialog.findViewById(R.id.detail);
		sub_btn=(Button)findViewById(R.id.query_btn);
		brief.setOnClickListener(this);
		detailed.setOnClickListener(this);
		sub_btn.setOnClickListener(this);
		close.setOnClickListener(this);
		 
		cal = Calendar.getInstance();
		day = 1;
		month = cal.get(Calendar.MONTH);
		year = 1980;

		

		dob.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(12);
				return false;
			}
		});
		
		tob.setOnTouchListener(new OnTouchListener() {

			@SuppressWarnings("deprecation")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(13);
				return false;
			}
		});

		myDateListener
		= new DatePickerDialog.OnDateSetListener() {


			@Override
			public void onDateSet(DatePicker view, int y, int monthOfYear,
					int dayOfMonth) {

				year=y;
				month=monthOfYear;
				day=dayOfMonth;

				dob.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+y);
			}
		};
		timePickerListener = new TimePickerDialog.OnTimeSetListener() {


			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {


				updateTime(hourOfDay,minutes);

			}



		};
	

	}

		

		
		

			
			public void onMyClick() {
				
				String name1= "Name: "+name.getText().toString()+"\n";
				String sex1=  "Sex: "+   sex.getText().toString()+"\n";
				String dob1="Date of birth: "+dob.getText().toString()+"\n";
				String tob1=  "Time of birth: "+     tob.getText().toString()+"\n";
				String city1="City: "+city.getText().toString()+"\n";
				String state1="State: "+state.getText().toString()+"\n";
				String country1="Country: "+country.getText().toString()+"\n";
				String mob1="Mobile No.: "+mob.getText().toString()+"\n";
				String e_mail1="Email: "+e_mail.getText().toString()+"\n";
				String query1="Query: "+query.getText().toString()+"\n";
				String hi="Hi,"+"\n"+"Please predict my future, my detail as follows:"+"\n";
				String body=hi+  name1+    sex1+      dob1+      tob1+    city1+    state1+   country1+   mob1+  e_mail1+query1;	
					

					// final String[] TO = {"astrologer@appsbazaar.in"};
				final String[] TO = {"munishmisra007@gmail.com"};
				//	final String[] BCC = {"feedback@appsbazaar.in"};
				final String[] BCC = {"pradeep.sharma9157@gmail.com"};
					final Intent emailIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:"));
				//	emailIntent.setData(Uri.parse("mailto:"));
			   //   emailIntent.setType("message/rfc822");

String subject="Predict My Future";
					emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
					emailIntent.putExtra(Intent.EXTRA_BCC,BCC);
					emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
				//	emailIntent.putExtra(Intent.EXTRA_TEXT,""+"\n"+ "name:- "+namet+"\n"+"Mobile:-"+mobile+"\n"+"Date of birth  :- "+dobt+" \n"+"Time of birth :-"+timet+"\n"+"Place of birth:-"+pobt+"\n"+"Query:-"+qtext);
					emailIntent.putExtra(Intent.EXTRA_TEXT,body);
					
						startActivity(emailIntent);
						query.setText(null);

						e_mail.setText(null);
						mob.setText(null);
						country.setText(null);
						state.setText(null);

						city.setText(null);
						tob.setText(null);
						dob.setText(null);
						sex.setText(null);
						name.setText(null);

						//dialog.dismiss();
						//finish();
						
						
			
		}
			
				
			
		



	
	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == 12) {
			return new DatePickerDialog(this, myDateListener, year, month, day);
		}
		else if(id==13)
		{

			return new TimePickerDialog(this, timePickerListener, hour, minute,
					false);
		}
		return null;
	}

	// Used to convert 24hr format to 12hr format with AM/PM values
	private void updateTime(int hours, int mins) {

		String timeSet = "";
		if (hours > 12) {
			hours -= 12;
			timeSet = "PM";
		} else if (hours == 0) {
			hours += 12;
			timeSet = "AM";
		} else if (hours == 12) {
			timeSet = "PM";
		} else {
			timeSet = "AM";
		}


		String minutes = "";
		if (mins < 10) {
			minutes = "0" + mins;
		} else {
			minutes = String.valueOf(mins);
		}

		// Append in a StringBuilder
		final String aTime = new StringBuilder().append(hours).append(':')
				.append(minutes).append(" ").append(timeSet).toString();

		tob.setText(aTime);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.query_btn:
			
			validation();
/*
			
*/
		//	

				
		//	}
			
			break;

		case R.id.brief:
			query_type="FREE";
			//onMyClick("Free: Need Brief Answer");
			 new HttpAsyncTask().execute("http://www.appsbazaar.in/android/horoscope/query.php");
			 dialog.dismiss();
			break;

		case R.id.detail:
			query_type="PAID";
			onPurchaseItemClick(v);
			//onMyClick("Paid: Need Urgent Detailed Answer");
			dialog.dismiss();
			break;
		case R.id.close:
			dialog.dismiss();
		
			
	}
}







	@Override
	public void onPurchaseItemClick(View v) {
		// TODO Auto-generated method stub
		 navigate().toPurchasePassportActivityForResult();
	}
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
           
      if (Navigator.REQUEST_PASSPORT_PURCHASE == requestCode) {
            if (RESULT_OK == resultCode) {
                dealWithSuccessfulPurchase();
            } else {
                dealWithFailedPurchase();
            }
        }
    }

    private void dealWithSuccessfulPurchase() {
      //  Log.d("Passport purchased");
        popToast("You query is sent.");
      //  http://www.appsbazaar.in/android/horoscope/query.php
        //"http://hmkcode.appspot.com/jsonservlet"
        new HttpAsyncTask().execute("http://www.appsbazaar.in/android/horoscope/query.php");
    }
    
    
    
    

    private void dealWithFailedPurchase() {
       // Log.d("Passport purchase failed");
        popToast("Failed to send your query");
    }
    /////send datat to server
  
    
    
    
    
    
    
    public String sendQuery(String url, Person person)
   {
	   InputStream inputStream = null;
       String result = "";
       try {
//dob,time,query,pob,name,mob;
           // 1. create HttpClient
           HttpClient httpclient = new DefaultHttpClient();

           // 2. make POST request to the given URL
           HttpPost httpPost = new HttpPost(url);

           String json = "";
///////////////////////
           
           // 3. build jsonObject
           JSONObject jsonObject = new JSONObject();
           jsonObject.accumulate("query_type",query_type);
           jsonObject.accumulate("name",person.getName().toString());
           jsonObject.accumulate("sex",person.getSex().toString());
           jsonObject.accumulate("dob",person.getDob().toString());
           jsonObject.accumulate("tob",person.getTob().toString());
           jsonObject.accumulate("city",person.getCity().toString());
           jsonObject.accumulate("state",person.getState().toString());
           jsonObject.accumulate("country",person.getCountry().toString());
           jsonObject.accumulate("mob",person.getMob().toString());
           jsonObject.accumulate("e_mail",person.getE_mail().toString());
          jsonObject.accumulate("query",person.getQuery().toString());

           // 4. convert JSONObject to JSON to String
           json = jsonObject.toString();
           
           ////------------------
           
           /////////=-----------------
           
           
           
           
           
Log.d("json",json);
           // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
           // ObjectMapper mapper = new ObjectMapper();
           // json = mapper.writeValueAsString(person); 

           // 5. set json to StringEntity
           StringEntity se = new StringEntity(json);

           // 6. set httpPost Entity
           httpPost.setEntity(se);

           // 7. Set some headers to inform server about the type of the content   
           httpPost.setHeader("Accept", "application/json");
           httpPost.setHeader("Content-type", "application/json");

           // 8. Execute POST request to the given URL
         //  HttpResponse httpResponse = httpclient.execute(httpPost);
           HttpResponse httpResponse = (HttpResponse)httpclient.execute(httpPost);

           // 9. receive response as inputStream
          inputStream = httpResponse.getEntity().getContent();

           // 10. convert inputstream to string
           if(inputStream != null)
               result = convertInputStreamToString(inputStream);
           else
               result = "Did not work!";

       } catch (Exception e) {
           Log.d("InputStream", e.getLocalizedMessage());
       }
Log.d("response",result);
       // 11. return result
       return result;
   

   }
   private static String convertInputStreamToString(InputStream inputStream) throws IOException{
       BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
       String line = "";
       String result = "";
       while((line = bufferedReader.readLine()) != null)
           result += line;

       inputStream.close();
       return result;

   }  
   private class HttpAsyncTask extends AsyncTask<String, Void, String> {
	   String response=null;
	   String floatMessage=null;
       @Override
       protected String doInBackground(String... urls) {

           person = new Person();
           person.setQuery_type(query_type);
           person.setName(name.getText().toString());
           person.setSex(sex.getText().toString());
           person.setDob(dob.getText().toString());
           person.setTob(tob.getText().toString());
           person.setCity(city.getText().toString());
           person.setState(state.getText().toString());
           person.setCountry(country.getText().toString());
           person.setMob(mob.getText().toString());
           person.setE_mail(e_mail.getText().toString());
          person.setQuery(query.getText().toString());
           
           
          response=sendQuery(urls[0],person);
          try {
			JSONObject resJson=new JSONObject(response);
			floatMessage=resJson.getString("message");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          return response;
    // return sendQuery(urls[0],person);
        
    	   
    	   
       }
       // onPostExecute displays the results of the AsyncTask.
       @Override
       protected void onPostExecute(String result) {
           Toast.makeText(getBaseContext(), floatMessage, Toast.LENGTH_LONG).show();
      }
   }
private void  validation()
{
final String name1=name.getText().toString();
final String sex1=sex.getText().toString();
final String dob1=dob.getText().toString();
final String tob1=tob.getText().toString();
final String city1=city.getText().toString();
final String state1 = state.getText().toString();
final String country1 = country.getText().toString();
final String mob1 = mob.getText().toString();
final String e_mail1 = e_mail.getText().toString();
final String query1 = query.getText().toString();
String s=getString(R.string.can_not_be_left_blank_);

	if(name1.equals(""))
	{
		name.setError(s);
	}

	else if(sex1.equals(""))
	{
		sex.setError(s);
		name.setError(null);
	}
	
	else if(dob1.equals(""))
	{
		dob.setError(s);
		sex.setError(null);
		name.setError(null);
	}
	else if(tob1.equals(""))
	{
		tob.setError(s);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);
	}

	else if(city1.equals(""))
	{
		city.setError(s);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);

	}
	else if(state1.equals(""))
	{
		state.setError(s);

		city.setError(null);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);


	}
	else if(country1.equals(""))
	{
		country.setError(s);
		state.setError(null);

		city.setError(null);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);

	}
	else if(mob1.equals(""))
	{
		mob.setError(s);
		country.setError(null);
		state.setError(null);

		city.setError(null);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);

	}
	else if(e_mail1.equals(""))
	{
		e_mail.setError(s);
		mob.setError(null);
		country.setError(null);
		state.setError(null);

		city.setError(null);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);

	}
	else if(query1.equals(""))
	{
		query.setError(s);

		e_mail.setError(null);
		mob.setError(null);
		country.setError(null);
		state.setError(null);

		city.setError(null);
		tob.setError(null);
		dob.setError(null);
		sex.setError(null);
		name.setError(null);


	}
	else {

		dialog.show();
	//	onMyClick();
		
	}
	}
}