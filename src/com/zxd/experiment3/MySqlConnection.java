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
     * ��������ֵΪ Connection �ķ���
     *
     * @return ����һ�� Connection ����
     */
    public Connection getConnection() {

        try {
            // �������ݿ�������
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
            connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/atm_db?useUnicode=true&characterEncoding=gbk",
                            USER,
                            PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ����һ��Connection����
        return connection;
    }

}
