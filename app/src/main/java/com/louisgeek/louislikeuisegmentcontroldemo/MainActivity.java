package com.louisgeek.louislikeuisegmentcontroldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.louisgeek.likeuisegmentlib.SegmentedControlView;

public class MainActivity extends AppCompatActivity {

    int i=1;
    SegmentedControlView idscv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button idbtn = (Button) findViewById(R.id.id_btn);
        Button idbtnget = (Button) findViewById(R.id.id_btn_get);
        idscv= (SegmentedControlView) findViewById(R.id.id_scv);

        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idscv.setSelectIndex(i%2);
                i++;
            }
        });

        idbtnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "index:"+idscv.getSelectIndex()+idscv.getSelectName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
