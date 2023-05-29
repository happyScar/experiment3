package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

/**
 * @author scarborough
 * @creat 2023/5/29 - 11:09
 */
public class DeleteCard implements ActionListener {
    /** ������� */
    public JTextField money;
    public JFrame inframe;
    public JPanel op0, op1, op2, op3, op4;
    public JButton confirm, cancel, exit;
    public JLabel id, password, cardMoney, tishi;
    boolean flag1 = false;
    boolean flag2 = false;
    private Account currentAccount;
    private AdminAccount adminAccount;
    public DeleteCard(AdminAccount account){
        // ������UI
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

        inframe = new JFrame("����");
        adminAccount = account;
        inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        op0 = new JPanel();
        // ��ȡTest���е��˺����ݣ���ͬ��
        id = new JLabel("�����˺�");
        id.setFont(new Font("����", Font.BOLD, 25));
        money = new JTextField(20);
        money.setFont(new Font("����", Font.BOLD, 25));
        op0.add(id);
        op0.add(money);

        op3 = new JPanel();
        confirm = new JButton("ȷ��");
        confirm.setFont(new Font("����", Font.PLAIN, 25));
        op3.add(confirm);
        cancel = new JButton("����");
        cancel.setFont(new Font("����", Font.PLAIN, 25));
        op3.add(cancel);

        inframe.add(op0);
        inframe.add(op3);

        // ���ô���Ϊ������
        inframe.setLayout(new FlowLayout());
        // ����ɼ�
        inframe.setVisible(true);
        // �����С
        inframe.setSize(450, 200);
        // ����Ļ�м���ʾ(������ʾ)
        inframe.setLocationRelativeTo(null);
        // �����С�̶�
        inframe.setResizable(false);

        // ��Ӽ���
        confirm.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if("ȷ��".equals(e.getActionCommand())){
            try{
                Statement statement = new MySqlConnection().getConnection().createStatement();
                String sql = "DELETE FROM card_info WHERE card_id='%s'";
                String[] strings = {money.getText()};
                if(statement.executeUpdate(String.format(sql,strings[0]))!=0){
                    System.out.println("���³ɹ�");
                }else {
                    System.out.println("����ʧ��");
                }
            } catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }else if("����".equals(e.getActionCommand())){
            // �رս���
            inframe.dispose();
        }
    }
}
