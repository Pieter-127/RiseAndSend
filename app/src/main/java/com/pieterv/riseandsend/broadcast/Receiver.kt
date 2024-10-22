package com.pieterv.riseandsend.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Log.d("receiver", "airplane mode changed")
        }

//        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
//            Log.d("boot receiver", "boot completed")
//        }
    }
}
