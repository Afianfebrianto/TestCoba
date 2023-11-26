package com.club.basketball

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
    val name: String,
    val description: String,
    val faounded: String,
    val location: String,
    val photo: Int
) : Parcelable

@Parcelize
data class Club2(
    val name: String,
    val description: String,
    val faounded: String,
    val location: String,
    val photo: Int
) : Parcelable
