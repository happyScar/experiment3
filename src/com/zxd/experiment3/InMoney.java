package com.zxd.experiment3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ATM������
 *
 * @author zz
 */
public class InMoney implements ActionListener {

    /** ������� */
    public JTextField money;
    public JFrame inframe;
    public JPanel op0, op1, op2, op3, op4;
    public JButton confirm, cancel, exit;
    public JLabel id, yue, cun, tishi;
    boolean flag1 = false;
    boolean flag2 = false;
    private Account currentAccount;

    /**
     * ���������
     *
     * @param account Ҫ�����˻�
     */
    public InMoney(Account account){
        // ������UI
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

        inframe = new JFrame("���");
        currentAccount = account;
        inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        op0 = new JPanel();
        // ��ȡTest���е��˺����ݣ���ͬ��
        id = new JLabel("�˺ţ�" + currentAccount.id);
        id.setFont(new Font("����", Font.BOLD, 25));
        op0.add(id);

        op1 = new JPanel();
        yue = new JLabel("�˻���" + currentAccount.money);
        yue.setFont(new Font("����", Font.BOLD, 25));
        op1.add(yue);

        op2 = new JPanel();
        cun = new JLabel("����");
        cun.setFont(new Font("����", Font.BOLD, 25));
        money = new JTextField(20);
        money.setFont(new Font("����", Font.BOLD, 25));

        op2.add(cun);
        op2.add(money);

        op3 = new JPanel();
        confirm = new JButton("ȷ��");
        confirm.setFont(new Font("����", Font.PLAIN, 25));
        op3.add(confirm);
        cancel = new JButton("����");
        cancel.setFont(new Font("����", Font.PLAIN, 25));
        op3.add(cancel);

        inframe.add(op0);
        inframe.add(op1);
        inframe.add(op2);
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
                int money1 = Integer.parseInt(money.getText());
                if(money1 % 100 == 0){
                    // ���õ�ǰ��½�˻��Ĵ�Ǯ����
                    currentAccount.inMoney(Integer.parseInt(money.getText()));
                    // ����
                    JOptionPane.showMessageDialog(null, "���ɹ�");
                    // �ı������
                    money.setText("");
                    // �˻�������
                    yue.setText("�˻����:" + currentAccount.money);
                } else{
                    // ����
                    JOptionPane.showMessageDialog(null, "ϵͳ��֧�ַ�100Ԫ�������\n ��������������� �� ");
                    money.setText("");
                }
                // ����ǰ��¼�˻��� inMoney �����е��쳣������ת���쳣
            } catch(ClassCastException e1){
                JOptionPane.showMessageDialog(null, "�����������ʹ�������������");
            } catch(Exception e1){
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if("����".equals(e.getActionCommand())){
            // �رմ�Ǯ����
            inframe.dispose();
        }
    }
}
