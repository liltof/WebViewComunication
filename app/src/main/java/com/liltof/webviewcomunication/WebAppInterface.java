package com.liltof.webviewcomunication;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;

public class WebAppInterface {
    WebView page1;

    /** Instantiate the interface and set the context */
    WebAppInterface(WebView p1) {
        page1 = p1;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void sendToPage1(final String text) {
        page1.post(new Runnable() {
            @Override
            public void run() {
                page1.loadUrl("javascript:(function(){document.getElementById('text1').innerHTML = '" + text + "';return false;})()");
            }
        });

    }

}