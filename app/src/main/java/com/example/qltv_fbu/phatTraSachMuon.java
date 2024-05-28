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

public class phatTraSachMuon extends AppCompatActivity {
    ImageButton backPS;
    TextView tenDGPS,sdtPS,maSachPS,tenSachPS,hanTraPS,ngayTraPS,tienPhatPS;
    Button btnThemPS,btnSuaPS,btnXoaPS,btnXemPS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phat_tra_sach_muon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backPS=findViewById(R.id.backPS);
        tenDGPS=findViewById(R.id.tenDGPS);
        sdtPS=findViewById(R.id.sdtPS);
        maSachPS=findViewById(R.id.maSachPS);
        tenSachPS=findViewById(R.id.tenSachPS);
        hanTraPS=findViewById(R.id.hanTraPS);
        ngayTraPS=findViewById(R.id.ngayTraPS);
        tienPhatPS=findViewById(R.id.tienPhatPS);
        btnThemPS=findViewById(R.id.btnThemPS);
        btnSuaPS=findViewById(R.id.btnSuaPS);
        btnXoaPS=findViewById(R.id.btnXoaPS);
        btnXemPS=findViewById(R.id.btnXemPS);
        backPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(phatTraSachMuon.this, trangchu.class);
                startActivity(myintent);
            }
        });
        btnThemPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlThem="insert into ThongTinPhat values('"+tenDGPS.getText().toString()+"','"+sdtPS.getText().toString()+
                                "','"+maSachPS.getText().toString()+"','"+tenSachPS.getText().toString()+"','"+hanTraPS.getText().toString()
                                +"','"+ngayTraPS.getText().toString()+"','"+tienPhatPS.getText().toString()+"')";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlThem);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        btnSuaPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection=SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlSua="update ThongTinPhat set SoDienThoai = '"+sdtPS.getText().toString()+"', MaSach='"+
                                maSachPS.getText().toString()+"',TenSach='"+tenSachPS.getText().toString()+"',HanTra='"+
                                hanTraPS.getText().toString()+"',NgayTra='"+ngayTraPS.getText().toString()+"',TienPhat='"+
                                tienPhatPS.getText().toString()+"'where TenDocGia = '"+tenDGPS.getText().toString()+"'";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlSua);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        btnXoaPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection=SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlXoa="delete ThongTinPhat where TenDocGia = '"+tenDGPS.getText().toString()+"'";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlXoa);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        btnXemPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(phatTraSachMuon.this, XemThongTinPhat.class);
                startActivity(myintent);
            }
        });
    }
}