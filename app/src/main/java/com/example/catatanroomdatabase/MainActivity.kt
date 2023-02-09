package com.example.catatanroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catatanroomdatabase.room.NoteDB
import com.example.catatanroomdatabase.room.NoteEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.catatanroomdatabase.AdapterNote as AdapterNote

class MainActivity : AppCompatActivity() {

    val db by lazy { NoteDB(this) }
    lateinit var adapterNote : AdapterNote

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNotes()
            Log.d("MainActivity","dbResponse:$notes")
            withContext(Dispatchers.Main){
                adapterNote.setData(notes)
        }
    }
    }
    fun pidahkehalcatatan(view: View){
        val ganti = Intent (this,EditActivity::class.java)
        startActivity(ganti)
    }

    private fun  setupRecyclerView(){
        adapterNote= AdapterNote(arrayListOf(),object : AdapterNote.OnAdapterListener{
            override fun OnClick(noteEntity: NoteEntity) {
           // Toast.makeText(applicationContext,noteEntity.title,Toast.LENGTH_SHORT).show()

            }

        })
        list_note.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterNote
        }
    }
}