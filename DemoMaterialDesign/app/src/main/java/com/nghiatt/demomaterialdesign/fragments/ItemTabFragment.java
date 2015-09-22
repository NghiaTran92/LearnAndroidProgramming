package com.nghiatt.demomaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.adapter.ListAdapter;
import com.nghiatt.demomaterialdesign.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran.thanh.nghia
 */
public class ItemTabFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecvList;
    private ListAdapter mAdapter;
    private List<Item> mList;

    private String mTitle="";



    private void init(){
        mList=new ArrayList<>();

        for(int i=0;i<30;i++){
            mList.add(new Item("Item "+i+(i%3==0?" text here aaaaaaaaaaaaaaaaaac aaa":"")));
        }


        mRecvList=(RecyclerView)mRootView.findViewById(R.id.recv_list_item);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        mRecvList.setLayoutManager(linearLayoutManager);
        mRecvList.setHasFixedSize(true);
        mAdapter=new ListAdapter(this.getContext(),mList);
        mRecvList.setAdapter(mAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_item_tab,container,false);
        init();

        setHasOptionsMenu(true);
        return mRootView;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }


}
