package com.example.qltv_fbu;

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
import java.util.ArrayList;

public class docthuc extends AppCompatActivity {
    //khai báo các biến giao diện
    ImageButton btnBackDT;
    EditText tenDocGiaDT,sdtDT,idSachDT,tenSachDT,hanTraDT,ghiChuDT;
    Button btnGuiDT,btnXoaDT,btnXemDT,btnSuaDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_docthuc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id
        btnBackDT=findViewById(R.id.btnBackDT);
        tenDocGiaDT=findViewById(R.id.tenDocGiaDT);
        sdtDT=findViewById(R.id.sdtDT);
        idSachDT=findViewById(R.id.idSachDT);
        tenSachDT=findViewById(R.id.tenSachDT);
        hanTraDT=findViewById(R.id.hanTraDT);
        ghiChuDT=findViewById(R.id.ghiChuDT);
        btnGuiDT=findViewById(R.id.btnGuiDT);
        btnXoaDT=findViewById(R.id.btnXoaDT);
        btnXemDT=findViewById(R.id.btnXemDT);
        btnSuaDT=findViewById(R.id.btnSuaDT);


        //hàm xử lý sự kiện khi click vào nút quay lại
        btnBackDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khởi tạo đối tượng intent cho phép chuuyển giao diện
                Intent myintent = new Intent(docthuc.this, trangchu.class);
                startActivity(myintent);
            }
        });


        //hàm xử lý sự kiện khi click vào nut gửi đốc thúc
        btnGuiDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối với csdl
                Connection connection= SQLmanagement.connectionSQLSever();
                Toast.makeText(docthuc.this, "Gửi thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //khởi tạo câu lệnh sql thêm thông tin vào bảng ThongTinDocThuc
                        String sqlThem="insert into ThongTinDocThuc values ('"+tenDocGiaDT.getText().toString()+"','"+sdtDT.getText().toString()+"','"+idSachDT.getText().toString()+"','"+tenSachDT.getText().toString()+"','"+hanTraDT.getText().toString()+"','"+ghiChuDT.getText().toString()+"')";
                        //khởi tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlThem);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });


        //hàm xử lý sự kiện khi click vào nut sửa đốc thúc
        btnSuaDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối với csdl
                Connection connection=SQLmanagement.connectionSQLSever();
                Toast.makeText(docthuc.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //khởi tạo câu lệnh sql sưa thông tin trong bảng ThongTinDocThuc
                        String sqlSua="update ThongTinDocThuc set SoDienThoai='"+sdtDT.getText().toString()+"',MaSach='"+idSachDT.getText().toString()+"',TenSach='"+tenSachDT.getText().toString()+"',HanTra='"+hanTraDT.getText().toString()+"',GhiChu='"+ghiChuDT.getText().toString()+"'where TenDocGia = '"+tenDocGiaDT.getText().toString()+"'";
                        //khởi tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlSua);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });

        //hàm xử lý sự kiện khi click vào nut xóa đốc thúc
        btnXoaDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối với csdl
                Connection connection=SQLmanagement.connectionSQLSever();
                Toast.makeText(docthuc.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //khởi tạo câu lệnh sql xóa thông tin trong bảng ThongTinDocThuc
                        String sqlXoa="delete ThongTinDocThuc where TenDocGia = '"+tenDocGiaDT.getText().toString()+"'";
                        //khởi tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlXoa);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });


        //hàm xử lý sự kiện khi click vào nut sửa đốc thúc
        btnXemDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khởi tạo đối tượng intent cho phép chuuyển giao diện
                Intent myintent = new Intent(docthuc.this, XemThongTinDocThuc.class);
                startActivity(myintent);
            }
        });
    }
}