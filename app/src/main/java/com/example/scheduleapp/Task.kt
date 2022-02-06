package com.example.scheduleapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(var title: String = "", var deadline: String ="") : Parcelable