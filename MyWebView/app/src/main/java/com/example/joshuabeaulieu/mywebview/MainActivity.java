package com.example.joshuabeaulieu.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new WebViewClient());
        // zoom out the page to fit display
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        // provides pinch zoom operation
        webview.getSettings().setBuiltInZoomControls(true);
        // enables Javascript
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.youtube.com");
    }
}
