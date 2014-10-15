package com.lz.healthfood.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.lz.healthfood.BaseActivity;
import com.lz.healthfood.R;
import com.lz.healthfood.Utils.MyAsyncTask;

/**
 * @Description:
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class HealthKnowledgeListActivity extends BaseActivity {
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_knowledgelist);
	}

	class GetListDataAT<Params, Progress, Result> extends
			MyAsyncTask<Params, Progress, Result> {

		public GetListDataAT(Context mContext, Boolean isToastShow,
				Boolean isDialogShow) {
			super(mContext, isToastShow, isDialogShow);

		}

		@Override
		protected Result doInBackground(Params... arg0) {
			
			return null;
		}

	}

}
