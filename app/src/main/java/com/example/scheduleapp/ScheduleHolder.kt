package com.example.scheduleapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//一行分のレイアウトを保持しておくクラス
class ScheduleHolder(item: View) : RecyclerView.ViewHolder(item) {
    //scheduleListはスケジュール
    val titleList: TextView = item.findViewById(R.id.title_text)
    val deadlineList: TextView = item.findViewById(R.id.deadline_text)
}