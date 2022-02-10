package com.example.scheduleapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
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

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Activityから受け取った結果を処理する
            if(result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                //ScheduleEditActivityからTaskモデルを受け取り
                val task = intent?.getParcelableExtra<Task>("result") ?: return@registerForActivityResult
                //recyclerViewの処理
                taskList.add(task)
                recyclerView = findViewById(R.id.recycler_list)
                recyclerView.adapter = ScheduleAdapter(taskList)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }

        binding.nextEditButton.setOnClickListener {
            val intent = Intent(this, ScheduleEditActivity::class.java)
            launcher.launch(intent)
        }
    }
}