package com.ismin.android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_BOOKS = "ARG_BOOKS"

class BookListFragment(c: AppCompatActivity) : Fragment() {
    private lateinit var books: ArrayList<Book>
    private lateinit var rcvBooks: RecyclerView
    public var con:AppCompatActivity=c//gu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            books = it.getSerializable(ARG_BOOKS) as ArrayList<Book>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_book_list, container, false)
        this.rcvBooks = rootView.findViewById(R.id.f_book_list_rcv_books)
        this.rcvBooks.adapter = BookAdapter(books,con)
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvBooks.layoutManager = linearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvBooks.addItemDecoration(dividerItemDecoration)

        return rootView;
    }

    companion object {
        @JvmStatic
        fun newInstance(books: List<Book>,c: AppCompatActivity) =
            BookListFragment(c).apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_BOOKS, ArrayList(books))
                }
            }
    }
}