package com.example.recyclerview.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.HistoryBodyData
import com.example.recyclerview.model.HistoryStatuses
import com.example.recyclerview.R

val TAG:String ="TestLiveData"
class MainFragment : Fragment(), View.OnClickListener,View.OnLongClickListener {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView:RecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getHistory().observe(viewLifecycleOwner, {
            Log.d(TAG, "getHistory_observed: $it")
            val adapter: MyAdapter = MyAdapter(it,this@MainFragment,this@MainFragment)
            recyclerView.adapter = adapter

        })

        viewModel.fetchHistory()
    }



    override fun onClick(v: View?) {
        v?.let {
            when(it.id){
                R.id.button ->{
                    Log.d(TAG, "onClick: ")
                    viewModel.addNewItem( HistoryBodyData(
                        R.mipmap.ic_launcher,
                        HistoryStatuses.SUCCES,"Babilon","98 616 44 36","100 TJS"))
                }
                R.id.itemList->{
                    val data: HistoryBodyData = it.tag as HistoryBodyData
                    val transaction:FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.container, DetailFragment.newInstance(data))
                    transaction.commit()
                }

                else -> {}
            }
        }
    }

    override fun onLongClick(itemView: View?): Boolean {
        itemView?.let {
            val data: HistoryBodyData = it.tag as HistoryBodyData
            context?.let {
                Toast.makeText(it,data.title+" "+data.body, Toast.LENGTH_SHORT).show()
            }
        }
      return false
    }
}