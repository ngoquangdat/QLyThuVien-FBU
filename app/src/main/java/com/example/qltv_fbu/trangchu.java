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

    //khai báo các biến giao diện
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

        //ánh xạ id
        btnMsTC=findViewById(R.id.btnMsTC);
        btnTsTC=findViewById(R.id.btnTsTC);
        btnDtTC=findViewById(R.id.btnDtTC);
        btnPsTC=findViewById(R.id.btnPsTC);
        btnDxTC=findViewById(R.id.btnDxTC);

        //hàm xử lý sự kiện khi click vào nút quản lý mượn sách
        btnMsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện trang chủ đến giao diện quản lý mượn sách
                Intent myintent = new Intent(trangchu.this, TrangChuQlyMuonSach.class);
                startActivity(myintent);
            }
        });

        //hàm xử lý sự kiện khi click vào nút quản lý trả sách
        btnTsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện trang chủ đến giao diện quản lý trả sách
                Intent myintent = new Intent(trangchu.this,TrangChuQlyTraSach.class);
                startActivity(myintent);
            }
        });

        //hàm xử lý sự kiện khi click vào nút đốc thúc hạn trả
        btnDtTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện trang chủ đến giao diện đốc thúc hạn trả
                Intent myintent = new Intent(trangchu.this, docthuc.class);
                startActivity(myintent);
            }
        });
        // hàm xử lý sự kiện khi click vào nút phạt sách trả muộn
        btnPsTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện trang chủ đến giao diện phạt sách trả muộn
                Intent myintent = new Intent(trangchu.this, phatTraSachMuon.class);
                startActivity(myintent);
            }
        });

        // hàm xử lý sự kiện khi click vào nút đăng xuất
        btnDxTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện trang chủ đến giao diện đăng nhâp
                Intent myintent = new Intent(trangchu.this, MainActivity.class);
                startActivity(myintent);
            }
        });
    }
}