package de.ankri.switchtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import de.ankri.R;
import de.ankri.views.Switch;

public class MainActivity extends Activity
{
	private static final String PREF_NAME = "SwitchButtonDemo";
	private static final String PREF_THEME = "isDark";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// Load the settings
		SharedPreferences preferences = this.getSharedPreferences(PREF_NAME, 0);
		boolean isDark = preferences.getBoolean(PREF_THEME, false);

		// set the theme according to the setting
		if (isDark)
			this.setTheme(R.style.AppThemeDark);
		else
			this.setTheme(R.style.AppThemeLight);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// create the light bulb. graphics are from the fugue icon pack - http://p.yusukekamiyamane.com/
		final ImageView lightBulb = (ImageView) this.findViewById(R.id.light_bulb);

		Switch switchA = (Switch) this.findViewById(R.id.switch_a);
		switchA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (isChecked)
					lightBulb.setImageDrawable(getResources().getDrawable(R.drawable.light_bulb));
				else
					lightBulb.setImageDrawable(getResources().getDrawable(R.drawable.light_bulb_off));
			}
		});
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		// get the shared preferences
		SharedPreferences preferences = this.getSharedPreferences(PREF_NAME, 0);
		Editor editor = preferences.edit();

		// change the settings according to selection
		switch (item.getItemId())
		{
			case R.id.menu_dark_theme:
				editor.putBoolean(PREF_THEME, true);
				break;
			case R.id.menu_light_theme:
				editor.putBoolean(PREF_THEME, false);
				break;
		}

		editor.commit();

		// restart activity
		Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivity(i);

		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);

		// compatibility for api level 11+
		MenuItemCompat.setShowAsAction(menu.findItem(R.id.menu_dark_theme), MenuItemCompat.SHOW_AS_ACTION_NEVER);
		MenuItemCompat.setShowAsAction(menu.findItem(R.id.menu_light_theme), MenuItemCompat.SHOW_AS_ACTION_NEVER);

		return true;
	}
}
