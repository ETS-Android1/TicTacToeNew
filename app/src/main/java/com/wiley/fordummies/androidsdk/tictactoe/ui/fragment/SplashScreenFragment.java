package com.wiley.fordummies.androidsdk.tictactoe.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.wiley.fordummies.androidsdk.tictactoe.R;

/**
 * Fragment for splash screen.
 *
 * Created by adamcchampion on 2017/08/03.
 */

public class SplashScreenFragment extends Fragment implements View.OnTouchListener{
    private boolean mIsActive = true;
    private final int mSplashTime = 500;
    private final int mTimeIncrement = 100;
    private final int mSleepTime = 100;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_splash, container, false);
        v.setOnTouchListener(this);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Thread for displaying the SplashScreen
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int elapsedTime = 0;
                    while (mIsActive && (elapsedTime < mSplashTime)) {
						sleep(mSleepTime);
                        if (mIsActive) elapsedTime = elapsedTime + mTimeIncrement;
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    // Activity activity = requireActivity();
					// activity.finish();
					startActivity(new Intent("com.wiley.fordummies.androidsdk.tictactoe.Login"));
                }
            }
        };
        splashThread.start();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            mIsActive = false;
            view.performClick();

            return true;
        }
        return false;
    }
}
