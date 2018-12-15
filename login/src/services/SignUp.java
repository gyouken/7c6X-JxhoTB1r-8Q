package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {
    public static boolean signup(String username, String password) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users.user where user_name='" + username + "'");
            if (!rs.next()) {
                stmt.addBatch("insert into user values(NULL,'" + username + "','" + password + "',now())");
                stmt.executeBatch();
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
