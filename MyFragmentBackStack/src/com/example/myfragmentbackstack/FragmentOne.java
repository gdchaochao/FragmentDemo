package com.example.myfragmentbackstack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentOne extends Fragment implements OnClickListener {

	private static final String TAG = "FragmentOne";  
	private static final String DATA_KEY = "fragment_one_data_key";
	
	private Button mBtn;
	private EditText mEt;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		mBtn = (Button) view.findViewById(R.id.id_fragment_one_btn);
		mBtn.setOnClickListener(this);
		mEt = (EditText) view.findViewById(R.id.id_fragment_one_et);
		if (savedInstanceState != null) {
			String text = (String) savedInstanceState.get(DATA_KEY);
			mEt.setText(text);
		}
		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentTwo fTwo = new FragmentTwo();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.replace(R.id.id_content, fTwo, "TWO");
		tx.addToBackStack(null);
		tx.commit();

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.e(TAG, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		Log.e(TAG, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.e(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		String text;
		try {
			text = mEt.getText().toString();
		} catch (Exception e) {
			text = "";
		}
		outState.putString(DATA_KEY, text);
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_fragment_one, menu);  
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {  
        case R.id.action_fragment_one:  
            Toast.makeText(getActivity(), "FragmentMenuItem1", Toast.LENGTH_SHORT).show();  
            break;  
        }  
        return true; 
	}

}
