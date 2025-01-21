package ilkadam.appodeal

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appodeal.ads.Appodeal
import com.appodeal.ads.initializing.ApdInitializationCallback
import com.appodeal.ads.initializing.ApdInitializationError
import ilkadam.appodeal.ui.theme.AppodealTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Appodeal.initialize(
            this,
            "6d40e196920c7815666b78ea8189297244fff1f070ac2b4a",
            Appodeal.INTERSTITIAL,
            object : ApdInitializationCallback {
                override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    if (errors == null || errors.isEmpty()) {
                        Appodeal.show(
                            this@MainActivity,
                            Appodeal.INTERSTITIAL
                        )
                    }
                }

            }
        )

        setContent {
            AppodealTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    Button(
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
                                Appodeal.show(this, Appodeal.INTERSTITIAL)
                            }else{
                                this.showToast("Interstitial not loaded")
                            }
                        })
                    { Text("Hello, world") }
                }
            }
        }
    }
}

private fun Context.showToast(message: String) =
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()