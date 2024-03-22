package com.example.recyclerview.ui


import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview.R
import com.example.recyclerview.core.BaseViewHolder
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.model.HistoryStatuses


class MyAdapter(private val mData: List<Any>, private val onClickListener: OnClickListener, val onLongClickListener:View.OnLongClickListener) : RecyclerView.Adapter<ViewHolder>() {
    private val HEAD_VIEW_TYPE=0
    private val BODY_VIEW_TYPE=1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType==HEAD_VIEW_TYPE){
            HeadViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_head, parent, false))
        }else {
            BodyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data= mData[position]
        if (holder is HeadViewHolder){
            holder.bind(data as String)
        }else if (holder is BodyViewHolder){
            holder.bind(data as HistoryBodyData)
            holder.itemView.setOnClickListener(onClickListener)
            holder.itemView.setOnLongClickListener(onLongClickListener)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(mData[position] is HistoryBodyData) BODY_VIEW_TYPE else HEAD_VIEW_TYPE
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class BodyViewHolder internal constructor(itemView: View) : BaseViewHolder<HistoryBodyData>(itemView) {
        private val textViewTitle: TextView = findViewById<TextView>(R.id.textViewTitle)
        private val textViewBody:TextView = findViewById<TextView>(R.id.textViewBody)
        private val textViewSum:TextView = findViewById<TextView>(R.id.textViewSum)
        private val imageViewStatus:ImageView =findViewById(R.id.imageViewStatus)
        private val imageViewService:ImageView = findViewById(R.id.imageViewService)

        override fun bind(item: HistoryBodyData) {
            textViewTitle.text=item.title
            textViewBody.text=item.body
            textViewSum.text=item.endText
            imageViewService.setImageResource(item.icon)
            when(item.status){
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
            itemView.tag = item
        }
    }

    inner class HeadViewHolder internal constructor(itemView: View) : BaseViewHolder<String>(itemView) {
        private val textViewTitle: TextView = findViewById(R.id.textView)

        override fun bind(item:String){
            textViewTitle.text=item

        }

    }
}
