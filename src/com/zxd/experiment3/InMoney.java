package com.zxd.experiment3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ATM存款界面
 *
 * @author zz
 */
public class InMoney implements ActionListener {

    /** 定义组件 */
    public JTextField money;
    public JFrame inframe;
    public JPanel op0, op1, op2, op3, op4;
    public JButton confirm, cancel, exit;
    public JLabel id, yue, cun, tishi;
    boolean flag1 = false;
    boolean flag2 = false;
    private Account currentAccount;

    /**
     * 构造存款界面
     *
     * @param account 要存款的账户
     */
    public InMoney(Account account){
        // 简单美化UI
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        inframe = new JFrame("存款");
        currentAccount = account;
        inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        op0 = new JPanel();
        // 获取Test类中的账号数据（下同）
        id = new JLabel("账号：" + currentAccount.id);
        id.setFont(new Font("黑体", Font.BOLD, 25));
        op0.add(id);

        op1 = new JPanel();
        yue = new JLabel("账户余额：" + currentAccount.money);
        yue.setFont(new Font("黑体", Font.BOLD, 25));
        op1.add(yue);

        op2 = new JPanel();
        cun = new JLabel("存款金额：");
        cun.setFont(new Font("黑体", Font.BOLD, 25));
        money = new JTextField(20);
        money.setFont(new Font("黑体", Font.BOLD, 25));

        op2.add(cun);
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
        inframe.setResizable(false);

        // 添加监听
        confirm.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if("确定".equals(e.getActionCommand())){
            try{
                int money1 = Integer.parseInt(money.getText());
                if(money1 % 100 == 0){
                    // 调用当前登陆账户的存钱函数
                    currentAccount.inMoney(Integer.parseInt(money.getText()));
                    // 弹窗
                    JOptionPane.showMessageDialog(null, "存款成功");
                    // 文本框清空
                    money.setText("");
                    // 账户余额更新
                    yue.setText("账户余额:" + currentAccount.money);
                } else{
                    // 弹窗
                    JOptionPane.showMessageDialog(null, "系统不支持非100元整钞存款\n 请重新输入存款款金额 ！ ");
                    money.setText("");
                }
                // 捕获当前登录账户中 inMoney 函数中的异常。类型转换异常
            } catch(ClassCastException e1){
                JOptionPane.showMessageDialog(null, "输入数据类型错误，请输入整数");
            } catch(Exception e1){
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if("返回".equals(e.getActionCommand())){
            // 关闭存钱界面
            inframe.dispose();
        }
    }
}
