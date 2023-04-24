package com.noteapp.notebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdaptor extends RecyclerView.Adapter<NoteAdaptor.NotesViewHolder>{

    ArrayList<Note> notes;
    public NoteAdaptor(ArrayList<Note>notes){
        this.notes = notes;
    }


    @NonNull
    @Override
    public NoteAdaptor.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        return  new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdaptor.NotesViewHolder holder, int position) {

        holder.bindView(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class  NotesViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView category;
        TextView description;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.category);
        }

        public void bindView(Note note){
            title.setText(note.getTitle());
            description.setText(note.getDescription());
            category.setText(note.getCategory());
        }
    }
}