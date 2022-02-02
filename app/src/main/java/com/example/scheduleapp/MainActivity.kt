package com.example.scheduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    private var title: List<String> = listOf("title1","title2","title3","title4","title5")
    private var deadline: List<String> = listOf("2022/2/21","2022/2/22","2022/2/23","2022/2/24","2022/2/25")
    private val task = Task(title = title, deadline = deadline)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recycler_list)
        recyclerView.adapter = ScheduleAdapter(task)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}