package com.example.podslidersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.podslider.OnPodClickListener;
import com.example.podslider.PodSlider;

public class MainActivity extends AppCompatActivity implements OnPodClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PodSlider podSlider = (PodSlider) findViewById(R.id.pod_slider);
        podSlider.setPodClickListener(new OnPodClickListener() {
            @Override
            public void onPodClick(int position) {
                Log.d("PodPosition", "position = " + position);
            }
        });
        podSlider.setCurrentlySelectedPod(1);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        PodSlider pagerSlider = (PodSlider) findViewById(R.id.pager_slider);
        PodPagerAdapter adapter = new PodPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pagerSlider.setUpWithViewPager(pager);
    }

    @Override
    public void onPodClick(int position) {

    }

    private class PodPagerAdapter extends FragmentStatePagerAdapter {
        public PodPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new BlankFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
