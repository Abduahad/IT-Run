package com.example.recyclerview.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.repository.HistoryRepository

class MainViewModel:ViewModel() {
    val repository: HistoryRepository = HistoryRepository()
    private val _historyLiveData: MutableLiveData<List<Any>> = MutableLiveData()


    fun fetchHistory(){
        Log.d("TestLiveData", "fetchHistory")
        _historyLiveData.postValue(repository.getHistory())
    }

    fun getHistory():LiveData<List<Any>>{
        return _historyLiveData
    }

    fun addNewItem(data: HistoryBodyData){
        _historyLiveData.value?.let {
            val list:ArrayList<Any> = ArrayList(it)
            list.add(data)
            _historyLiveData.postValue(list)
        }
    }

}