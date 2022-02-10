package com.example.scheduleapp

import android.app.Activity
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
            //入力された値を持ってTaskをインスタンス化
            val taskEdit = Task(title = binding.editTitleText.text.toString(),
                                deadline = binding.editDeadlineText.text.toString())
            //入力された値を元のアクティビティに返す
            intent.putExtra("result", taskEdit)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}