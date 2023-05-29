package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author scarborough
 * @creat 2023/5/29 - 10:58
 */
public class AdminMenu extends JFrame implements ActionListener {
    /** 定义面板 */
    private JPanel mp1,mp2;
    /** 开卡 */
    private JButton createCard;
    /** 销卡 */
    private JButton deleteCard;
    /** 退出 */
    private JButton exit;
    /** 操作的账户 */
    private Account currentAccount;
    private AdminAccount adminAccount;

    public AdminMenu(AdminAccount account){
        super("ATM自动取款机系统管理员系统");

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

        adminAccount=account;
        // 设置窗体为3*1的网格布局
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 定义按钮
        createCard=new JButton("开卡");
        deleteCard=new JButton("销卡");
        exit=new JButton("退出");
        createCard.setFont(new Font("黑体",Font.BOLD,30));
        deleteCard.setFont(new Font("黑体",Font.BOLD,30));
        exit.setFont(new Font("黑体",Font.BOLD,30));
        // 将mp1面板设置为边界布局
        mp1=new JPanel(new BorderLayout());
        // 定义标签，标签居中
        JLabel jlb1=new JLabel("ATM业务选择",JLabel.CENTER);
        jlb1.setFont(new Font("黑体",Font.BOLD,60));
        // 设置标签的文字颜色为蓝色
        jlb1.setForeground(Color.blue);
        // 将标签添加到面板布局的中间位置
        mp1.add(jlb1,BorderLayout.CENTER);

        mp2=new JPanel();
        mp2.add(createCard);
        mp2.add(deleteCard);
        mp2.add(exit);
        // 设置面板mp2为3*1的网格布局
        mp2.setLayout(new GridLayout(3,1));

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
        createCard.addActionListener(this);
        deleteCard.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // cmd 赋值为点击的按钮的标题文字
        String cmd=e.getActionCommand();
        if("开卡".equals(cmd)){
            new CreateCard(adminAccount);
        }
        else if("销卡".equals(cmd)){
            new DeleteCard(adminAccount);
        }else if("退出".equals(cmd)){
            // 弹窗
            JOptionPane.showMessageDialog(null,"请记得取走您的银行卡");
            // 关闭窗体
            dispose();
            // 再次打开选择身份界面
            new Enter();
        }
    }
}
