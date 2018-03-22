package com.example.jonfi.evgenyfinkincv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jonfi on 21/03/2018.
 */

public class GitWebViewActivity extends AppCompatActivity {
    private static final String TAG = "GitWebViewActivity";

    private WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_webview);
        mWebView = (WebView)findViewById(R.id.git_webview);
        mWebView.loadUrl(String.valueOf(getIntent().getStringExtra("Url")));
    }

}
