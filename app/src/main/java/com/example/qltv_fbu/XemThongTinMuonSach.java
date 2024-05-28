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

public class XemThongTinMuonSach extends AppCompatActivity {
    TextView timKiemMS,tenDGXemMS,lopXemMS,sdtXemMS,idSachXemMS,tenSachXemMS,dateMuonXemMS,timeMuonXemMS;
    Button btnBackXemMS;
    ImageButton btnTimKiemMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_thong_tin_muon_sach);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        timKiemMS=findViewById(R.id.timKiemMS);
        tenDGXemMS=findViewById(R.id.tenDGXemMS);
        lopXemMS=findViewById(R.id.lopXemMS);
        sdtXemMS=findViewById(R.id.sdtXemMS);
        idSachXemMS=findViewById(R.id.idSachXemMS);
        tenSachXemMS=findViewById(R.id.tenSachXemMS);
        dateMuonXemMS=findViewById(R.id.dateMuonXemMS);
        timeMuonXemMS=findViewById(R.id.timeMuonXemMS);
        btnBackXemMS=findViewById(R.id.btnBackXemMS);
        btnTimKiemMS=findViewById(R.id.btnTimKiemMS);


        btnTimKiemMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlXem="select * from PhieuMuon where TenDocGia = '"+timKiemMS.getText().toString()+"'";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlXem);
                        while (rs.next()){
                            tenDGXemMS.setText(rs.getString(1));
                            lopXemMS.setText(rs.getString(2));
                            sdtXemMS.setText(rs.getString(3));
                            idSachXemMS.setText(rs.getString(4));
                            tenSachXemMS.setText(rs.getString(5));
                            dateMuonXemMS.setText(rs.getString(7));
                            timeMuonXemMS.setText(rs.getString(6));
                        }
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
        btnBackXemMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(XemThongTinMuonSach.this, TrangChuQlyMuonSach.class);
                startActivity(myintent);
            }
        });
    }
}