package com.example.austin.augustinefayomifinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    // Array of strings...
    String[] cityArray = {"Toronto","Hawaii","Sydney","Paris"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, cityArray);

        ListView lv = (ListView) findViewById(R.id.city_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, GoogleMap.class);
                String message = "abc";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}
