package com.developmentmill.gamechallenge;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.developmentmill.gamechallenge.main.GameListener;
import com.developmentmill.gamechallenge.main.Level;

public class Game extends AndroidApplication {

	PowerManager.WakeLock wl;
	PowerManager pm;
	
	public static Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		context = this;
		initialize(new GameListener(), false, 16);
//		setContentView(null);
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Tag");
	}

	@Override
	protected void onResume() {
		if (wl != null)
			wl.acquire();
		super.onResume();
	}

	@Override
	protected void onPause() {
		if (wl != null)
			wl.release();
		super.onPause();
	}
}