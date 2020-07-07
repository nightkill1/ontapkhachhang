package com.example.ontapkhachhang;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class docpretion extends  AppCompatActivity implements View.OnClickListener {
    TextView txtthongtin;
    Button btnExit;

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(docpretion.this,MainActivity.class);
        intent.putExtra("ThongTin","a");
        startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnExit = (Button) findViewById(R.id.btnExit);
        setContentView(R.layout.activity_dangki);
        txtthongtin = (TextView) findViewById(R.id.tvThongTin);
        Intent intent = getIntent();
        String content = intent.getStringExtra("ThongTin");
        txtthongtin.setText(content);
        btnExit.setOnClickListener(this);

    }
}
