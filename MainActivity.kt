package com.example.bookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Preparing the adapter
        val adapter = BookAdapter(this, arrayList)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        //Getting the data
        val fileInString: String =
            applicationContext.assets.open("data.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val lists : List<DataBook> = gson.fromJson(fileInString, object  : TypeToken<List<DataBook>> (){}.type)

        // Adding to the arraylist
        arrayList.clear()
        for (item in lists){
            arrayList.add(item)
            adapter.notifyDataSetChanged()
        }
    }


    companion object {
        var arrayList = ArrayList<DataBook>()
        var current_index = 0
    }
}