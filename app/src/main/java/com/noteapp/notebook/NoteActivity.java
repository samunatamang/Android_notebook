package com.noteapp.notebook;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    EditText etTitle,etDescription;
    Spinner category;
    Button addNotes;
    String noteCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        category = findViewById(R.id.spinnerCategory);
        etTitle = findViewById(R.id.et_note_title);
        etDescription = findViewById(R.id.et_note_description);
        addNotes = findViewById(R.id.addNote);

        String[] items = {"Normal","urgent","quick"};
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,items);
        category.setAdapter(spinnerAdapter);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                noteCategory = category.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("note_title",title);
                setResult(RESULT_OK,intent);
                finish();
                Toast.makeText(NoteActivity.this, "Title:"+title+",Description:"+description+" Note Category:"+noteCategory, Toast.LENGTH_SHORT).show();
            }
        });


    }
}