package com.example.austin.augustinefayomifinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    // Array of strings...
    String[] cityArray = {"Toronto","Hawaii","Sydney","Paris"};
    ListView lv;
  String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, cityArray);

        lv = (ListView) findViewById(R.id.city_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String selectedFromList =(String) (lv.getItemAtPosition(position));
             
                  message = selectedFromList;
               
            }
        });

        Button btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NotificationActivity.class);
                i.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);
            }
        });
        //to call map
        Button btn2 = (Button) findViewById(R.id.button1);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                i.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);

            }
        });
    }
}
