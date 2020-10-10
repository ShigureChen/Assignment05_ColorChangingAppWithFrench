package edu.temple.colorchangingappwithfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] colourStr = new String[9];

        colourStr[0] = "Red";
        colourStr[1] = "Yellow";
        colourStr[2] = "Cyan";
        colourStr[3] = "Light Gray";
        colourStr[4] = "Magenta";
        colourStr[5] = "Silver";
        colourStr[6] = "Blue";
        colourStr[7] = "Green";
        colourStr[8] = "Dark Gray";

        final int[] colourInt = new int[9];

        colourInt[0] = Color.RED;
        colourInt[1] = Color.YELLOW;
        colourInt[2] = Color.CYAN;
        colourInt[3] = Color.GRAY;
        colourInt[4] = Color.MAGENTA;
        colourInt[5] = Color.LTGRAY;
        colourInt[6] = Color.BLUE;
        colourInt[7] = Color.GREEN;
        colourInt[8] = Color.DKGRAY;

        setTitle("Palette Activity");

        TextView textView;
        textView = findViewById(R.id.textView);
        textView.setTextSize(22);
        textView.setText("Choose a color");

        gridView = findViewById(R.id.gridView);
        final GridAdapter adapter = new GridAdapter(this, colourStr, colourInt);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
                intent.putExtra("color String", colourStr[i]);
                intent.putExtra("color Integer", colourInt[i]);
                startActivity(intent);
            }
        });


    }
}