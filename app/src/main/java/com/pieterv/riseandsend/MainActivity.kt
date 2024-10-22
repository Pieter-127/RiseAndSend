package com.pieterv.riseandsend

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pieterv.riseandsend.broadcast.Receiver
import com.pieterv.riseandsend.ui.theme.RiseAndSendTheme

class MainActivity : ComponentActivity() {

    private lateinit var receiver: Receiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        receiver = Receiver()

        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        //Register the receiver dynamically
        //required for higher api levels
        registerReceiver(receiver, intentFilter)
        setContent {
            RiseAndSendTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RiseAndSendTheme {
        Greeting("Android")
    }
}