package com.example.qltv_fbu;
import com.example.qltv_fbu.SQLmanagement.SQLmanagement;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;

import kotlin.Suppress;

public class TrangChuQlyMuonSach extends AppCompatActivity {
    //Khai báo các biến giao diện
    EditText tenDocGiaMS,lopHCMS,sdtMS,idSachMS,tenSachMS,timeMS,dateMS;
    Button btnThemMS,btnSuaMS,btnXoaMS,btnXemMS;
ImageButton btnBackMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trang_chu_qly_muon_sach);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //ánh xạ id giao diện tương ứng với các biến giao diện
        tenDocGiaMS=findViewById(R.id.tenDocGiaMS);
        lopHCMS=findViewById(R.id.lopHCMS);
        sdtMS=findViewById(R.id.sdtMS);
        idSachMS=findViewById(R.id.idSachMS);
        tenSachMS=findViewById(R.id.tenSachMS);
        timeMS=findViewById(R.id.timeMS);
        dateMS=findViewById(R.id.dateMS);
        btnThemMS=findViewById(R.id.btnThemMS);
        btnSuaMS=findViewById(R.id.btnSuaMS);
        btnXoaMS=findViewById(R.id.btnXoaMS);
        btnXemMS=findViewById(R.id.btnXemMS);
        btnBackMS=findViewById(R.id.btnBackMS);

        //hàm xử lý sự kiện khi click vào nút quay lại
        btnBackMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện quản lý mợn sách đến giao diện trang chủ
                Intent myintent = new Intent(TrangChuQlyMuonSach.this, trangchu.class);
                startActivity(myintent);
            }
        });

        //hàm xử lý sự kiện khi click vào nút thêm
        btnThemMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối csdl
                Connection connection=SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql thêm thông tin vào bảng PhieuMuon
                        String sqlThem="insert into PhieuMuon values('"+tenDocGiaMS.getText().toString()+"','"+
                                lopHCMS.getText().toString()+"','"+sdtMS.getText().toString()+"','"+idSachMS.getText().toString()+"','"
                                +tenSachMS.getText().toString()+"','"+timeMS.getText().toString()+"','"+dateMS.getText().toString()+"')";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //chạy câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlThem);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });

        //hàm xử lý sự kiện khi click vào nút sửa
        btnSuaMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối csdl
                Connection connection=SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql sửa thông tin trong bảng PhieuMuon
                        String sqlSua="update PhieuMuon set LopHanhChinh = '"+lopHCMS.getText().toString()+
                                "', SoDienThoai='"+sdtMS.getText().toString()+"',MaSach='"+idSachMS.getText().toString()+"',TenSach='"+
                                tenSachMS.getText().toString()+"',ThoiGianMuon='"+timeMS.getText().toString()+"',NgayMuon='"+
                                dateMS.getText().toString()+"'where TenDocGia = '"+tenDocGiaMS.getText().toString()+"'";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //chạy câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlSua);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });


        //hàm xử lý sự kiện khi click vào nút xóa
        btnXoaMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối csdl
                Connection connection=SQLmanagement.connectionSQLSever();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql xóa thông tin trong bảng PhieuMuon
                        String sqlXoa="delete PhieuMuon where TenDocGia = '"+tenDocGiaMS.getText().toString()+"'";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //chạy câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlXoa);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });

        //hàm xử lý sự kiện khi click vào nút xem
        btnXemMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyển giao diện từ giao diện quản lý mợn sách đến giao diện xem thông tin mượn sách
                Intent myintent = new Intent(TrangChuQlyMuonSach.this, XemThongTinMuonSach.class);
                startActivity(myintent);
            }
        });
    }
}


