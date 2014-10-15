package com.lz.healthfood.Utils;

import com.lz.healthfood.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class DialogUtils {
	/**
	 * 弹出TextProcessDialog
	 * 
	 * @param content
	 *            显示内容
	 */
	public static Dialog showProcessDialog(Context context, String content) {
		Dialog customDialog = new Dialog(context);
		customDialog.setContentView(R.layout.process_dialog);
		customDialog.findViewById(R.id.pb_loading_process).setVisibility(
				View.VISIBLE);
		((TextView) customDialog.findViewById(R.id.tv_process))
				.setText(content);
		customDialog.show();
		return customDialog;
	}
}
