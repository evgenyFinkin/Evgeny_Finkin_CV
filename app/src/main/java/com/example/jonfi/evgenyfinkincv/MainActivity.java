package com.example.jonfi.evgenyfinkincv;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.jonfi.evgenyfinkincv.Fragments.Bio;
import com.example.jonfi.evgenyfinkincv.Fragments.Education;
import com.example.jonfi.evgenyfinkincv.Fragments.Experience;
import com.example.jonfi.evgenyfinkincv.Fragments.SkillsAndProjects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate starting");

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupVievPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupVievPager(ViewPager viewPager)   {
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new Bio(), "Bio");
        sectionPageAdapter.addFragment(new Education(), "Education");
        sectionPageAdapter.addFragment(new Experience(), "Experience");
        sectionPageAdapter.addFragment(new SkillsAndProjects(), "Skills&Projects");
        viewPager.setAdapter(sectionPageAdapter);
    }
}
