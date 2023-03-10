package com.example.bookapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.ListBookBinding


class BookAdapter(private val context: Context, list: ArrayList<DataBook>) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private var list = ArrayList<DataBook>()

    init {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvName.text = list[position].title
                val s = StringBuilder()
                for (s1 in list[position].authors!!) {
                    if (s.toString() == "") {
                        s.append(s1)
                    } else {
                        s.append(", ").append(s1)
                    }
                }
                binding.tvAuth.text = s
                Glide.with(context)
                    .load(list[position].thumbnailUrl)
                    .into(binding.imageView)
                binding.listLayout.setOnClickListener {
                    MainActivity.current_index = position
                    context.startActivity(Intent(context, MainActivity2::class.java))
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding : ListBookBinding) : RecyclerView.ViewHolder(binding.root)
}

