package com.example.week09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = (ImageView) findViewById(R.id.vnexpress);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("trang", 1);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.thanhnien);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("trang", 2);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.phapluat);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("trang", 3);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}