package com.example.qltv_fbu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class trangchu extends AppCompatActivity {
    Button btnMsTC,btnTsTC,btnDtTC,btnPsTC,btnDxTC;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trangchu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnMsTC=findViewById(R.id.btnMsTC);
        btnTsTC=findViewById(R.id.btnTsTC);
        btnDtTC=findViewById(R.id.btnDtTC);
        btnPsTC=findViewById(R.id.btnPsTC);
        btnDxTC=findViewById(R.id.btnDxTC);
        btnMsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(trangchu.this, TrangChuQlyMuonSach.class);
                startActivity(myintent);
            }
        });
        btnTsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(trangchu.this,TrangChuQlyTraSach.class);
                startActivity(myintent);
            }
        });
        btnDtTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(trangchu.this, docthuc.class);
                startActivity(myintent);
            }
        });
        btnPsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(trangchu.this, phatTraSachMuon.class);
                startActivity(myintent);
            }
        });
        btnDxTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(trangchu.this, MainActivity.class);
                startActivity(myintent);
            }
        });
    }
}