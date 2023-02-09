package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

public class WebViewActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout frameLayout = new FrameLayout(this);
        setContentView(frameLayout);
        webView = new WebView(this);
        webView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        Button button = new Button(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        int margin = (int) (getResources().getDisplayMetrics().density * 8);
        lp.setMargins(margin, margin, margin, margin);
        lp.gravity = Gravity.START | Gravity.TOP;
        button.setLayoutParams(lp);
        button.setText("←");
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    onBackPressed();
                }
            }
        });

        frameLayout.addView(webView);
        frameLayout.addView(button);

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        }
        webView.setWebViewClient(new WebViewClient());
        webView.setInitialScale(1);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.loadUrl("https://files-s.feeltechdigivation.com/ContentAndChecking/BundleForTesting/");


        webView.setDownloadListener((downloadUrl, s1, s2, s3, l) -> {
            Intent intent = new Intent(WebViewActivity.this, UnityLauncherActivity.class);
            intent.putExtra("url", downloadUrl);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView = null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }
}
