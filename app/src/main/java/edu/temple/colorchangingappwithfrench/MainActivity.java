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

        colourStr[0] = getString(R.string.red);
        colourStr[1] = getString(R.string.yellow);
        colourStr[2] = getString(R.string.cyan);
        colourStr[3] = getString(R.string.lightGray);
        colourStr[4] = getString(R.string.magenta);
        colourStr[5] = getString(R.string.silver);
        colourStr[6] = getString(R.string.blue);
        colourStr[7] = getString(R.string.green);
        colourStr[8] = getString(R.string.darkGray);

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

        setTitle(getString(R.string.title));

        TextView textView;
        textView = findViewById(R.id.textView);
        textView.setTextSize(30);
        textView.setText(getString(R.string.app_message));
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