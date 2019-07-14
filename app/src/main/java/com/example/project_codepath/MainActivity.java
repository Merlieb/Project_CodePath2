package com.example.project_codepath;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static String editText = "editText";
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            arrayList.set(data.getIntExtra("position", 0), data.getStringExtra("text"));
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        final ListView listView =(ListView) findViewById(R.id.listView);

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Long click");
                Log.d("Position", String.valueOf(position));
                String selectValue = (String) arrayAdapter.getItem(position);
                Log.d("The value sel", String.valueOf(selectValue));

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("item", selectValue.toString() );

                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this line adds the data of your EditText and puts in your array
                arrayList.add(editText.getText().toString());
                // next thing you have to do is check if your adapter has changed
                arrayAdapter.notifyDataSetChanged();
            }
        });



    }


}
