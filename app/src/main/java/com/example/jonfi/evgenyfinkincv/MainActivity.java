package com.example.jonfi.evgenyfinkincv;

import android.content.Intent;
import android.net.Uri;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jonfi.evgenyfinkincv.Fragments.Education;
import com.example.jonfi.evgenyfinkincv.Fragments.Experience;
import com.example.jonfi.evgenyfinkincv.Fragments.SkillsAndProjects;
import com.example.jonfi.evgenyfinkincv.Service.SectionPageAdapter;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate starting");


        //DONE: build a better UI

        mSectionPageAdapter = new SectionPageAdapter (getSupportFragmentManager());

        FabSpeedDial mFabSpeedDial = (FabSpeedDial) findViewById(R.id.fabSpeedDail);
        mFabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                //Show menu
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId())   {
                    case R.id.action_call:
                        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                        phoneIntent.setData(Uri.parse("tel:"+Constants.getPhoneNum()));
                        if (phoneIntent.resolveActivity(getPackageManager()) != null)    {
                        startActivity(phoneIntent);
                        }else {
                            Toast.makeText(MainActivity.this,"No phone app was found", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.action_email:
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, Constants.getMailAddress());
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, Constants.getSubject());
                        emailIntent.putExtra(Intent.EXTRA_TEXT, Constants.getBody());
                        if (emailIntent.resolveActivity(getPackageManager()) != null)    {
                            startActivity(emailIntent);
                        }else {
                            Toast.makeText(MainActivity.this,"No mailing app was found", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.action_li:
                        Uri webpage = Uri.parse(Constants.getLinkedinUrl());
                        Intent liIntent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (liIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(liIntent);
                        }else {
                            Toast.makeText(MainActivity.this,"No browser was found", Toast.LENGTH_SHORT).show();
                        }
                        break;
                        default:
                            return true;
                }
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupVievPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupVievPager(ViewPager viewPager)   {
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new Education(), "Education");
        sectionPageAdapter.addFragment(new Experience(), "Experience");
        sectionPageAdapter.addFragment(new SkillsAndProjects(), "Projects");
        viewPager.setAdapter(sectionPageAdapter);
    }
}
