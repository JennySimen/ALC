package com.example.challenge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {
    private WebView myWebView;
    private ProgressDialog progDailog;
    private String url = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("About ALC");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Web.this, MainActivity.class);
                startActivity(home);
            }
        });

        progDailog = ProgressDialog.show(this, "Loading","Please wait...", true);
        progDailog.setCancelable(false);

        myWebView = (WebView) findViewById(R.id.webview);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.setWebViewClient(new SSLTolerentWebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl(url);
    }

    private class SSLTolerentWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

    }

}
