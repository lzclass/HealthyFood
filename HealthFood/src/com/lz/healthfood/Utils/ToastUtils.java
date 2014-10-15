package com.lz.healthfood.Utils;

import com.lz.healthfood.AppManager;
import com.lz.healthfood.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @Description:自定义toast
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class ToastUtils extends Toast {

	private ToastUtils() {
		super(AppManager.getSelf());
	}

	public static Toast makeText(CharSequence text, int duration) {
		Toast result = new Toast(AppManager.getSelf());

		LayoutInflater inflate = (LayoutInflater) AppManager.getSelf()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.toast, null);
		TextView tv = (TextView) view.findViewById(R.id.tv_toast);
		tv.setText(text);

		result.setView(view);
		result.setDuration(duration);

		return result;
	}

	public static Toast makeText(int resId, int duration) {
		Toast result = new Toast(AppManager.getSelf());

		LayoutInflater inflate = (LayoutInflater) AppManager.getSelf()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.toast, null);
		TextView tv = (TextView) view.findViewById(R.id.tv_toast);
		tv.setText(AppManager.getSelf().getResources().getText(resId));

		result.setView(view);
		result.setDuration(duration);

		return result;
	}

}
