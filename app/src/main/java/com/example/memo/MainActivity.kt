package com.example.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MemoAdapter.IMemoAdapter {

    lateinit var viewModel: MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MemoAdapter(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MemoViewModel::class.java)   //attach viewmodel to activity


        viewModel.allMemos.observe(this, Observer{list->

            list?.let{
                adapter.updateList(it)
            }

        })


    }

    override fun onItemClicked(memo: Memo) {
        viewModel.deleteMemo(memo)
        Toast.makeText(this,"${memo.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun submitData(view: android.view.View) {

        val memoText = input.text.toString()
        if(memoText.isNotEmpty()){
             viewModel.insertMemo(Memo(memoText))
            Toast.makeText(this,"$memoText Inserted",Toast.LENGTH_LONG).show()
        }
    }
}