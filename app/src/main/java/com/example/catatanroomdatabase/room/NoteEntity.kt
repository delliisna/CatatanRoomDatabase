package com.example.catatanroomdatabase.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val title : String,
    val note : String
        )