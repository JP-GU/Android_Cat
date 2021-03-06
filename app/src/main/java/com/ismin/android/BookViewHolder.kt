package com.ismin.android

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txvTitle = itemView.findViewById<TextView>(R.id.r_book_txv_title)
    var txvAuthor: TextView = itemView.findViewById(R.id.r_book_txv_author)
    var txvDate: TextView = itemView.findViewById(R.id.r_book_txv_date)
    var txvImage: ImageView = itemView.findViewById(R.id.r_book_imv_logo)//gu
    var txvDelete:Button =itemView.findViewById(R.id.r_book_txv_delete)//gu
}