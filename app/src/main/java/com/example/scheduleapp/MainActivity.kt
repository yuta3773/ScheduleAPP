package com.example.scheduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textList = listOf(
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "aaa",
            "bbb",
            "ccc"
        )

        recyclerView = findViewById(R.id.recycler_list)
        recyclerView.adapter = ScheduleAdapter(textList)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}