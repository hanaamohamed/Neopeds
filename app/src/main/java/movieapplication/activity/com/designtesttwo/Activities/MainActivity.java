package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;


import movieapplication.activity.com.designtesttwo.Fragments.Help_Frag;
import movieapplication.activity.com.designtesttwo.Fragments.HomeFragment;
import movieapplication.activity.com.designtesttwo.Fragments.ProfileFragment;
import movieapplication.activity.com.designtesttwo.Fragments.SettingsFragment;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.fragmentAdapter;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        Help_Frag.OnFragmentInteractionListener {
    FloatingActionButton search;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawer;
    ActionBarDrawerToggle mDrawerToggle;
    String mTitle;
    Drawable mIcon;
    Context mContext;
    ImageButton showDrawer;
    boolean mSettingOpened;
    Fragment mSelectedFragment;
    SettingsFragment mSettingsFragment;
    ViewPager pager;
    fragmentAdapter mFragmentAdapter;
    TabHost tabHost;
    ImageView mAvatarView;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);

        tabHost.setup();


        String[] tabsTitles = {"home", "notification", "about"};
        int[] icons = {R.drawable.ic_home_white_36dp, R.mipmap.ic_assignment_white_36dp, R.drawable.ic_help_white_36dp};
        for (int i = 0; i < tabsTitles.length; i++) {
            String tabName = tabsTitles[i];
            TabHost.TabSpec spec = tabHost.newTabSpec(tabName);
            spec.setContent(new FakeContent());
            spec.setIndicator("", getResources().getDrawable(icons[i]));
            tabHost.addTab(spec);
        }


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                pager.setCurrentItem(tabHost.getCurrentTab());
            }

        });
        pager.setAdapter(mFragmentAdapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        showDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });

        mAvatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Profile_Ac.class));
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                if (mSettingOpened) {
                    getFragmentManager().beginTransaction().remove(mSettingsFragment).commit();
                    mSettingOpened = false;
                }
                drawer.closeDrawers();
                Intent intent;
                switch (menuItem.getItemId()) {
                    case R.id.AssignLeader:
                        intent = new Intent(mContext, AssignLeaderAc.class);
                        startActivity(intent);
                        return true;
                    case R.id.addCourse:
                        intent = new Intent(mContext, AddCourse_Ac.class);
                        startActivity(intent);
                        return true;
                    case R.id.manageCourse:
                        intent = new Intent(mContext, ManageCourse_Ac.class);
                        startActivity(intent);
                        return true;
                    case R.id.report:
                        intent = new Intent(mContext, Report_Ac.class);
                        startActivity(intent);
                        return true;
                    case R.id.wishList:
                        Intent intent2 = new Intent(mContext, WishList_Ac.class);
                        startActivity(intent2);
                        return true;
                    case R.id.userterms:
                        intent = new Intent(mContext, Terms_Ac.class);
                        startActivity(intent);
                        return true;
                    case R.id.settings:
                        intent = new Intent(mContext, SettingActivity.class);
                        startActivity(intent);
                        return true;
                    default:
                        mIcon = menuItem.getIcon();
                        mTitle = getString(R.string.app_name);
                        break;
                }

                return true;
            }
        });
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.drawerOpened,
                R.string.drawerClosed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return super.onOptionsItemSelected(item);
            }
        };
        drawer.setDrawerListener(mDrawerToggle);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    private class FakeContent implements TabHost.TabContentFactory {


        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(mContext);
            fakeView.setMinimumHeight(100);
            fakeView.setMinimumWidth(100);
            return fakeView;

        }
    }

    private void init() {
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        search = (FloatingActionButton) findViewById(R.id.search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        mContext = getApplicationContext();
        showDrawer = (ImageButton) findViewById(R.id.drawer_toggle);
        pager = (ViewPager) findViewById(R.id.pager);
        mFragmentAdapter = new fragmentAdapter(getSupportFragmentManager());
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        mAvatarView = (ImageView) findViewById(R.id.acc_img);

    }

    void openDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.END)) drawer.closeDrawer(GravityCompat.END);
        else
            drawer.openDrawer(GravityCompat.END);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
