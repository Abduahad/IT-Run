package com.example.recyclerview.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.repository.HistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val _loading:MutableLiveData<Boolean> = MutableLiveData()
    val loading:LiveData<Boolean> = _loading

    val repository: HistoryRepository = HistoryRepository()

    fun fetchHistory_thread():LiveData<List<Any>>{
        Log.d(TAG, "1.fetchHistory_thread: called")
        val result:MutableLiveData<List<Any>> = MutableLiveData()
        val myThread:Thread = Thread(Runnable {
            //_loading.postValue(true)
            Log.d(TAG, "3.Thread: run and sleep")
            Thread.sleep(10000)
            Log.d(TAG, "4.Thread: resumed")
            //val data = repository.getHistory()
            //result.postValue(data)
            _loading.postValue(false)
        })
        Log.d(TAG, "2.fetchHistory_thread: thread created and started")
        myThread.start()
        return result
    }

    fun fetchHistory():LiveData<List<Any>>{
        Log.d(TAG, "1.fetchHistory: start")
        val result:MutableLiveData<List<Any>> = MutableLiveData()
        viewModelScope.launch {
            _loading.postValue(true)
            Log.d(TAG, "2.inside couroutine thread")
            val history:ArrayList<Any> = ArrayList()
            history.addAll(repository.getHistory())
            history.addAll(repository.getHistory())
            history.addAll(repository.getHistory())
            result.postValue(history)
            Log.d(TAG, "end of couroutine thread")
            _loading.postValue(false)
        }
        Log.d(TAG, "2.fetchHistory: end")
        return result
    }

    fun fetchAllHistory():LiveData<List<Any>>{
        val result:MutableLiveData<List<Any>> = MutableLiveData()
        viewModelScope.launch {
            val history:ArrayList<Any> = ArrayList()
            Log.d(TAG, "fetchHistory: Coroutine start")
            _loading.postValue(true)
            async {
                Log.d(TAG, "1.fetchHistory: async start")
                history.addAll(repository.getHistory())
            }

            async {
                Log.d(TAG, "2.fetchHistory: async start")
                history.addAll(repository.getHistory())
            }

            async {
                Log.d(TAG, "3.fetchHistory: async start")
                history.addAll(repository.getHistory())
            }.await()
            _loading.postValue(false)
            //delay(2500)
            result.postValue(history)
            Log.d(TAG, "fetchHistory:Coroutine end")
        }
        return result
    }



    fun addNewItem(data: HistoryBodyData){
        /*_historyLiveData.value?.let {
            val list:ArrayList<Any> = ArrayList(it)
            list.add(data)
            _historyLiveData.postValue(list)
        }*/
    }

}