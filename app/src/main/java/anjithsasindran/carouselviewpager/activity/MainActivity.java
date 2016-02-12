package anjithsasindran.carouselviewpager.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import anjithsasindran.carouselviewpager.R;
import anjithsasindran.carouselviewpager.activity.adapter.CarPagerAdapter;
import anjithsasindran.carouselviewpager.activity.callback.CallbackToActivity;

public class MainActivity extends AppCompatActivity implements CallbackToActivity {

    ViewPager mViewPager;
    CarPagerAdapter carPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carPagerAdapter = new CarPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(carPagerAdapter);
    }

    @Override
    public void colorFetched(int position, int vibrantColor, int mutedColor) {
        switch (position) {
            case 0:
                carPagerAdapter.setZerothPageColor(vibrantColor, mutedColor);
                break;
            case 1:
                carPagerAdapter.setFirstPageColor(vibrantColor, mutedColor);
                break;
            case 2:
                carPagerAdapter.setSecondPageColor(vibrantColor, mutedColor);
                break;
            case 3:
                carPagerAdapter.setThirdPageColor(vibrantColor, mutedColor);
                break;
            case 4:
                carPagerAdapter.setForthPageColor(vibrantColor, mutedColor);
                break;
        }
    }
}