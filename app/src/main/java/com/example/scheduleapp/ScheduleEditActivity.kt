package com.example.scheduleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scheduleapp.databinding.ActivityScheduleEditBinding

class ScheduleEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBottom.setOnClickListener {
            //Taskをインスタンス化
            val taskEdit = Task(title = binding.editTitleText.text.toString(),
                                deadline = binding.editDeadlineText.text.toString())

            //MainActivityへの遷移
            intent = Intent(this, MainActivity::class.java)
            //TaskモデルをMainActivityへ渡す
            intent.putExtra("EDIT_DATE", taskEdit)
            startActivity(intent)
        }
    }
}