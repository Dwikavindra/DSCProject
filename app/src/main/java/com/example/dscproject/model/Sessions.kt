package com.example.dscproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sessions (
    val sessions:String,
    val time:String,
    val idRuangan:List<String>,
    val namadokter :List<String>,
): Parcelable