package movieapplication.activity.com.designtesttwo.UI;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import movieapplication.activity.com.designtesttwo.Fragments.Help_Frag;
import movieapplication.activity.com.designtesttwo.Fragments.HomeFragment;
import movieapplication.activity.com.designtesttwo.Fragments.ProfileFragment;


public class fragmentAdapter extends FragmentPagerAdapter {
    FragmentManager mFragmentManager;
    public fragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return  new HomeFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new Help_Frag();


        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
