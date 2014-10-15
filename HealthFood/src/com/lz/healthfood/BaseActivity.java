package com.lz.healthfood;

import com.lz.healthfood.Utils.StringUtils;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class BaseActivity extends Activity {
	protected Context mContext;

	public BaseActivity() {
		mContext = this;
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public void toast(String msg) {
		if (StringUtils.isNullOrEmpty(msg)) {
			return;
		}
		Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
	}
}
