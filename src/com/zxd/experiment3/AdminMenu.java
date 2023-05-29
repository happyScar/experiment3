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
    /** ������� */
    private JPanel mp1,mp2;
    /** ���� */
    private JButton createCard;
    /** ���� */
    private JButton deleteCard;
    /** �˳� */
    private JButton exit;
    /** �������˻� */
    private Account currentAccount;
    private AdminAccount adminAccount;

    public AdminMenu(AdminAccount account){
        super("ATM�Զ�ȡ���ϵͳ����Աϵͳ");

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

        adminAccount=account;
        // ���ô���Ϊ3*1�����񲼾�
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���尴ť
        createCard=new JButton("����");
        deleteCard=new JButton("����");
        exit=new JButton("�˳�");
        createCard.setFont(new Font("����",Font.BOLD,30));
        deleteCard.setFont(new Font("����",Font.BOLD,30));
        exit.setFont(new Font("����",Font.BOLD,30));
        // ��mp1�������Ϊ�߽粼��
        mp1=new JPanel(new BorderLayout());
        // �����ǩ����ǩ����
        JLabel jlb1=new JLabel("ATMҵ��ѡ��",JLabel.CENTER);
        jlb1.setFont(new Font("����",Font.BOLD,60));
        // ���ñ�ǩ��������ɫΪ��ɫ
        jlb1.setForeground(Color.blue);
        // ����ǩ��ӵ���岼�ֵ��м�λ��
        mp1.add(jlb1,BorderLayout.CENTER);

        mp2=new JPanel();
        mp2.add(createCard);
        mp2.add(deleteCard);
        mp2.add(exit);
        // �������mp2Ϊ3*1�����񲼾�
        mp2.setLayout(new GridLayout(3,1));

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
        createCard.addActionListener(this);
        deleteCard.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // cmd ��ֵΪ����İ�ť�ı�������
        String cmd=e.getActionCommand();
        if("����".equals(cmd)){
            new CreateCard(adminAccount);
        }
        else if("����".equals(cmd)){
            new DeleteCard(adminAccount);
        }else if("�˳�".equals(cmd)){
            // ����
            JOptionPane.showMessageDialog(null,"��ǵ�ȡ���������п�");
            // �رմ���
            dispose();
            // �ٴδ�ѡ����ݽ���
            new Enter();
        }
    }
}
