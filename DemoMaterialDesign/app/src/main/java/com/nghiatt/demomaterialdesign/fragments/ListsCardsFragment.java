package com.nghiatt.demomaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.activities.MainActivity;
import com.nghiatt.demomaterialdesign.adapter.ListAdapter;
import com.nghiatt.demomaterialdesign.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran.thanh.nghia
 */
public class ListsCardsFragment extends BaseFragment<MainActivity> {

    private View mRootView;
    private RecyclerView mRecvList;
    private ListAdapter mAdapter;
    private List<Item> mList;


    private void init(){
        mList=new ArrayList<>();

        for(int i=0;i<30;i++){
            mList.add(new Item("Item "+i));
        }

        mRecvList=(RecyclerView)mRootView.findViewById(R.id.recv_list);
        mRecvList.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        mRecvList.setHasFixedSize(true);
        mAdapter=new ListAdapter(this.getContext(),mList);
        mRecvList.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_lists_cards,container,false);
        init();
        return mRootView;
    }

    public void setLayout(int layoutManager){

    }
}
