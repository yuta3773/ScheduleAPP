package com.example.scheduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scheduleapp.databinding.ActivityScheduleEditBinding

class ScheduleEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}