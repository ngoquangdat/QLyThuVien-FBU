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

public class XemThongTinTraSach extends AppCompatActivity {
    TextView timKiemTS,tenXemTS,lopXemTS,sdtXemTS,idSachXemTS,tenSachXemTS,dateMuonXemTS,dateTraXemTS;
    Button btnBackXemTS;
    ImageButton btnTimKiemTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_thong_tin_tra_sach);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        timKiemTS=findViewById(R.id.timKiemTS);
        tenXemTS=findViewById(R.id.tenXemTS);
        lopXemTS=findViewById(R.id.lopXemTS);
        sdtXemTS=findViewById(R.id.sdtXemTS);
        idSachXemTS=findViewById(R.id.idSachXemTS);
        tenSachXemTS=findViewById(R.id.tenSachXemTS);
        dateMuonXemTS=findViewById(R.id.dateMuonXemTS);
        dateTraXemTS=findViewById(R.id.dateTraXemTS);
        btnBackXemTS=findViewById(R.id.btnBackXemTS);
        btnTimKiemTS=findViewById(R.id.btnTimKiemTS);

        btnBackXemTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(XemThongTinTraSach.this, TrangChuQlyTraSach.class);
                startActivity(myintent);
            }
        });
        btnTimKiemTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        String sqlXem="select * from ThongTinTraSach where TenDocGia = '"+timKiemTS.getText().toString()+"'";
                        Statement st=connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlXem);
                        while (rs.next()){
                            tenXemTS.setText(rs.getString(1));
                            lopXemTS.setText(rs.getString(2));
                            sdtXemTS.setText(rs.getString(3));
                            idSachXemTS.setText(rs.getString(4));
                            tenSachXemTS.setText(rs.getString(5));
                            dateMuonXemTS.setText(rs.getString(6));
                            dateTraXemTS.setText(rs.getString(7));
                        }
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
    }
}