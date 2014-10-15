package com.lz.healthfood;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

public class AppManager extends Activity {

	private static AppManager mApp;
	private List<Activity> mActivitys;

	public AppManager() {
		mApp = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivitys = new ArrayList<Activity>();
	}

	public void push(Activity mActivity) {
		for (int i = 0; i < mActivitys.size(); i++) {
			if (mActivitys.get(i) == mActivity) {
				return;
			}
		}
		mActivitys.add(mActivity);
	}

	public void exit() {
		for (Activity activity : mActivitys) {
			activity.finish();
		}
	}

	public static AppManager getSelf() {
		return mApp;
	}
}
