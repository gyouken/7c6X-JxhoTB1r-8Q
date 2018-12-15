package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Login {
    public static boolean login(String username, String password) {
        boolean isValid = false;
        Connection con = JDBCUtil.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where user_name='" + username + "' and password='" + password + "'");
            if (rs.next()) {
                isValid = true;
                stmt.addBatch("insert into log values(NULL," + rs.getString("user_id") + ",now())");
                stmt.executeBatch();
            }
            JDBCUtil.close(rs, stmt, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
