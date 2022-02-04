package com.example.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MemoAdapter (val context: Context, val listener: IMemoAdapter): RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

      val allMemos = ArrayList<Memo>()  //for getting data

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
       val viewHolder =  MemoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_memo,parent,false))
        viewHolder.deleteButton.setOnClickListener{
           listener.onItemClicked(allMemos[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
           val currentMemo = allMemos[position]
           holder.textView.text = currentMemo.text
    }

    override fun getItemCount(): Int {


        return allMemos.size
    }

    fun updateList(newList:List<Memo>) {
        allMemos.clear()
        allMemos.addAll(newList)

        notifyDataSetChanged()
    }

    interface IMemoAdapter {
        fun onItemClicked(memo: Memo)
    }

}