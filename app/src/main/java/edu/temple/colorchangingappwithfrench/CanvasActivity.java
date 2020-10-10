package edu.temple.colorchangingappwithfrench;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    TextView view;
    String colourStr;
    int colourInt;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);


        setTitle("Canvas Activity");

        Intent intent = getIntent();

        colourStr = intent.getStringExtra("color String");
        colourInt = intent.getIntExtra("color Integer", 0);

        layout = findViewById(R.id.conslayout);
        view = findViewById(R.id.textView2);

        view.setText(colourStr);
        view.setTextSize(30);
        view.setTextColor(Color.BLACK);
        view.setBackgroundColor(Color.TRANSPARENT);
        layout.setBackgroundColor(colourInt);
    }
}