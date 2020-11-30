package com.ismin.android

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BookAdapter(private val books: ArrayList<Book>,private val c: AppCompatActivity) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookViewHolder(row)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val (title, author, date,url_post,url_wiki) = this.books[position]
        holder.txvTitle.text = title
        holder.txvAuthor.text = author
        holder.txvDate.text = date
        if(url_post!="") {//gu
            Picasso.with(c).load(url_post).into(holder.txvImage)//I use the library Picasso to load the image!
        }
        holder.txvDelete.tag=title //gu

    }


    override fun getItemCount(): Int {
        return this.books.size
    }

    fun updateItem(booksToDisplay: List<Book>) {
        books.clear();
        books.addAll(booksToDisplay)
        notifyDataSetChanged();
    }
}
