package ilkadam.ilkflow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import ilkadam.ilkflow.ui.theme.IlkFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        InterstitialAd.load(
            this,
            "ca-app-pub-5764318432941968/8532245108",
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitialAd.show(this@MainActivity)
                }
            })

        setContent {
            IlkFlowTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { AdMobBanner() }
                )
                { innerPadding ->
                    ilkFlowView(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ilkFlowView(modifier: Modifier = Modifier) {
    val url = "http://77.245.150.206:21408/"
    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    this.settings.javaScriptEnabled = true
                    this.webViewClient = WebViewClient()
                    this.loadUrl(url)
                }
            },
            update = { webView ->
                webView.loadUrl(url)
            }
        )

    }
}