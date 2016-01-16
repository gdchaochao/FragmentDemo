package com.example.myfragmentbackstack;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			FragmentManager fm = getFragmentManager();
			FragmentTransaction tx = fm.beginTransaction();
			tx.add(R.id.id_content, new FragmentOne(), "ONE");
			tx.commit();
		}
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_main:
			Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
			return true;
		default:
			// 如果希望Fragment自己处理MenuItem点击事件，一定不要忘了调用super.xxx
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

}
