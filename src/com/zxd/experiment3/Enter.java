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
    /** ������� */
    private JPanel mp1,mp2;
    /** ����Ա */
    private JButton administrator;
    /** ��ͨ�û� */
    private JButton user;
    public Enter(){
        // �������
        super("ѡ����ݵ�¼");

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
        // ���ô���Ϊ3*1�����񲼾�
        setLayout(new GridLayout(3,1));
        // ���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ���尴ť
        administrator=new JButton("����Ա���");
        user=new JButton("��ͨ�û�");

        // ��mp1�������Ϊ�߽粼��
        mp1=new JPanel(new BorderLayout());
        // �����ǩ����ǩ����
        JLabel jlb1=new JLabel("ATM��¼���ѡ��",JLabel.CENTER);
        jlb1.setFont(new Font("����",Font.BOLD,60));
        // ���ñ�ǩ��������ɫΪ��ɫ
        jlb1.setForeground(Color.blue);
        // ����ǩ��ӵ���岼�ֵ��м�λ��
        mp1.add(jlb1,BorderLayout.CENTER);

        mp2=new JPanel();
        mp2.add(administrator);
        mp2.add(user);
        // �������mp2Ϊ2*1�����񲼾�
        mp2.setLayout(new GridLayout(2,1));

        add(mp1);
        add(mp2);
        // ���ÿɼ�
        setVisible(true);
        // ���ô�С
        setSize(800, 600);
        // ����
        setLocationRelativeTo(null);
        //���ô����С�̶�
        setResizable(false);

        // �󶨼�����
        administrator.addActionListener(this);
        user.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        if("����Ա���".equals(str)){
            new AdminLogin();
        }else if("��ͨ�û�".equals(str)){
            new Login();
        }
    }
}
