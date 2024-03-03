package com.example.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class MyAdapter( private val mData: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType==0){
            HeadViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_head, parent, false))
        }else {
            BodyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data=mData.get(position)
        if (holder is HeadViewHolder){
            holder.bind(data as String)
        }else if (holder is BodyViewHolder){
            holder.bind(data as HistoryBodyData)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if(mData.get(position) is HistoryBodyData) 1 else 0
    }


    override fun getItemCount(): Int {
        return mData.size
    }

    inner class BodyViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {
        private val textViewTitle: TextView
        private val textViewBody:TextView
        private val textViewSum:TextView
        private val imageViewStatus:ImageView
        private val imageViewService:ImageView

        init {
            textViewTitle = itemView.findViewById<TextView>(R.id.textViewTitle)
            textViewBody = itemView.findViewById<TextView>(R.id.textViewBody)
            textViewSum = itemView.findViewById<TextView>(R.id.textViewSum)
            imageViewService=itemView.findViewById(R.id.imageViewService)
            imageViewStatus=itemView.findViewById(R.id.imageViewStatus)
        }

        fun bind(item: HistoryBodyData) {
            textViewTitle.text=item.title
            textViewBody.text=item.body
            textViewSum.text=item.endText
        }
    }

    inner class HeadViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {
        private val textViewTitle: TextView

        init {
            textViewTitle = itemView.findViewById(R.id.textView)
        }

        fun bind(item:String){
            textViewTitle.text=item
        }

    }
}
