package com.example.qltv_fbu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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

public class XemThongTinPhat extends AppCompatActivity {
    EditText timKiem,tenDocGiaXemPS,sdtXemPS,maSachXemPS,tenSachXemPS,hanTraXemPS,ngayTraXemPS,tienPhatXemPS;
    Button btnBackXemPS;
    ImageButton btnTimKiemPS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_thong_tin_phat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        timKiem=findViewById(R.id.timKiem);
        tenDocGiaXemPS=findViewById(R.id.tenDocGiaXemPS);
        sdtXemPS=findViewById(R.id.sdtXemPS);
        maSachXemPS=findViewById(R.id.maSachXemPS);
        tenSachXemPS=findViewById(R.id.tenSachXemPS);
        hanTraXemPS=findViewById(R.id.hanTraXemPS);
        ngayTraXemPS=findViewById(R.id.ngayTraXemPS);
        tienPhatXemPS=findViewById(R.id.tienPhatXemPS);
        btnBackXemPS=findViewById(R.id.btnBackXemPS);
        btnTimKiemPS=findViewById(R.id.btnTimKiemPS);
        btnTimKiemPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlXem="select * from ThongTinPhat where TenDocGia = '"+timKiem.getText().toString()+"'";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlXem);
                        while (rs.next()){
                            tenDocGiaXemPS.setText(rs.getString(1));
                            sdtXemPS.setText(rs.getString(2));
                            maSachXemPS.setText(rs.getString(3));
                            tenSachXemPS.setText(rs.getString(4));
                            hanTraXemPS.setText(rs.getString(5));
                            ngayTraXemPS.setText(rs.getString(6));
                            tienPhatXemPS.setText(rs.getString(7));
                        }
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        btnBackXemPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(XemThongTinPhat.this, phatTraSachMuon.class);
                startActivity(myintent);
            }
        });
    }
}