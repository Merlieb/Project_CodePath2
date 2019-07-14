package com.example.project_codepath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.project_codepath.MainActivity.editText;

public class Main2Activity extends AppCompatActivity {
EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final String item = getIntent().getStringExtra("item");
                getSupportActionBar().setTitle("Edit Item");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d("Item passing", item);
        final EditText ediText =  (EditText) findViewById(R.id.editText2);
        ediText.setText(item);
        final int position = getIntent().getIntExtra(item, 0);


        Button button = (Button) findViewById(R.id.savebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra(editText, ediText.getText().toString());
                intent.putExtra(item, position);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
