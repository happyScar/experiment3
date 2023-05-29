package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author scarborough
 * @creat 2023/5/29 - 10:32
 */
public class Enter extends JFrame implements ActionListener {
    /** 定义面板 */
    private JPanel mp1,mp2;
    /** 管理员 */
    private JButton administrator;
    /** 普通用户 */
    private JButton user;
    public Enter(){
        // 窗体标题
        super("选择身份登录");

        // 简单美化UI
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        // 设置窗体为3*1的网格布局
        setLayout(new GridLayout(3,1));
        // 设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 定义按钮
        administrator=new JButton("管理员身份");
        user=new JButton("普通用户");

        // 将mp1面板设置为边界布局
        mp1=new JPanel(new BorderLayout());
        // 定义标签，标签居中
        JLabel jlb1=new JLabel("ATM登录身份选择",JLabel.CENTER);
        jlb1.setFont(new Font("黑体",Font.BOLD,60));
        // 设置标签的文字颜色为蓝色
        jlb1.setForeground(Color.blue);
        // 将标签添加到面板布局的中间位置
        mp1.add(jlb1,BorderLayout.CENTER);

        mp2=new JPanel();
        mp2.add(administrator);
        mp2.add(user);
        // 设置面板mp2为2*1的网格布局
        mp2.setLayout(new GridLayout(2,1));

        add(mp1);
        add(mp2);
        // 设置可见
        setVisible(true);
        // 设置大小
        setSize(800, 600);
        // 居中
        setLocationRelativeTo(null);
        //设置窗体大小固定
        setResizable(false);

        // 绑定监听器
        administrator.addActionListener(this);
        user.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        if("管理员身份".equals(str)){
            new AdminLogin();
        }else if("普通用户".equals(str)){
            new Login();
        }
    }
}
