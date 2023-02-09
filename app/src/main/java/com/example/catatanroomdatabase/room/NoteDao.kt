package com.example.catatanroomdatabase.room

import android.provider.ContactsContract
import androidx.room.*


@Dao
interface NoteDao {
     @Insert
       fun addNote (noteEntity: NoteEntity)

    @Update
      fun updateNote (noteEntity: NoteEntity)

    @Delete
      fun deletNote (noteEntity: NoteEntity)

     @Query("SELECT * from noteEntity" )
     fun getNotes():List<NoteEntity>
}