package com.nghiatt.demomaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.nghiatt.demomaterialdesign.activities.MainActivity;
import com.nghiatt.demomaterialdesign.adapter.ListAdapter;
import com.nghiatt.demomaterialdesign.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran.thanh.nghia
 */
public class ListsCardsFragment extends BaseFragment<MainActivity> implements View.OnClickListener {

    private View mRootView;
    private RecyclerView mRecvList;
    private ListAdapter mAdapter;
    private List<Item> mList;
    private FloatingActionButton mFabAdd;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;


    private void init(){
        mList=new ArrayList<>();

        for(int i=0;i<30;i++){
            mList.add(new Item("Item "+i+(i%3==0?" text here aaaaaaaaaaaaaaaaaac aaa":"")));
        }

        mFabAdd=(FloatingActionButton)mRootView.findViewById(R.id.fab_add);
        mFabAdd.setOnClickListener(this);
        mRecvList=(RecyclerView)mRootView.findViewById(R.id.recv_list);
        linearLayoutManager= new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        gridLayoutManager=new GridLayoutManager(this.getContext(),3,LinearLayoutManager.VERTICAL,false);
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecvList.setLayoutManager(linearLayoutManager);
        mRecvList.setHasFixedSize(true);
        mAdapter=new ListAdapter(this.getContext(),mList);
        mRecvList.setAdapter(mAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_lists_cards,container,false);
        this.getMainActivity().setCollapsingToolbarLayoutTitle(getString(R.string.app_name));
        init();

        setHasOptionsMenu(true);
        return mRootView;
    }

   public void changeLayoutManager(RecyclerView.LayoutManager layoutManager){
       mRecvList.setLayoutManager(layoutManager);
   }

    public void showSnackBar(){
        Snackbar.make(mRootView,"show message here",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_list:
                Toast.makeText(this.getContext(),R.string.list,Toast.LENGTH_SHORT).show();
                changeLayoutManager(linearLayoutManager);
                return true;
            case R.id.action_grid:
                Toast.makeText(this.getContext(),R.string.grid,Toast.LENGTH_SHORT).show();
                changeLayoutManager(gridLayoutManager);
                return true;
            case R.id.action_staggered:
                Toast.makeText(this.getContext(),R.string.staggered,Toast.LENGTH_SHORT).show();
                changeLayoutManager(staggeredGridLayoutManager);
                return true;

            default:
                return false;
        }

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.fab_add:
                showSnackBar();
                break;
        }
    }
}
