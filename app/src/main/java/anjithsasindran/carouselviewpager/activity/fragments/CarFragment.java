package anjithsasindran.carouselviewpager.activity.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import anjithsasindran.carouselviewpager.R;
import anjithsasindran.carouselviewpager.activity.callback.CallbackToActivity;

/**
 * Created by Anjith Sasindran
 * on 12-Feb-16.
 */
public class CarFragment extends Fragment {

    View view;
    ImageView carImage;
    TextView carName;
    TextView carDetails;
    LinearLayout textBackground;
    LinearLayout fragmentContainer;
    CallbackToActivity obj;

    int defaultColor = 0x000000;
    int vibrantColor = -1, mutedColor = -1;
    int position;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.car_fragment_layout, container, false);
        obj = (CallbackToActivity) getActivity();

        carImage = (ImageView) view.findViewById(R.id.car_image);
        carName = (TextView) view.findViewById(R.id.car_name);
        carDetails = (TextView) view.findViewById(R.id.car_details);
        textBackground = (LinearLayout) view.findViewById(R.id.text_background);
        fragmentContainer = (LinearLayout) view.findViewById(R.id.container);
        setUpFragmentData();

        return view;
    }

    public void setUpFragmentData() {
        switch (position) {
            case 0:
                setCarImage(R.mipmap.chevrolet_corvette_stingray);
                setCarName("Chevrolet Corvette Stingray");
                setCarDetails("6.2 L LT4 Supercharged V8");
                setColors(R.mipmap.chevrolet_corvette_stingray);
                break;
            case 1:
                setCarImage(R.mipmap.bugatti);
                setCarName("Bugatti Veyron");
                setCarDetails("8.0 L W16 Quad-Turbocharged");
                setColors(R.mipmap.bugatti);
                break;
            case 2:
                setCarImage(R.mipmap.ferrari_458_italia);
                setCarName("Ferrari 458 Italia");
                setCarDetails("4.5 L Ferrari F136 F V8");
                setColors(R.mipmap.ferrari_458_italia);
                break;
            case 3:
                setCarImage(R.mipmap.lamborghini_aventador);
                setCarName("Lamborghini Aventador");
                setCarDetails("6.5 L L539 V12");
                setColors(R.mipmap.lamborghini_aventador);
                break;
            case 4:
                setCarImage(R.mipmap.pagani_zonda_cinque);
                setCarName("Pagani Zonda Cinque");
                setCarDetails("7.3 L AMG V12");
                setColors(R.mipmap.pagani_zonda_cinque);
                break;
        }
    }

    public void setCarImage(int image) {
        carImage.setImageResource(image);
    }

    public void setCarName(String name) {
        carName.setText(name);
    }

    public void setCarDetails(String details) {
        carDetails.setText(details);
    }

    public void setColors(int image) {

        if (vibrantColor == -1 && mutedColor == -1) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    vibrantColor = palette.getVibrantColor(defaultColor);
                    mutedColor = palette.getMutedColor(defaultColor);

                    obj.colorFetched(position, vibrantColor, mutedColor);

                    textBackground.setBackgroundColor(vibrantColor);
                    fragmentContainer.setBackgroundColor(mutedColor);
                }
            });
        } else {
            textBackground.setBackgroundColor(vibrantColor);
            fragmentContainer.setBackgroundColor(mutedColor);
        }
    }

    public Fragment setFragmentPosition(int position, int vibrantColor, int mutedColor) {
        this.position = position;
        this.vibrantColor = vibrantColor;
        this.mutedColor = mutedColor;
        return this;
    }
}