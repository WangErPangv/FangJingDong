package wby.laowang.fangjingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        //获取从banner传过来的url地址
        String burl = getIntent().getStringExtra("burl");

        //web的一系列设置包括请数据
        webView.loadUrl(burl);

        //webview一系列设置
        webView.setWebViewClient(new WebViewClient());//在当前应用打开,而不是去浏览器
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
    }
}
