package com.lingolive.app
import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this); setContentView(webView)
        webView.settings.apply {
            javaScriptEnabled = true; domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false; allowFileAccess = true
            useWideViewPort = true; loadWithOverviewMode = true
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(req: PermissionRequest) { req.grant(req.resources) }
        }
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://468013291jeffery.github.io/lingolive-mqi740tw/")
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() { if (webView.canGoBack()) webView.goBack() else super.onBackPressed() }
}