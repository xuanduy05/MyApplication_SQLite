package com.yellowcode.roomsample.model

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "ten") val ten: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "contact") val contact: String,
    @ColumnInfo(name = "address") val address: String
)