package com.xing.main.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.widget.ProgressWebView;
import com.xing.main.R;



@Route(path = "/web/WebViewActivity")
public class WebViewActivity extends BaseActivity {

    private ProgressWebView webView;
    private String url;
    private int id;
    private String title;
    private String author;
    private MenuItem favoriteMenuItem;
    private MenuItem shareMenuItem;
    private boolean hadFavorited = false;
    private Toolbar toolbar;
    private long mPressedTime;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void initView() {
        toolbar = findViewById(R.id.toolbar_title);
         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleWebViewBack();
            }
        });

        webView = findViewById(R.id.wv_web);


        webView.setWebViewCallback(new ProgressWebView.WebViewCallback() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                toolbar.setTitle(title);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }

            @Override
            public void onLoadResource(WebView view, String url) {

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

            @Override
            public void onPageLoadComplete() {

            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return false;
            }

            @Override
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {

            }
        });
    }

    private void handleWebViewBack() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间

        if (webView.canGoBack()) {
            webView.goBack();
        }else{
            this.finish();
        }
         if((mNowTime - mPressedTime) > 1000){//比较两次按键时间差
             mPressedTime = mNowTime;
        }else{
            this.finish();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra(Constants.URL);
            webView.loadUrl(url);
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_alpha, R.anim.anim_web_exit);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webView.removeAllViews();
        webView = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            handleWebViewBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
