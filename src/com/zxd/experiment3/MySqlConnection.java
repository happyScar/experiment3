package com.zxd.experiment3;

import java.sql.*;

/**
 * @author scarborough
 * @creat 2023/5/27 - 15:57
 */
public class MySqlConnection {
    Connection connection;
    public static final String USER = "root";
    public static final String PASSWORD = "amdznnhxw1028..";

    /**
     * 建立返回值为 Connection 的方法
     *
     * @return 返回一个 Connection 对象
     */
    public Connection getConnection() {

        try {
            // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // 通过访问数据库的URL获取数据库连接对象
            connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/atm_db?useUnicode=true&characterEncoding=gbk",
                            USER,
                            PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回一个Connection对象
        return connection;
    }

}
