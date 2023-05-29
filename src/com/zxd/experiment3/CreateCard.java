package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author scarborough
 * @creat 2023/5/29 - 11:09
 */
public class CreateCard implements ActionListener {
    /** 定义组件 */
    public JTextField money;
    public JTextField cardId;
    public JTextField cardPassword;
    public JFrame inframe;
    public JPanel op0, op1, op2, op3, op4;
    public JButton confirm, cancel, exit;
    public JLabel id, password, cardMoney, tishi;
    boolean flag1 = false;
    boolean flag2 = false;
    private Account currentAccount;
    private AdminAccount adminAccount;

    public CreateCard(AdminAccount account){
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

        inframe = new JFrame("开卡");
        adminAccount = account;
        inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        op0 = new JPanel();
        // 获取Test类中的账号数据（下同）
        id = new JLabel("开卡分配账号：");
        id.setFont(new Font("黑体", Font.BOLD, 20));
        cardId = new JTextField(25);
        cardId.setFont(new Font("黑体", Font.BOLD, 20));
        op0.add(id);
        op0.add(cardId);

        op1 = new JPanel();
        password = new JLabel("密码：");
        password.setFont(new Font("黑体", Font.BOLD, 20));
        cardPassword = new JTextField(25);
        cardPassword.setFont(new Font("黑体", Font.BOLD, 20));
        op1.add(password);
        op1.add(cardPassword);

        op2 = new JPanel();
        cardMoney = new JLabel("金额：");
        cardMoney.setFont(new Font("黑体", Font.BOLD, 20));
        money = new JTextField(25);
        money.setFont(new Font("黑体", Font.BOLD, 20));
        op2.add(cardMoney);
        op2.add(money);

        op3 = new JPanel();
        confirm = new JButton("确定");
        confirm.setFont(new Font("黑体", Font.PLAIN, 25));
        op3.add(confirm);
        cancel = new JButton("返回");
        cancel.setFont(new Font("黑体", Font.PLAIN, 25));
        op3.add(cancel);

        inframe.add(op0);
        inframe.add(op1);
        inframe.add(op2);
        inframe.add(op3);

        // 设置窗体为流布局
        inframe.setLayout(new FlowLayout());
        // 窗体可见
        inframe.setVisible(true);
        // 窗体大小
        inframe.setSize(450, 200);
        // 在屏幕中间显示(居中显示)
        inframe.setLocationRelativeTo(null);
        // 窗体大小固定
        inframe.setResizable(true);

        // 添加监听
        confirm.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if("确定".equals(e.getActionCommand())){
            try{
                adminAccount.createCard(cardId.getText(), cardPassword.getText(),Integer.parseInt( money.getText()));
                Statement statement = new MySqlConnection().getConnection().createStatement();
                String sql = "INSERT card_info values('%s','%s',%s)";
                String[] strings = {cardId.getText(), cardPassword.getText(), money.getText()};
                if(statement.execute(String.format(sql,strings[0],strings[1],strings[2]))){
                    System.out.println("更新成功");
                }else {
                    System.out.println("更新失败");
                }
            } catch(Exception ex){
                throw new RuntimeException(ex);
            }
            // 弹窗
            JOptionPane.showMessageDialog(null, "开卡成功");

        }else if("返回".equals(e.getActionCommand())){
            // 关闭界面
            inframe.dispose();
        }
    }
}
