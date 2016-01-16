package com.example.myfragmentbackstack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentTwo extends Fragment implements OnClickListener {

	private Button mBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		mBtn = (Button) view.findViewById(R.id.id_fragment_two_btn);
		mBtn.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentThree fThree = new FragmentThree();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.hide(this);
		tx.add(R.id.id_content, fThree, "THREE");
		// tx.replace(R.id.id_content, fThree, "THREE");
		tx.addToBackStack(null);
		tx.commit();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_fragment_two, menu);  
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {  
        case R.id.action_fragment_two:  
            Toast.makeText(getActivity(), "FragmentMenuItem2", Toast.LENGTH_SHORT).show();  
            break;  
        }  
        return true; 
	}
}
