package com.app.concatadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.concatadapter.R
import com.app.concatadapter.model.CalenderModel


class CalendarAdapter(
    private val itemList: List<CalenderModel>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_calender, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var mName: TextView
        var mNum: TextView

        init {
            mName = itemView.findViewById(R.id.tv_date)
            mNum = itemView.findViewById(R.id.tv_day)
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(itemList[position]) {
            holder.mName.text = date
            holder.mNum.text = day
        }
    }
}
