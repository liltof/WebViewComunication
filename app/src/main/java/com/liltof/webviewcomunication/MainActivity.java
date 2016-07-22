package com.liltof.webviewcomunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView page1 = (WebView) findViewById(R.id.web1);
        page1.setWebChromeClient(new WebChromeClient());
        page1.setWebViewClient(new WebViewClient());
        page1.getSettings().setJavaScriptEnabled(true);
        WebView page2 = (WebView) findViewById(R.id.web2);
        page2.setWebChromeClient(new WebChromeClient());
        page2.setWebViewClient(new WebViewClient());
        page2.getSettings().setJavaScriptEnabled(true);
        //we add our javascript interface that we will call in the webview using MyInterface
        page2.addJavascriptInterface(new WebAppInterface(page1), "MyInterface");
        page1.loadUrl("file:///android_asset/page1.html");
        page2.loadUrl("file:///android_asset/page2.html");
    }
}
