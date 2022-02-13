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
    private val taskList: MutableList<Task> = mutableListOf()
    private var adapter: ScheduleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recyclerViewの処理
        val recyclerView: RecyclerView = binding.recyclerList
        adapter = ScheduleAdapter(taskList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                // ScheduleEditActivityから受け取った結果を処理する
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    //ScheduleEditActivityからTaskモデルを受け取り
                    val task = intent?.getParcelableExtra<Task>("result")
                        ?: return@registerForActivityResult

                    //RecyclerViewの更新
                    adapter?.list?.add(task)
                    adapter?.notifyItemChanged(taskList.lastIndex)
                }
            }

        binding.nextEditButton.setOnClickListener {
            val intent = Intent(this, ScheduleEditActivity::class.java)
            //registerForActivityResult。結果を戻す指示
            launcher.launch(intent)
        }
    }
}