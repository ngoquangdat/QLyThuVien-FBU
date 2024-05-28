package com.example.qltv_fbu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.qltv_fbu.SQLmanagement.SQLmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;

public class XemThongTinDocThuc extends AppCompatActivity {
    //khai báo các biến giao diện
    TextView timKiemDT,tenDocXemDT,sdtXemDT,maSachXemDT,tenSachXemDT,hanTraXemDT,ghiChuXemDT;//khai báo các biến textview
    Button  backXemDT;//khai báo các biến button
    ImageButton btnTimKemDT;//khai báo các biến imgButton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_thong_tin_doc_thuc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id
        timKiemDT = findViewById(R.id.timKiemDT);//ánh xạ id ở ô tìm kiếm tương ứng với biến khai báo
        tenDocXemDT = findViewById(R.id.tenDocXemDT);//dánh xạ id ở ô tên độc giả tương ứng với biến khai báo
        sdtXemDT = findViewById(R.id.sdtXemDT);//ánh xạ id ở ô số điện thoại tương ứng với biến khai báo
        maSachXemDT = findViewById(R.id.maSachXemDT);//ánh xạ id ở ô mã sach tương ứng với biến khai báo
        tenSachXemDT = findViewById(R.id.tenSachXemDT);//ánh xạ id ở ô tên sách tương ứng với biến khai báo
        hanTraXemDT = findViewById(R.id.hanTraXemDT);//ánh xạ id ở ô hạn trả tương ứng với biến khai báo
        ghiChuXemDT = findViewById(R.id.ghiChuXemDT);//ánh xạ id ở ô ghi chú tương ứng với biến khai báo
        backXemDT = findViewById(R.id.backXemDT);//ánh xạ id ở button quay lại tương ứng với biến khai báo
        btnTimKemDT = findViewById(R.id.btnTimKemDT);//ánh xạ id ở imgButton tìm kiếm tương ứng với biến khai báo

        //hàm xử lí sự kiện khi click vào ô imgButton tìm kiếm
        btnTimKemDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();//kết nối csdl
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlXem="select * from ThongTinDocThuc where TenDocGia = '"+timKiemDT.getText().toString()+"'";
                        Statement st=connection.createStatement();//taọ đô tượng Statement
                        ResultSet rs=st.executeQuery(sqlXem);//thực thi câu lệnh sql
                        while (rs.next()){
                            tenDocXemDT.setText(rs.getString(1));
                            sdtXemDT.setText(rs.getString(2));
                            maSachXemDT.setText(rs.getString(3));
                            tenSachXemDT.setText(rs.getString(4));
                            hanTraXemDT.setText(rs.getString(5));
                            ghiChuXemDT.setText(rs.getString(6));
                        }
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        //hàm xử lí sự kiện khi click vào ô Button quay lại
        backXemDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(XemThongTinDocThuc.this, docthuc.class);//khai báo 1 Intent cho phép chuyển từ giao diện XemThongTinDocThuc tới giao diện docthuc
                startActivity(myintent);//thực thi câu lệnh
            }
        });
    }
}