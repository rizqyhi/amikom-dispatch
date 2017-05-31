package me.rizqy.amikomdispatch;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by amikom on 04/05/2017.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] {"Recent", "Bookmarked"};
    private Context context;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new RecentNewsFragment();
                break;
            case 1:
                fragment = new BookmarkedNewsFragment();
                break;
            default:
                fragment = null;
        }

        return fragment;
    }
}
