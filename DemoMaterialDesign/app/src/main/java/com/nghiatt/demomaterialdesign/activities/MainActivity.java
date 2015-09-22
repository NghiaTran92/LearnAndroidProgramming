package com.nghiatt.demomaterialdesign.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.fragments.ListsCardsFragment;
import com.nghiatt.demomaterialdesign.fragments.TabLayoutFragment;
import com.nghiatt.demomaterialdesign.fragments.TextInputFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, AppBarLayout.OnOffsetChangedListener {

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private CoordinatorLayout mRootCoordinatorLayout;
    private boolean isExpand=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        mRootCoordinatorLayout=(CoordinatorLayout)findViewById(R.id.root_coordinator);
        mAppBarLayout=(AppBarLayout)findViewById(R.id.appbar_toolbar);
        mCollapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collap_toolbar);



        mNavigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        mNavigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));
        mCollapsingToolbarLayout.setTitleEnabled(true);
        showDrawer();

        startFragment(ListsCardsFragment.class, null);

    }

    public void setCollapsingToolbarLayoutTitle(String title) {

        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
    }

    public void setExpanded(boolean isExpand){
        mAppBarLayout.setExpanded(isExpand, true);
    }

    public void navigate(int itemID){
        switch (itemID){
            case R.id.navigation_item_1:
                startFragment(ListsCardsFragment.class,null);
                break;
            case R.id.navigation_item_2:
                startFragment(TextInputFragment.class,null);
                break;
            case R.id.navigation_item_3:
                startFragment(TabLayoutFragment.class,null);
                break;
        }
        if(isExpand) {
            setExpanded(false);
        }
        closeDrawer();
    }

    public void showDrawer(){
        mDrawerLayout.openDrawer(GravityCompat.START);
    }
    public void closeDrawer(){
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public CoordinatorLayout getRootCoordinatorLayout(){
        return mRootCoordinatorLayout;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id=menuItem.getItemId();
        navigate(id);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        if (offset == 0)
        {
            // Collapsed
            isExpand=false;
        }
        else
        {
            // Not collapsed
            isExpand=true;
        }
        Log.i("MainActivity","isExpand="+isExpand);
    }
}
