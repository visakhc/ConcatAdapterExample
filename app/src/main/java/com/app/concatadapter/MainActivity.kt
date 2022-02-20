package com.app.concatadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.concatadapter.databinding.ActivityMainBinding
import com.app.concatadapter.adapter.CalendarAdapter
import com.app.concatadapter.adapter.EventsAdapter
import com.app.concatadapter.model.CalenderModel
import com.app.concatadapter.model.EventsModel
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import java.util.*


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var mCalenderModel = mutableListOf(
        CalenderModel("date1", "day1"),
        CalenderModel("date2", "day2"),
        CalenderModel("date3", "day3"),
        CalenderModel("date4", "day4"),
        CalenderModel("date5", "day5"),
        CalenderModel("date6", "day6"),
        CalenderModel("date7", "day7"),
        CalenderModel("date8", "day8"),
        CalenderModel("date9", "day9"),
        CalenderModel("date0", "day0"),
    )
    private var mEventsModel = mutableListOf(
        EventsModel("Title 1", "Description 1"),
        EventsModel("Title 2", "Description 2"),
        EventsModel("Title 3", "Description 3"),
        EventsModel("Title 4", "Description 4"),
        EventsModel("Title 5", "Description 5"),
        EventsModel("Title 6", "Description 6")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.inclLayout?.tvTitle?.text = "Concat Adapter"

        init()
    }

    private fun init() {
        setRecyclerview()
        handleEvents()
    }


    private fun handleEvents() {

    }


    private fun setRecyclerview() {
        val flexboxLayoutManager = FlexboxLayoutManager(this@MainActivity)
        flexboxLayoutManager.apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.SPACE_EVENLY
        }
        val calendarAdapter = CalendarAdapter(mCalenderModel)
        val eventsModel = EventsAdapter(mEventsModel)


        val concatAdapter = ConcatAdapter(calendarAdapter,eventsModel)


val linearLayoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = flexboxLayoutManager
            adapter = concatAdapter
        }


    }

}
