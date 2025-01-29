package com.example.assessment2
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(mainActivity: MainActivity) : RecyclerView.Adapter<RecycleViewHolder>() {

    private var mClickListener: ItemClickListener = mainActivity

    private var newsModelList = listOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        Log.e("Adapter viewType", viewType.toString())
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recyclerview_row, parent, false)
        return RecycleViewHolder(view, mClickListener)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        Log.e("Adapter position", position.toString())

        val newsModel = newsModelList[position]
        holder.textViewSource.text = newsModel.source
        holder.textViewTitle.text = newsModel.title
        holder.textViewDescription.text = newsModel.description
    }

    override fun getItemCount(): Int {
        return newsModelList.size
    }

    fun updateData(currencyModel: List<NewsModel>) {
        newsModelList = currencyModel
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}