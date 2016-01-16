package com.example.myfragmentcomm;

import com.example.myfragmentcomm.FragmentOne.FOneBtnClickListener;
import com.example.myfragmentcomm.FragmentTwo.FTwoBtnClickListener;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity implements FOneBtnClickListener,
		FTwoBtnClickListener {

	private FragmentOne mFOne;
	private FragmentTwo mFTwo;
	private FragmentThree mFThree;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		mFOne = new FragmentOne();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.add(R.id.id_content, mFOne, "ONE");
		tx.commit();
	}

	/**
	 * FragmentOne 按钮点击时的回调
	 */
	@Override
	public void onFOneBtnClick() {

		if (mFTwo == null) {
			mFTwo = new FragmentTwo();
			mFTwo.setfTwoBtnClickListener(this);
		}
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.replace(R.id.id_content, mFTwo, "TWO");
		tx.addToBackStack(null);
		tx.commit();
	}

	/**
	 * FragmentTwo 按钮点击时的回调
	 */
	@Override
	public void onFTwoBtnClick() {
		if (mFThree == null) {
			mFThree = new FragmentThree();

		}
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.hide(mFTwo);
		tx.add(R.id.id_content, mFThree, "THREE");
		// tx.replace(R.id.id_content, fThree, "THREE");
		tx.addToBackStack(null);
		tx.commit();
	}

}
