package anjithsasindran.carouselviewpager.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import anjithsasindran.carouselviewpager.activity.fragments.CarFragment;

/**
 * Created by Anjith Sasindran
 * on 12-Feb-16.
 */
public class CarPagerAdapter extends FragmentStatePagerAdapter {

    public static final int PAGE_COUNT = 5;
    int zeroColor[] = {-1, -1};
    int firstColor[] = {-1, -1};
    int secondColor[] = {-1, -1};
    int thirdColor[] = {-1, -1};
    int forthColor[] = {-1, -1};


    public CarPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CarFragment().setFragmentPosition(position, zeroColor[0], zeroColor[1]);
            case 1:
                return new CarFragment().setFragmentPosition(position, firstColor[0], firstColor[1]);
            case 2:
                return new CarFragment().setFragmentPosition(position, secondColor[0], secondColor[1]);
            case 3:
                return new CarFragment().setFragmentPosition(position, thirdColor[0], thirdColor[1]);
            case 4:
                return new CarFragment().setFragmentPosition(position, forthColor[0], forthColor[1]);
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public void setZerothPageColor(int vibrantColor, int mutedColor) {
        zeroColor[0] = vibrantColor;
        zeroColor[1] = mutedColor;
    }

    public void setFirstPageColor(int vibrantColor, int mutedColor) {
        firstColor[0] = vibrantColor;
        firstColor[1] = mutedColor;
    }

    public void setSecondPageColor(int vibrantColor, int mutedColor) {
        secondColor[0] = vibrantColor;
        secondColor[1] = mutedColor;
    }

    public void setThirdPageColor(int vibrantColor, int mutedColor) {
        thirdColor[0] = vibrantColor;
        thirdColor[1] = mutedColor;
    }

    public void setForthPageColor(int vibrantColor, int mutedColor) {
        forthColor[0] = vibrantColor;
        forthColor[1] = mutedColor;
    }
}