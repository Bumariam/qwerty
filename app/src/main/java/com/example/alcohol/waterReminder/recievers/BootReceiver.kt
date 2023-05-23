package com.example.alcohol.recievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.alcohol.helpers.AlarmHelper
import com.example.alcohol.utils.AppUtils

class BootReceiver : BroadcastReceiver() {
    private val alarm = AlarmHelper()

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && intent.action != null) {
            if (intent.action == "android.intent.action.BOOT_COMPLETED") {
                val prefs = context!!.getSharedPreferences(AppUtils.USERS_SHARED_PREF, AppUtils.PRIVATE_MODE)
                val notificationFrequency = prefs.getInt(AppUtils.NOTIFICATION_FREQUENCY_KEY, 60)
                val notificationsNewMessage = prefs.getBoolean("notifications_new_message", true)
                alarm.cancelAlarm(context)
                if (notificationsNewMessage) {
                    alarm.setAlarm(context, notificationFrequency.toLong())
                }
            }
        }
    }
}
