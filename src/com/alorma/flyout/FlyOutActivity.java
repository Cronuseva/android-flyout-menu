package com.alorma.flyout;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.alorma.flyout.FlyOutFragment.OnFlyOutListener;

public class FlyOutActivity extends SherlockFragmentActivity implements
		OnFlyOutListener, ActionMode.Callback {

	private FlyOutFragment fragment_flyOut;
	private ColorFragment fragment_color;
	private ActionMode mode;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		getSupportActionBar().setHomeButtonEnabled(true);

		getFragments();
		setUpViews();
	}

	private void getFragments() {
		fragment_flyOut = new FlyOutFragment();
		fragment_flyOut.setListener(this);
	}

	private void setUpViews() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		if (fragment_color == null) {
			fragment_color = new ColorFragment();
		}

		ft.replace(R.id.layout_main, fragment_color);

		ft.commit();
	}

	private void setUpViews(int resource) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		fragment_color = new ColorFragment(resource);

		ft.replace(R.id.layout_main, fragment_color);

		ft.commit();
	}

	@Override
	public void openOptionsMenu() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		ft.replace(R.id.layout_flyout, fragment_flyOut);

		ft.commit();

		mode = startActionMode(this);

		super.openOptionsMenu();
	}

	@Override
	public void closeOptionsMenu() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		ft.remove(fragment_flyOut);

		ft.commit();
		super.closeOptionsMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			if (!fragment_flyOut.isVisible()) {
				openOptionsMenu();
			} else {
				closeOptionsMenu();
			}
		}

		return true;
	}

	@Override
	public void onFlyOutSelected(int resource) {
		setUpViews(resource);
		// closeOptionsMenu();
		// mode.finish();
	}

	@Override
	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		return true;
	}

	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		return false;
	}

	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		return true;
	}

	@Override
	public void onDestroyActionMode(ActionMode mode) {
		closeOptionsMenu();
	}

}