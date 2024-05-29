package com.example.qltv_fbu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class TrangChuQlyTraSach extends AppCompatActivity {
    //Khai báo các biến tương ứng với layout giao diện
    ImageButton btnBackTS;//khai báo biến ImgButton
    EditText tenDGTS,lopHCTS,sdtTS,idSachTS,tenSachTS,dateDKTS,dateTS;//khai báo các biến eidtext
    Button btnThemTS,btnSuaTS,btnXoaTS,btnXemTS;//khai báo các biến button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trang_chu_qly_tra_sach);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id của các thành phần giao diện tương ứng với các biến giao diện đã khai báo ở trên
        tenDGTS=findViewById(R.id.tenDGTS);
        lopHCTS=findViewById(R.id.lopHCTS);
        sdtTS=findViewById(R.id.sdtTS);
        idSachTS=findViewById(R.id.idSachTS);
        tenSachTS=findViewById(R.id.tenSachTS);
        dateDKTS=findViewById(R.id.dateDKTS);
        dateTS=findViewById(R.id.dateTS);
        btnThemTS=findViewById(R.id.btnThemTS);
        btnSuaTS=findViewById(R.id.btnSuaTS);
        btnXoaTS=findViewById(R.id.btnXoaTS);
        btnXemTS=findViewById(R.id.btnXemTS);
        btnBackTS=findViewById(R.id.btnBackTS);

        //xử lý sự kiện khi click vào ô quay lại
        btnBackTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(TrangChuQlyTraSach.this, trangchu.class);//khai báo intent cho phép chuyển từ giao diện naỳ qua giao diện khác
                startActivity(myintent);//thực thi câu lệnh
            }
        });

        //xử lý sự kiện khi click vào ô thêm
        btnThemTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();//kết nối với csdl
                Toast.makeText(TrangChuQlyTraSach.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //câu lệnh thêm dòng mới vào bảng ThongTinTraSach trong csdl
                        String sqlThem="insert into ThongTinTraSach values ('"+tenDGTS.getText().toString()+"','"+lopHCTS.getText().toString()+"','"+sdtTS.getText().toString()+"','"+idSachTS.getText().toString()+"','"+tenSachTS.getText().toString()+"','"+dateTS.getText().toString()+"','"+dateDKTS.getText().toString()+"')";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //Thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlThem);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });

        //xử lý sự kiện khi click vào ô sửa
        btnSuaTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection=SQLmanagement.connectionSQLSever();//kết nối với csdl
                Toast.makeText(TrangChuQlyTraSach.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql update bảng ThongTinTraSach trong csdl
                        String sqlSua="update ThongTinTraSach set LopHanhChinh = '"+lopHCTS.getText().toString()+"',SoDienThoai='"+sdtTS.getText().toString()+"',MaSach='"+idSachTS.getText().toString()+"',TenSach='"+tenSachTS.getText().toString()+"',NgayDangKyMuon='"+dateDKTS.getText().toString()+"',NgayTra='"+dateTS.getText().toString()+"'where TenDocGia = '"+tenDGTS.getText().toString()+"'";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlSua);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });


        //xử lý sự kiện khi click vào ô xóa
        btnXoaTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection=SQLmanagement.connectionSQLSever();//kết nối với csdl
                Toast.makeText(TrangChuQlyTraSach.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql xóa dòng trong bảng ThongTinTraSach
                        String sqlXoa="delete ThongTinTraSach where TenDocGia = '"+tenDGTS.getText().toString()+"'";
                        //tạo đối tượng statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh
                        ResultSet rs=st.executeQuery(sqlXoa);
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });

        //xử lý sự kiện khi click vào ô xem
        btnXemTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent cho phép chuyên từ giao diện này đến giao diện khác
                Intent myintent = new Intent(TrangChuQlyTraSach.this, XemThongTinTraSach.class);
                //thực thi câu lệnh
                startActivity(myintent);
            }
        });
    }
}