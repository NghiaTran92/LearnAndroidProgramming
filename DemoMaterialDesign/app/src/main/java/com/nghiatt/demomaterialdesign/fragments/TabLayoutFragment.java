package com.nghiatt.demomaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.activities.MainActivity;
import com.nghiatt.demomaterialdesign.adapter.TabPagerAdapter;

/**
 * Created by tran.thanh.nghia
 */
public class TabLayoutFragment extends BaseFragment<MainActivity> {
    private View mRootView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_tablayout,container,false);

        this.getMainActivity().setCollapsingToolbarLayoutTitle(getString(R.string.app_name));

        mTabLayout=(TabLayout)mRootView.findViewById(R.id.tab_layout);
        mViewPager=(ViewPager)mRootView.findViewById(R.id.view_pager);
        mAdapter=new TabPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        return mRootView;
    }
}
