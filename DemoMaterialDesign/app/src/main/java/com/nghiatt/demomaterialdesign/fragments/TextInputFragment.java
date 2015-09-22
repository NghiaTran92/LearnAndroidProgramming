package com.nghiatt.demomaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.activities.MainActivity;

/**
 * Created by tran.thanh.nghia
 */
public class TextInputFragment extends BaseFragment<MainActivity> {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_textinput,container,false);
        this.getMainActivity().setCollapsingToolbarLayoutTitle(getString(R.string.app_name));

        return mRootView;
    }
}
