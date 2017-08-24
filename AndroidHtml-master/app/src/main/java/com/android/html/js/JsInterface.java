package com.android.html.js;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Author: river
 * Date: 2016/3/29 14:30
 * Description: js调用
 */
class JsInterface {
    private Context mContext;

    public JsInterface(Context context) {
        this.mContext = context;
    }

    /**
     * 1.  在js中调用window.AndroidWebView.setVideoUrlFromJs(url)，便会触发此方法。
     *   此方法名称一定要和js中sendVideoUrlToJava中调用的方法名称一致
     *
     * @param url 用于在网页中点击视频链接，在本地对该视频进行播放。
     */
    @JavascriptInterface
    public void setVideoUrlFromJs(String url) {
        Toast.makeText(mContext, "JS传递给App的视频url:"+url, Toast.LENGTH_SHORT).show();
    }

    /**
     * 2.  在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
     *   此方法名称一定要和js中showInfoFromJava方法一样
     *
     * @param userId 用于查询用户头像及个人名称，职位等用户信息的ID
     */
    @JavascriptInterface
    public void showInfoFromJs(String userId) {
        Toast.makeText(mContext, "来自js的userId:" + userId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 3.  在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
     *   此方法名称一定要和js中showInfoFromJava方法一样
     *
     * @param userId 用于查询用户头像及个人名称，职位等用户信息的ID
     */
    @JavascriptInterface
    public String showInfoFromJs() {
        Toast.makeText(mContext, "JS调用App方法", Toast.LENGTH_SHORT).show();
        return "abc";
    }


}
