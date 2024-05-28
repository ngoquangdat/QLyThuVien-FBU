package com.example.qltv_fbu;
//khai báo các thư viện liên quan
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.sql.SQLException;
import java.util.ArrayList;
import Datamanagement.Logins;
//Class chính
public class MainActivity extends AppCompatActivity {
    //khai báo các biến tương ứng với các thành phần giao diện
    private EditText btnTkDN,btnMKDN;
    private Button btnDangNhap,btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainQlyTraSach), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Init();
            onClickChangePage();
            return insets;
        });
        //ánh xạ id tương ưng
        btnDangKy = findViewById(R.id.btnDangKy);
        //hàm xử lý sự kiện khi click vào nút đăng ký
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo 1 intent cho phép chuyển từ giao diện đăng nhập tới giao diện đăng ký
                Intent myintent = new Intent(MainActivity.this,dangky.class);
                startActivity(myintent);
            }
        });
    }
    private void onClickChangePage() {
        //hàm xử lý sự kiện khi click vào nút đăng nhập
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo biến và gán dữ liệu trùng vs dữ liệu nhâp
                String user = btnTkDN.getText().toString();
                String passwords = btnMKDN.getText().toString();
                //khai báo class logins
                Logins logins = new Logins();
                try {
                    logins = Logins.getuserlist(user,passwords);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }if(user.length()==0 || passwords.length() ==0){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tài khoản hoặc mật khâu", Toast.LENGTH_SHORT).show();
                }
                else if(logins.getUser().equals(user) && logins.getPass().equals(passwords)){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,trangchu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Tài khoản mật khẩu của bạn không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Init() {
        btnTkDN = findViewById(R.id.btnTkDN);
        btnMKDN = findViewById(R.id.btnMKDN);
        btnDangNhap = findViewById(R.id.btnDangNhap);
    }
}