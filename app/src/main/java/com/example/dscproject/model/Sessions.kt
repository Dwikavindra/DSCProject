package com.example.dscproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sessions (
    val sessions:String,
    val time:String,
    val idRuangan:List<String>,
    val namadokter :List<String>,
): Parcelable//Parcelable digunakan biar kamu bisa ngirim data dari fragment 1 ke fragment 2/