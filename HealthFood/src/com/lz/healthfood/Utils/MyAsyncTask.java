package com.lz.healthfood.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.AsyncTask;
import android.widget.Toast;

public abstract class MyAsyncTask<Params, Progress, T> extends
		AsyncTask<Params, Progress, T> {
	private Context mContext;
	/** 是否显示Toast */
	private boolean isShowToast;
	/** 是否显示对话框 */
	private boolean isShowDialog;
	private Dialog mDialog;

	public MyAsyncTask(Context mContext, Boolean isToastShow,
			Boolean isDialogShow) {
		this.mContext = mContext;
		this.isShowToast = isToastShow;
		this.isShowDialog = isDialogShow;

	}

	public <T> MyAsyncTask(T data, Context mContext, Boolean isToastShow,
			Boolean isDialogShow) {
		this.mContext = mContext;
		this.isShowToast = isToastShow;
		this.isShowDialog = isDialogShow;

	}

	@Override
	protected void onPreExecute() {
		if (!NetUtils.isNetConn(mContext)) {
			if (isShowToast) {
				Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
			}
			cancel(true);
		}
		if (isShowDialog) {
			mDialog = DialogUtils.showProcessDialog(mContext, "正在加载");
		}
		if (mDialog != null)
			mDialog.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {
					cancel(true);
				}
			});
		super.onPreExecute();
	}

	@Override
	protected void onCancelled() {
		if (mDialog != null && mDialog.isShowing()) {
			mDialog.dismiss();
		}
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(T result) {
		if (mDialog != null && mDialog.isShowing()) {
			mDialog.dismiss();
		}

		super.onPostExecute(result);
	}

}
