package com.example.catatanroomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanroomdatabase.room.NoteEntity
import kotlinx.android.synthetic.main.adapter_note.view.*


class AdapterNote(private val notes : ArrayList<NoteEntity>, private val listener:OnAdapterListener)
    : RecyclerView.Adapter<AdapterNote.noteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        return  noteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_note,parent,false)
        )
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        val catatan = notes [position]
        holder.view.title.text = catatan.title
        holder.view.title.setOnClickListener{
            listener.OnClick(catatan)
        }
    }

    override fun getItemCount()= notes.size


    class noteViewHolder( val view: View): RecyclerView.ViewHolder(view)

    fun setData(list: List<NoteEntity>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }
interface  OnAdapterListener{
    fun OnClick(noteEntity: NoteEntity)
}
}