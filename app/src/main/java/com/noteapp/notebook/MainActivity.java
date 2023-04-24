package com.noteapp.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton addButton;
    ArrayList<Note> notes;


    ActivityResultLauncher<Intent> resultIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode()== RESULT_OK){
                Intent data =result.getData();
                String title = data.getExtras().getString("note_title");
                String description = data.getExtras().getString("note_description");
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.btnAddNote);
        notes  = new ArrayList<>();
        notes.add(new Note("Note1","Descq 1","catageroy1"));
        notes.add(new Note("Note2","Descq 2","catageroy2"));
        notes.add(new Note("Note3","Descq 3","catageroy3"));
        notes.add(new Note("Note4","Descq 4","catageroy4"));
        notes.add(new Note("Note5","Descq 5","catageroy5"));

        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new NoteAdaptor(notes));
//        rv.setAdapter(new NoteAdaptor(notes));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,NoteActivity.class);
                resultIntent.launch(intent);
            }
        });
    }
}