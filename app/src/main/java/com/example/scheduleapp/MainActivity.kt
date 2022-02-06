package com.example.scheduleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private var taskList: MutableList<Task> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ScheduleEditActivityからTaskモデルを受け取り
        val newTask = intent.getParcelableExtra<Task>("EDIT_DATE")
        //nullチェック
        if (newTask != null) {
            //TaskモデルをList<Task>にしインスタンス化
            taskList.add(newTask)
            recyclerView = findViewById(R.id.recycler_list)
            recyclerView.adapter = ScheduleAdapter(taskList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        binding.nextEditButton.setOnClickListener {
            intent = Intent(this, ScheduleEditActivity::class.java)
            startActivity(intent)
        }
    }
}