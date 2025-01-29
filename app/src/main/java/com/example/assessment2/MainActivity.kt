package com.example.assessment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity(), RecyclerViewAdapter.ItemClickListener {

    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val button = findViewById<Button>(R.id.Subbtn)
        mRecyclerView = findViewById(R.id.recyclerview)
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        button.setOnClickListener {
            fetchNewsDetails()
        }

        viewModel.newsDetails.observe(this) {
            mAdapter.updateData(it)
        }
    }

    private fun fetchNewsDetails() {
        viewModel.getNewsDetails(accessKey = Constants.API_KEY)
    }

    override fun onItemClick(view: View?, position: Int) {

    }
}