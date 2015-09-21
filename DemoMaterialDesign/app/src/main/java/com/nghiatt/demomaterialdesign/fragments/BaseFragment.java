package com.nghiatt.demomaterialdesign.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by tran.thanh.nghia
 */
public class BaseFragment<T extends Activity> extends Fragment {
    protected T mActivity;

    @Override
    public void onAttach(Activity activity) {
        this.mActivity=(T)activity;
        super.onAttach(activity);
    }

    public T getMainActivity(){
        return mActivity;
    }
}
