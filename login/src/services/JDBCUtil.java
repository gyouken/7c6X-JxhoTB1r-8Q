package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
    static {//加载JDBC驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {//创建数据库连接
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/users" + "?serverTimezone=GMT%2B8", "root", "******");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs, Statement statement, Connection con) {//关闭数据库连接
        try {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
            if (con != null)
                con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}