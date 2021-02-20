package kr.teamcadi.myapa.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import kr.teamcadi.myapa.fragment_medicial.EyeFragment;
import kr.teamcadi.myapa.fragment_medicial.InternalFragment;
import kr.teamcadi.myapa.fragment_medicial.ToothFragment;

public class HomeFragViewPagerAdapter extends FragmentStateAdapter
{
    private final static int NUM_PAGES = 3;

    public HomeFragViewPagerAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    public HomeFragViewPagerAdapter(@NonNull Fragment fragment)
    {
        super(fragment);
    }

    public HomeFragViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch(position)
        {
            case 0:
                return new EyeFragment();
            case 1:
                return new InternalFragment();
            case 2:
                return new ToothFragment();
            default:
                break;
        }
        return new EyeFragment();
    }

    @Override
    public int getItemCount()
    {
        return NUM_PAGES;
    }
}
