package app.android.aidl.server

import android.app.Service
import android.content.Intent
import android.os.IBinder

class Server : Service() {
    private var counter = 0

    override fun onCreate() {
        super.onCreate()
    }

    private val binder = object : IAIDLFeatureInterface.Stub() {
        override fun getCurrentValue(): String {
            return "This is the new counter : ${counter++}"
        }

        override fun getDataList(limit: Int): List<String> {

            return run {
                val list = arrayListOf<String>()
                repeat(limit) {
                    list.add(it.toString())
                }
                list
            }
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

}