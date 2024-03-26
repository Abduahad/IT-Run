package com.example.recyclerview.repository

import android.util.Log
import com.example.recyclerview.R
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.model.HistoryStatuses
import com.example.recyclerview.ui.TAG
import kotlinx.coroutines.delay

class HistoryRepository {
    suspend fun getHistory():List<Any>{
        delay(2000)
        Log.d(TAG, "getHistory")
        val list:ArrayList<Any> = ArrayList()
        list.add("29.02.2024")
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.SUCCES,"Tcell","92 616 44 36","10 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.REJECT,"Tcell","(92 777 77 77)","100 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        list.add(
            HistoryBodyData(
                R.drawable.ic_tcell,
                HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS")
        )
        return list
    }
}