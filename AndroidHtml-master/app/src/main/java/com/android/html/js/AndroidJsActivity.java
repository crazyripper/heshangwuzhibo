package com.android.html.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.android.html.R;

/**
 * js与Android互调，交互
 */
public class AndroidJsActivity extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_js);
        webView = (WebView) findViewById(R.id.webView);

        webView.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

        // 加载本地网页
        webView.loadUrl("file:///android_asset/index_js.html");
//        webView.loadUrl("http://www.baidu.com");

        //在js中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");

        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置监听
        onInvokeJs();
    }

    /**
     * App调用JS代码
     */
    private void onInvokeJs() {
        findViewById(R.id.btn_invoke_js).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = ((EditText) findViewById(R.id.input_et)).getText().toString();
                //调用js中的函数：showInfoFromApp(url + name)
                webView.loadUrl("javascript:showInfoFromApp('" + msg + "')");
            }
        });
    }

}
