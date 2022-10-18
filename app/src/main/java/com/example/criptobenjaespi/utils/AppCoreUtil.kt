package com.example.criptobenjaespi.utils

import android.content.Context
import android.net.ConnectivityManager

object AppCoreUtil {
    var context: Context? = null
    fun checkNetworkConnect(): Boolean {
        var wifiConnect: Boolean = false
        var isMobileConnect: Boolean = false

        context?.let {
            val manager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            manager.allNetworks.forEach { network ->
                manager.getNetworkInfo(network)?.apply {
                    if (type == ConnectivityManager.TYPE_WIFI){
                        wifiConnect = wifiConnect or isConnected
                    }
                    if(type == ConnectivityManager.TYPE_MOBILE){
                        isMobileConnect = isMobileConnect or isConnected
                    }
                }
            }
        }

        return wifiConnect || isMobileConnect
    }
}