package com.example.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.model.HistoryStatuses
import com.example.recyclerview.R
private const val HISTORY_DATA = "HISTORY_DATA"
class DetailFragment : Fragment() {
    private var data: HistoryBodyData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getSerializable(HISTORY_DATA, HistoryBodyData::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemView = getItemView()
        data?.let {
            bindItem(itemView,it)
            view.findViewById<FrameLayout>(R.id.frameLayout).addView(itemView)
        }
    }

    private fun getItemView(): View { return  LayoutInflater.from(requireContext())
        .inflate(R.layout.list_item, null, false) }

    private fun bindItem(itemView: View, data: HistoryBodyData){
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
            HistoryStatuses.IN_PROGRESS ->{
                imageViewStatus.setImageResource(R.drawable.ic_status_proccess)
            }
            HistoryStatuses.SUCCES ->{
                imageViewStatus.setImageResource(R.drawable.ic_status_done)
            }
            HistoryStatuses.REJECT ->{
                imageViewStatus.setImageResource(R.drawable.ic_status_rejected)
            }
            else->{}
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(data: HistoryBodyData) = DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(HISTORY_DATA, data)
                }
            }
    }
}