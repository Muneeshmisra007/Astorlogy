package applist;



import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.appsbazaar.astrology.R;


public class MainActivity extends Activity{
TextView tvStatus;
 String mitem;
 
	 public static EditText tv;
	public static final String[] titles = new String[] {
		"Krishna Wallpaper",
        "Translator",
        "New Year Greetings",
        "Valentines Greetings",
        "Order Guide",
        "Christmas Wallpaper",
        "Christmas Greetings",
        "New Year Wallpaper",
        
        "Love Quotes",
        "Friendship Quotes",
        "BabyCare",
        "More..."
        };
	// private String[] myfriendnickname=null;
	 public static final Integer[] images = {	
	    	R.drawable.krishna,
	    	R.drawable.translator,
	    	R.drawable.newyear1,
	    	R.drawable.valentine1,
	    	R.drawable.order,
	    	R.drawable.christmas2,
	    	R.drawable.christmas1,
	    	R.drawable.newyear2,
	    	R.drawable.love,
	    	R.drawable.friends,
	    	R.drawable.babycare,
	    	R.drawable.more
	    };
	 ListView listView=null;
	 Context context=null;
	 ImageButton btnSave;
	 
	 ImageButton clear;
	 protected Object mActionMode;
	 
	 MyListAdapter adapter=null;
	 private List<MyFriendsSDetails> list=new ArrayList<MyFriendsSDetails>();
	 private static Vector<MyFriendsSDetails> list2=new Vector<MyFriendsSDetails>();
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.activity_main_grid);
			super.onCreate(savedInstanceState);
		//	AdView adView = (AdView) this.findViewById(R.id.textView1);
			// AdRequest adRequest = new AdRequest.Builder()
			// .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
		   // .addTestDevice("CC5F2C72DF2B356BBF0DA198")
		           
			final ActionBar bar = getActionBar();
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcbd32")));
			bar.setTitle(Html.fromHtml("<font face='SourceSansPro-Bold' color='#02132f'>Horoscope 2015</font>"));
			    listView = (ListView) findViewById(R.id.listview);
			    context=this;
	//	View footerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);
	//	listView.addFooterView(footerView);
			    //StartAppSDK.init(this, "112248655", "212383153", true);
				  
		 int[] colors = {0, 0xFFFF0000, 0}; 
	        listView.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
	       
	        listView.setDividerHeight(4);
        for(int index=0; index< titles.length; index++){
        	MyFriendsSDetails details=new MyFriendsSDetails(titles[index], images[index]);
        	list.add(details);
        }
           	
                
        adapter=new MyListAdapter(context, list);
        listView.setAdapter(adapter);
       listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
			/*
				Intent in=new Intent(getBaseContext(), Detail.class);	
				in.putExtra("pos", String.valueOf(position));
				startActivity(in);
	
			*/
			int pos=position;
			switch(pos)
			{
			case 0:
				String APP_PNAME1 = "com.impex.harekrishna.all";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME1)));
				break;
			case 1:
				String APP_PNAME11 = "com.translator.appsbazaar";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME11)));
				break;
			case 2:
				String APP_PNAME12 = "com.impex.newyear1.all";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME12)));
				break;
			case 3:
				String APP_PNAME13 = "com.impex.valentines1.all";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME13)));
				break;
			case 4:
				String APP_PNAME14 = "com.appsbazaar.orderguide";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME14)));
				break;
			case 5:
				String APP_PNAME15 = "com.impex.christmas2.all";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME15)));
				break;
			case 6:
				String APP_PNAME16 = "com.impex.christmas1.all";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME16)));
				break;
			case 7:
				String APP_PNAME17 = "com.impex.newyear2.all";
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME17)));
				break;
			case 8:
				String APP_PNAME18 = "com.appsbazaar.quoteslove";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME18)));
				break;
			case 9:
				String APP_PNAME19 = "com.appsbazaar.friendshipquotes";

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME19)));
				break;
			case 10:
				String APP_PNAME20 = "com.appsbazaar.babycare";
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME20)));
				break;
			case 11:

				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=AppsBazaar")));
				break;
			}
		
		}
    	   
	});
	}
	
}

