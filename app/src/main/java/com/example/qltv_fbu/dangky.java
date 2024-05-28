package com.example.qltv_fbu;
//khai báo các thư viện liên quan
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
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

public class dangky extends AppCompatActivity {
    //khai báo các biến giao diện
    ImageButton btnBackDK;//khai báo biến giao diện tương ứng với nút quay lại
    TextView idLogDK,emailDK,mkDK,xacNhanMKDK;//khai báo biến giao diện tương ứng với 4 ô nhập liệu
    Button btnDK;//khai báo biến giao diện tương ứng với nút đăng ký

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id
        mkDK=findViewById(R.id.mkDK);
        btnBackDK=findViewById(R.id.btnBackDK);//ánh xạ biến giao diện tương ứng với id giao diện nút quay lại
        idLogDK=findViewById(R.id.idLogDK);//ánh xạ biến giao diện tương ứng với id giao diện ô mã đăng nhập
        emailDK=findViewById(R.id.emailDK);//ánh xạ biến giao diện tương ứng với id giao diện ô email
        xacNhanMKDK=findViewById(R.id.xacNhanMKDK);//ánh xạ biến giao diện tương ứng với id giao diện ô mật khẩu
        btnDK=findViewById(R.id.btnDK);//ánh xạ biến giao diện tương ứng với id giao diện ô xác nhận mk

        //hàm xử lý sự kiện khi click vào nút quay lại
        btnBackDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo đối tượng Intent
                Intent myintent = new Intent(dangky.this, MainActivity.class);//tạo 1 intent cho phép chuyển từ giao diện đăng ký về giao diện đăng nhập
                startActivity(myintent);//Thực thi câu lệnh
            }
        });

        //hàm xử lý sự kiện khi click vào nút đăng ký
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection connection= SQLmanagement.connectionSQLSever();//kết nối csdl
                try {
                    if(connection!=null){
                        BreakIterator id;
                        //tạo câu lệnh sql thêm thông tin
                        String sqlDk="insert into ThongTinDangky values('"+idLogDK.getText().toString()+"','"
                                +emailDK.getText().toString()+"','"+mkDK.getText().toString()+"','"+xacNhanMKDK.getText().toString()+"')";
                        //tạo đối tượng Statement
                        Statement st=connection.createStatement();
                        //thực thi câu lệnh sql
                        ResultSet rs=st.executeQuery(sqlDk);
                        //hiển thị ra màn hình thông báo
                        Toast.makeText(dangky.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException exception) {
                    Log.e("Errol",exception.getMessage());
                }
            }
        });
    }
}