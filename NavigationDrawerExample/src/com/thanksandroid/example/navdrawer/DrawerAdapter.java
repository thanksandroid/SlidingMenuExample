package com.thanksandroid.example.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Custom adapter used with navigation list.
 */
public class DrawerAdapter extends BaseAdapter {

	private final Context mContext;
	private final String[] navItems;

	public DrawerAdapter(Context context, String[] navItems) {
		this.mContext = context;
		this.navItems = navItems;
	}

	@Override
	public int getCount() {
		return navItems.length;
	}

	@Override
	public Object getItem(int position) {
		return navItems[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.drawer_list_item, null);
			holder.text = (TextView) convertView.findViewById(R.id.text1);
			holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.text.setText(navItems[position]);
		holder.icon.setImageResource(getNavIcon(position));
		return convertView;
	}

	static class ViewHolder {
		TextView text;
		ImageView icon;
	}

	private int getNavIcon(int position) {
		int resId = 0;
		switch (position) {
			case 0:
				resId = R.drawable.ic_user;
				break;
			case 1:
				resId = R.drawable.ic_add_user;
				break;
			case 2:
				resId = R.drawable.ic_group;
				break;
			case 3:
				resId = R.drawable.ic_add_group;
				break;
			case 4:
				resId = R.drawable.ic_settings;
				break;
		}
		return resId;
	}
}