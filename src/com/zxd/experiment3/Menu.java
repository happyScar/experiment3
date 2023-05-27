package com.zxd.experiment3;
import javax.swing.*; 
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;
/*
 *���������� 
 */

public class Menu extends JFrame implements ActionListener {
	/** ������� */
	private JPanel mp1,mp2;
	/** ��ѯ */
	private JButton inqury;
	/** ȡ�� */
	private JButton outmoney;
	/** ��� */
	private JButton inmoney;
	/** �������� */
	private JButton changepassword;
	/** �˿� */
	private JButton exit;
	/** �������˻� */
	private Account currentAccount;

	/**
	 * ����˵�����
	 *
	 * @param account �˻�
	 */
	public Menu(Account account){
		super("ATM�Զ�ȡ���ϵͳ");
		currentAccount=account;
		// ���ô���Ϊ3*1�����񲼾�
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���尴ť
		inqury=new JButton("��ѯ");
		outmoney=new JButton("ȡ��");
		inmoney=new JButton("���");
		changepassword=new JButton("��������");
		exit=new JButton("�˿�");
		inqury.setFont(new Font("����",Font.BOLD,30));
		outmoney.setFont(new Font("����",Font.BOLD,30));
    	inmoney.setFont(new Font("����",Font.BOLD,30));
		changepassword.setFont(new Font("����",Font.BOLD,30));
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
		mp2.add(inqury);
		mp2.add(inmoney);
		mp2.add(outmoney);
		mp2.add(changepassword);
		mp2.add(exit);
		// �������mp2Ϊ5*1�����񲼾�
		mp2.setLayout(new GridLayout(5,1));

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
		inqury.addActionListener(this);
		inmoney.addActionListener(this);
		outmoney.addActionListener(this);
		changepassword.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// cmd ��ֵΪ����İ�ť�ı�������
		String cmd=e.getActionCommand();
		if("��ѯ".equals(cmd)){
			new Inqury(currentAccount);
		}
		else if("ȡ��".equals(cmd)){
			new OutMoney(currentAccount);
		}
	    else if("���".equals(cmd)){
			new InMoney(currentAccount);
		}
	    else if("��������".equals(cmd)){
			new ChangePassword(currentAccount);
		}
		else if("�˿�".equals(cmd)){
			// ����
			JOptionPane.showMessageDialog(null,"��ǵ�ȡ���������п�");
			// �رմ���
			dispose();
			// �ٴδ򿪵�¼����
			new Login(currentAccount);
		}
	}
}