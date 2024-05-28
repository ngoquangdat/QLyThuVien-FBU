package Datamanagement;

import com.example.qltv_fbu.SQLmanagement.SQLmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Logins {
    String IdLog;
    String MatKhau;
    public Logins(){
        IdLog = "";
        MatKhau = "";
    };
    public Logins(String user, String pass) {
        IdLog = user;
        this.MatKhau = pass;
    }

    public static Logins getuserlist(String user,String passWords) throws SQLException {
        Connection connection = SQLmanagement.connectionSQLSever();
        Logins logins = new Logins();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from ThongTinDangky where IdLog = '" + user + "' and MatKhau = '" + passWords +"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            logins = new Logins(
                    rs.getString(1).trim(),
                    rs.getString(3).trim());// Đọc dữ liệu từ ResultSet)
        }

        statement.close();
        connection.close();// Đóng kết nối
        return logins;
    }


    public String getUser() {
        return IdLog;
    }

    public void setUser(String user) {
        IdLog = user;
    }

    public String getPass() {
        return MatKhau;
    }

    public void setPass(String pass) {
        this.MatKhau = pass;
    }
}