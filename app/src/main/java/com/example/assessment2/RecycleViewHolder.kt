package com.example.assessment2
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewHolder(itemView: View, mClickListener: RecyclerViewAdapter.ItemClickListener) : RecyclerView.ViewHolder(itemView) {
    var textViewSource: TextView = itemView.findViewById<TextView>(R.id.textViewSource)
    var textViewTitle: TextView = itemView.findViewById<TextView>(R.id.textViewTitle)
    var textViewDescription: TextView = itemView.findViewById<TextView>(R.id.textViewDescription)

    init {
        itemView.setOnClickListener { view ->
            mClickListener.onItemClick(view, adapterPosition)
        }
    }
}