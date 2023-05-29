package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scarborough
 * @creat 2023/5/29 - 10:42
 */
public class AdminLogin extends JFrame implements ActionListener {
    /**
     * 登录的用户
     */
    public AdminAccount currentAccount;
    /**
     * 定义面板，布局
     */
    private JPanel p0, p1, p2, p3;
    /**
     * 账号
     */
    private JTextField userName;
    /**
     * 密码
     */
    private JPasswordField passWord;
    /**
     * 登录，退出按钮
     */
    private JButton login, exit;
    private JLabel jl1, jl2, jl3;
    Map<String, AdminAccount> resultMap = new HashMap<>();

    public AdminLogin(){
        // 窗体标题
        super("管理员登录ATM");

        // 简单美化UI
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        MySqlConnection mySqlConnection = new MySqlConnection();
        Connection connection = mySqlConnection.getConnection();

        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM admin_info";
            ResultSet resultSet = statement.executeQuery(sql);
            Map<String, Object> map = new HashMap<>();
            while(resultSet.next()){
                AdminAccount adminAccount = new AdminAccount(
                        resultSet.getString("admin_id"),
                        resultSet.getString("password"));
                resultMap.put(resultSet.getString("admin_id"), adminAccount);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        // 设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗体布局为4*1的网格布局
        setLayout(new GridLayout(4, 1));

        p0 = new JPanel();
        // 设置标签内容（下同）
        jl1 = new JLabel("欢迎使用ATM柜员机系统！");
        // 设置标签字体，加粗，大小（下同）
        jl1.setFont(new Font("黑体", Font.BOLD, 40));
        // 添加组件，将标签添加到面板（下同）
        p0.add(jl1);

        p1 = new JPanel();
        jl2 = new JLabel("账号：");
        jl2.setFont(new Font("黑体", Font.BOLD, 25));
        p1.add(jl2);
        // 设置文本框长度为20
        userName = new JTextField(20);
        userName.setFont(new Font("黑体", Font.PLAIN, 25));
        p1.add(userName);

        p2 = new JPanel();
        jl3 = new JLabel("密码：");
        jl3.setFont(new Font("黑体", Font.BOLD, 25));
        p2.add(jl3);
        passWord = new JPasswordField(20);
        passWord.setFont(new Font("黑体", Font.PLAIN, 25));
        // 设置密码框输入密码时显示为*
        passWord.setEchoChar('*');
        p2.add(passWord);

        p3 = new JPanel();
        // 将容器设置为绝对布局，组件位置坐标大小可自定义
        p3.setLayout(null);
        login = new JButton("登录");
        // 定义按钮坐标大小
        login.setBounds(350, 50, 60, 40);
        exit = new JButton("退出");
        exit.setBounds(500, 50, 60, 40);
        p3.add(login);
        p3.add(exit);

        // 将面板添加到窗体
        add(p0);
        add(p1);
        add(p2);
        add(p3);

        // 设置窗体可见
        setVisible(true);
        // 设置窗体大小
        setSize(900, 700);
        // 居中
        setLocationRelativeTo(null);
        // 设置窗体大小固定
        setResizable(false);

        // 按钮添加监听
        login.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
            if(resultMap.containsKey(userName.getText())){
                AdminAccount adminAccount = resultMap.get(userName.getText());
                if(new String(passWord.getPassword()).equals(adminAccount.password)){
                    JOptionPane.showMessageDialog(this, "登录成功");
                    // 实例化操作主界面窗口
                    new AdminMenu(adminAccount);
                    // 释放登录窗口
                    dispose();
                }
            }
        }
    }
}
