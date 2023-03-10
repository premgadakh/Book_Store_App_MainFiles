package com.example.bookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bookapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        val book = MainActivity.arrayList[MainActivity.current_index]

        binding.tvTitle.text = book.title
        binding.tvIsbn.text = book.isbn
        binding.tvCount.text = book.pageCount.toString() + " "
        if (book.publishedDate != null) binding.tvDate!!.text = book.publishedDate!!["\$date"].toString().replace("\"", "") + "" else binding.tvDate!!.text = "NA"
        binding.tvLong.text = book.longDescription
        binding.tvShort.text = book.shortDescription
        binding.tvStatus.text = book.status

        val auths = StringBuilder("")
        for (s in book.authors!!) {
            if (auths.toString() == "") {
                auths.append(s)
            } else {
                auths.append(", ").append(s)
            }
        }
        binding.tvAuthor.text =auths
        val cats = StringBuilder("")
        for (s in book.categories!!) {
            if (cats.toString() == "") {
                cats.append(s)
            } else {
                cats.append(", ").append(s)
            }
        }
        binding.tvCategory.text = cats
    }
}