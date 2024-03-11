package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayout= view.findViewById<LinearLayout>(R.id.linearLayout)
        initItems(getHistory())
    }

    private fun initItems( list:List<HistoryBodyData>){
        list.forEach {data->
            val itemView = getItemView()
            bindItem(itemView,data)
            linearLayout.addView(itemView)
        }
    }

    fun getHistory():List<HistoryBodyData>{
        val list:ArrayList<HistoryBodyData> = ArrayList()
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.SUCCES,"Tcell","92 616 44 36","10 TJS"))
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.REJECT,"Tcell","(92 777 77 77)","100 TJS"))
        list.add(HistoryBodyData(R.drawable.ic_tcell,HistoryStatuses.IN_PROGRESS,"Tcell","92 111 11 11","50 TJS"))
        return list
    }

    private fun getItemView():View{ return  LayoutInflater.from(requireContext()).inflate(R.layout.list_item, null, false) }

    private fun bindItem(itemView:View, data: HistoryBodyData){
        val textViewTitle: TextView = itemView.findViewById<TextView>(R.id.textViewTitle)
        val textViewBody: TextView = itemView.findViewById<TextView>(R.id.textViewBody)
        val textViewSum: TextView = itemView.findViewById<TextView>(R.id.textViewSum)
        val imageViewStatus: ImageView =itemView.findViewById(R.id.imageViewStatus)
        val imageViewService: ImageView = itemView.findViewById(R.id.imageViewService)
        textViewTitle.text=data.title
        textViewBody.text=data.body
        textViewSum.text=data.endText
        imageViewService.setImageResource(data.icon)
        when(data.status){
            HistoryStatuses.IN_PROGRESS->{
                imageViewStatus.setImageResource(R.drawable.ic_status_proccess)
            }
            HistoryStatuses.SUCCES->{
                imageViewStatus.setImageResource(R.drawable.ic_status_done)
            }
            HistoryStatuses.REJECT->{
                imageViewStatus.setImageResource(R.drawable.ic_status_rejected)
            }
            else->{}
        }
        itemView.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        context?.let {
            Toast.makeText(it,"Item Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}