package com.alorma.flyout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class ColorFragment extends SherlockFragment {

	private int res;
	
	public ColorFragment() {
		this.res = R.layout.frag0;
	}
	
	public ColorFragment(int resource) {
		this.res = resource;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(res, null);
	}
	
}
