package apps;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import appsbazaar.daily.horoscope.MainMenu;

import com.appsbazaar.astrology.R;
import com.astrology.menu.splash.MyAppRater;

public class MainActivity extends Activity {
	GridView grid;
	Button yes;
	Button no;
	Button rate;
	String[] web = { "Valentines Greetings", "Shoping Guide", "Baby Care",
			"Love Quotes", "Friends Quotes", "Unit Converter", "Translator",
			"Krishna Wallpaper 2015", "Valentines Wallpaper",

	};
	int[] imageId = { R.drawable.valentine1, R.drawable.order,
			R.drawable.babycare,
			R.drawable.love,
			R.drawable.friends, R.drawable.converter, R.drawable.translator,
			R.drawable.krishna, R.drawable.valentine2 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.applist_grid);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FE9A2E")));
		yes = (Button) findViewById(R.id.button3);
		no = (Button) findViewById(R.id.button1);
		rate = (Button) findViewById(R.id.button2);
		yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				yes();
			}

		});
		no.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				no();
			}
		});
		rate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rate();
			}
		});

		CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
		grid = (GridView) findViewById(R.id.grid);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Toast.makeText(MainActivity.this, "You Clicked at " +web[+
				// position], Toast.LENGTH_SHORT).show();
				int pos = position;
				switch (pos) {

				case 0:
					String APP_PNAME13 = "com.impex.valentines1.all";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME13)));
					break;

				case 1:
					String APP_PNAME11 = "com.appsbazaar.orderguide";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME11)));
					break;
				case 2:
					String APP_PNAME1 = "com.appsbazaar.babycare";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME1)));
					break;
				case 3:
					String APP_PNAME12 = "com.appsbazaar.quoteslove";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME12)));
					break;

				case 4:
					String APP_PNAME15 = "com.appsbazaar.friendshipquotes";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME15)));
					break;

				case 5:
					String APP_PNAME18 = "com.appsbazaar.unitconverter";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME18)));
					break;
				case 6:
					String APP_PNAME27 = "com.translator.appsbazaar";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME27)));
					break;
				case 7:
					String APP_PNAME28 = "com.impex.harekrishna.all";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME28)));
					break;
				case 8:
					String APP_PNAME29 = "com.impex.valentines2.all";

					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + APP_PNAME29)));
					break;
				}
			}
		});
	}
	public void rate() {
		// TODO Auto-generated method stub
		MyAppRater.showRateDialog(this, null);
		overridePendingTransition(R.anim.lefttoright, R.anim.stable);
	}
	public void no() {
		// TODO Auto-generated method stub
		Intent grid = new Intent(getBaseContext(),
				MainMenu.class);
		grid.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(grid);
	}
	public void yes() {
		// TODO Auto-generated method stub
		System.exit(0);
		// android.os.Process.killProcess(android.os.Process.myPid());
		// finish();
	}

}
