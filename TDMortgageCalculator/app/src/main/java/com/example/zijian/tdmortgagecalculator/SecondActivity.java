package com.example.zijian.tdmortgagecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
	//get the data from main window to show
        String s = getIntent().getExtras().getString("events");
        TextView textView = (TextView)findViewById(R.id.textViewSA);
        textView.setText(s);
    }

    public void onClick(View view) {
	// go back to the mainActivity
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
