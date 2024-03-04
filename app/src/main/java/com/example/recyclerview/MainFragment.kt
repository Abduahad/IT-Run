package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter:MyAdapter = MyAdapter(getHistory(),this)
        recyclerView.adapter = adapter
    }

    fun getHistory():List<Any>{
        val list:ArrayList<Any> = ArrayList()
        list.add("29.02.2024")
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.SUCCES,"Tcell","92 616 44 36","10 TJS"))
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.REJECT,"Tcell","(92 777 77 77)","100 TJS"))
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS"))
        return list
    }

    override fun onClick(v: View?) {
        context?.let {
            Toast.makeText(it,"Item Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}