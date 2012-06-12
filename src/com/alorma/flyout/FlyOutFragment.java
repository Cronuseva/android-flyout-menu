package com.alorma.flyout;

import java.util.HashMap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class FlyOutFragment extends SherlockFragment implements OnClickListener {

	private LinearLayout layout;
	private OnFlyOutListener listener;
	private HashMap<String, Integer> map;

	public FlyOutFragment() {
		map = new HashMap<String, Integer>();
		map.put("#BBB6ED", R.layout.frag0);
		map.put("#FF663A", R.layout.frag1);
		map.put("#AAC63A", R.layout.frag2);
		map.put("#FAC43A", R.layout.frag3);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		layout = (LinearLayout) inflater.inflate(R.layout.flyout, null);
		
		getViews();
		
		return layout;
	}
	
	private void getViews() {
		Button btn1 = (Button) layout.findViewById(R.id.btn1);
		Button btn2 = (Button) layout.findViewById(R.id.btn2);
		Button btn3 = (Button) layout.findViewById(R.id.btn3);
		Button btn4 = (Button) layout.findViewById(R.id.btn4);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		String txt = ((Button) view).getText().toString();
		
		if (listener != null) {
			listener.onFlyOutSelected(map.get(txt));
		}
	}
	
	public OnFlyOutListener getListener() {
		return listener;
	}

	public void setListener(OnFlyOutListener listener) {
		this.listener = listener;
	}

	public interface OnFlyOutListener {
		void onFlyOutSelected(int resource);
	}
}
