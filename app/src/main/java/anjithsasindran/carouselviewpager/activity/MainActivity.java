package anjithsasindran.carouselviewpager.activity;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import anjithsasindran.carouselviewpager.R;
import anjithsasindran.carouselviewpager.adapter.CarPagerAdapter;
import anjithsasindran.carouselviewpager.callback.CallbackToActivity;
import anjithsasindran.carouselviewpager.constant.Constant;

public class MainActivity extends AppCompatActivity implements CallbackToActivity {

    ViewPager mViewPager;
    CarPagerAdapter carPagerAdapter;
    ArgbEvaluator argbEvaluator;
    boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        argbEvaluator = new ArgbEvaluator();
        carPagerAdapter = new CarPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(carPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // carPagerAdapter.getCount() - 1 because, of using Constant.mutedColor[position] + 1
                if (position < carPagerAdapter.getCount() - 1) {
                    mViewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,
                            Constant.mutedColors[position], Constant.mutedColors[position + 1]));
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*
    Once color is fetched from respective fragments, they are sent back to MainActivity
    which then sets the colors to adapters.
     */
    @Override
    public void colorFetched(int position, int vibrantColor, int mutedColor) {
        carPagerAdapter.setPageColor(position, vibrantColor, mutedColor);

        if (firstTime) {
            mViewPager.setBackgroundColor(mutedColor);
            firstTime = false;
        }
    }
}