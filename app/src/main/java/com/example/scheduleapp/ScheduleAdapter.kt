package com.example.scheduleapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//ScheduleHolderと紐付けるクラス。コンストラクタにListをもらい1行分のレイアウトと紐付ける。
class ScheduleAdapter(val list: List<String>) : RecyclerView.Adapter<ScheduleHolder>() {
    //1行分のレイアウトを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_line, parent, false)
        return ScheduleHolder(itemView)
    }

    //onBindViewHolderはScheduleHolderを結ぶ。holderは1行分、positionは何行目。
    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        holder.scheduleList.text = list[position]
    }

    //getItemCount行の数をカウント
    override fun getItemCount(): Int = list.size
}