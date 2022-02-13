package com.example.scheduleapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//ScheduleHolderと紐付けるクラス。コンストラクタにListをもらい1行分のレイアウトと紐付ける。
class ScheduleAdapter(var list: MutableList<Task>) : RecyclerView.Adapter<ScheduleHolder>() {
    //1行分のレイアウトを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_line, parent, false)
        Log.println(Log.DEBUG, itemView.toString(), "DEBUG")
        return ScheduleHolder(itemView)
    }

    //onBindViewHolderはScheduleHolderを結ぶ。holderは1行分、positionは何行目。
    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        holder.titleList.text = list[position].title
        holder.deadlineList.text = list[position].deadline
        Log.println(Log.DEBUG, list.toString(), "DEBUG")
    }

    //getItemCountは行の数をカウント
    override fun getItemCount(): Int{
        val size = list.size
        Log.println(Log.DEBUG, size.toString(), "DEBUG")
        return size
    }
}
