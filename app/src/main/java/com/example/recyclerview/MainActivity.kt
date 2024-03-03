package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter:MyAdapter = MyAdapter(getHistory())
        recyclerView.adapter = adapter
    }

    fun getHistory():List<Any>{
        val list:ArrayList<Any> = ArrayList()
        list.add("29.02.2024")
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add("01.03.2024")
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add("02.03.2024")
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        list.add(HistoryBodyData(R.drawable.img,"Title","Body","End Text"))
        return list
    }
}