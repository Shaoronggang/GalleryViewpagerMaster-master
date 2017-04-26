package com.mikee.galleryviewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

	private GalleryViewPager mViewPager;
	private GallleryAdapter adapter;
	private List<Item> items = new ArrayList<>();
	private int[] mImgs = {R.drawable.meinv1, R.drawable.meinv2, R.drawable.meinv3, R.drawable.meinv4, R.drawable.meinv5};
	private String[] names = {"Angela", "奶茶妹", "赵奕欢", "萌妹子", "张馨予"};
	private String[] nations = {"美国", "中国", "法国", "日本", "加拿大"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (GalleryViewPager) findViewById(R.id.view_pager);

		findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return mViewPager.dispatchTouchEvent(motionEvent);
			}
		});

		for (int i = 0; i < mImgs.length; i++) {
			Item item = new Item();
			item.setImg(mImgs[i]);
			item.setName(names[i]);
			item.setNation(nations[i]);
			items.add(item);
		}
		adapter = new GallleryAdapter(getSupportFragmentManager(),this,items);
		mViewPager.setAdapter(adapter);
		mViewPager.setPageMargin(30);// 设置页面间距
		mViewPager.setOffscreenPageLimit(2);
		mViewPager.setCurrentItem(0);// 设置起始位置
		mViewPager.setPageTransformer(true, new DepthPageTransformer());
	}


//	class GalleryAdapter extends FragmentPagerAdapter {
//
//		int count = 3;// 默认10
//		Context mContext;
//
//		public GalleryAdapter(FragmentManager fm, Context context) {
//			super(fm);
//			this.mContext = context;
//		}
//
//		@Override
//		public Fragment getItem(int position) {
//			if(mOnItemClickListener != null) {
//			    mOnItemClickListener.onClick(position);
//			}
//			return ItemFragment.create(items.get(position).getName(),items.get(position).getNation(),"来自瑞士的设计与精确性",items.get(position).getImg());
//		}
//
//		/**
//		 * 数量设置为最大
//		 *
//		 * @return
//		 */
//		@Override
//		public int getCount() {
//			return items.size();
//		}
//
//		/**
//		 * 真实数量
//		 *
//		 * @return
//		 */
//		public int getRealCount() {
//			return this.count;
//		}
//
//
//	}
//
//	OnItemClickListener mOnItemClickListener;
//
//	/**
//	 * 添加点击事件的点击回调
//	 * @param mOnItemClickListener
//	 */
//	public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
//		this.mOnItemClickListener = mOnItemClickListener;
//	}
//
//	public interface OnItemClickListener {
//		void onClick(int position);
//	}



}
