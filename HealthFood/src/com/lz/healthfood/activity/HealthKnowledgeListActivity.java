package com.lz.healthfood.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.lz.healthfood.BaseActivity;
import com.lz.healthfood.R;
import com.lz.healthfood.Utils.MyAsyncTask;
import com.lz.healthfood.Utils.UtilsLog;
import com.lz.healthfood.entity.FoodList;
import com.lz.healthfood.entity.ReslutList;
import com.lz.healthfood.net.HttpApi;

/**
 * @Description:
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class HealthKnowledgeListActivity extends BaseActivity {
	private ListView listView;
	List<FoodList> list = new ArrayList<FoodList>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_knowledgelist);
		listView = (ListView) findViewById(R.id.knowledgelist_lv);
		new GetListDataAT(mContext, true, true).execute();
	}

	class GetListDataAT extends MyAsyncTask<Void, Void, ReslutList<FoodList>> {

		public GetListDataAT(Context mContext, Boolean isToastShow,
				Boolean isDialogShow) {
			super(mContext, isToastShow, isDialogShow);
		}

		@Override
		protected ReslutList<FoodList> doInBackground(Void... arg0) {

			return HttpApi.getListData();
		}

		@Override
		protected void onPostExecute(ReslutList<FoodList> result) {
			UtilsLog.i(TAG, result.toString());
			super.onPostExecute(result);
		}

	}

}
