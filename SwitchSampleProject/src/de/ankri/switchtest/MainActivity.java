package de.ankri.switchtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import de.ankri.views.Switch;

public class MainActivity extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView lightBulb = (ImageView) this.findViewById(R.id.light_bulb);

		Switch switchA = (Switch) this.findViewById(R.id.switch_a);

		switchA.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

			}
		});

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

		Switch switchB = (Switch) this.findViewById(R.id.switch_b);
		switchB.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
