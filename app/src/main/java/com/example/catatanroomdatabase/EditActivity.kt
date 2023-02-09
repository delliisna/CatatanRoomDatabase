package com.example.catatanroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.catatanroomdatabase.room.NoteDB
import com.example.catatanroomdatabase.room.NoteEntity
import kotlinx.android.synthetic.main.activity_edit.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    val db by lazy { NoteDB(this) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupListener()
    }
   fun  setupListener() {
       button_save.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
               db.noteDao().addNote(
                   NoteEntity(0,edit_title.text.toString(),
                       edit_note.text.toString())
               )
               finish()
           }
       }
   }
   }
