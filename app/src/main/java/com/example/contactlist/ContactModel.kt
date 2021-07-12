package com.example.contactlist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel(
    val contactName: String,
    val primaryNumber: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)