package com.app.concatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.concatadapter.databinding.ItemEventsBinding
import com.app.concatadapter.model.EventsModel

class EventsAdapter(private val itemList: List<EventsModel>) :
    RecyclerView.Adapter<EventsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemEventsBinding)
        : RecyclerView.ViewHolder(binding.root)  {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemEventsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(itemList[position]) {
            holder.binding.tvTitle.text = title
            holder.binding.tvDesc.text = description
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}