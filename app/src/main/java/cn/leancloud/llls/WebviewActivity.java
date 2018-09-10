package cn.leancloud.llls;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

/**
 * describe 该类主要完成以下功能
 */

public class WebviewActivity extends AppCompatActivity {

    private WebView webview;

    private String url = "http://www.baidu.com";

    private LinearLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_webview);
        root = (LinearLayout) findViewById(R.id.root);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        webview= new WebView(this);
        root.addView(webview,layoutParams);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setGeolocationDatabasePath(getFilesDir().getPath());
//		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        // 支持javascript
        // 设置可以支持缩放
        webSettings.setSupportZoom(true);
        // 设置出现缩放工具
        // webSettings.setBuiltInZoomControls(true);
        // 扩大比例的缩放
        webSettings.setUseWideViewPort(true);//适应分辨率
        //开启 Application Caches 功能,不能打开
//        webSettings.setAppCacheEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //支持混合模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            url = bundle.getString("url");
        }
        webview.loadUrl(url);

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(webview.canGoBack()){
                webview.canGoBack();
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
