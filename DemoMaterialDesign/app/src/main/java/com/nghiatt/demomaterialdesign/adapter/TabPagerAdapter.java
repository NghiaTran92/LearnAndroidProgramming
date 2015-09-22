package com.nghiatt.demomaterialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nghiatt.demomaterialdesign.fragments.ItemTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran.thanh.nghia
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private List<ItemTabFragment> mList;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        mList=new ArrayList<>();
        for(int i=0;i<12;i++) {
            ItemTabFragment item= new ItemTabFragment();
            item.setTitle("item "+i);
            mList.add(item);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return (mList==null)?0:mList.size();
    }
}
