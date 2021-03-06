package com.example.jonfi.evgenyfinkincv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

/**
 * Created by jonfi on 18/03/2018.
 */

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(7500)
                .withBackgroundResource(android.R.color.background_light)
                .withHeaderText("Welcome")
                .withFooterText("Copyright 2018")
                .withBeforeLogoText("Evgeny Finkin production")
                .withLogo(R.drawable.my_pic)
                .withAfterLogoText("TO contact me, click on the message icon at the bottom right.");






        View view = config.create();
        setContentView(view);

    }
}
