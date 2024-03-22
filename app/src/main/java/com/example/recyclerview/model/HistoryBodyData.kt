package com.example.recyclerview.model

import java.io.Serializable

data class HistoryBodyData(val icon:Int, val status: HistoryStatuses, val title: String, val body:String, val endText:String):Serializable {
}