package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;


/**
 * ��ѯ������
 *
 * @author zz
 */
public class Inqury extends JFrame{
	
	// �������
	private JLabel id,balance;
	private JButton ok;
	private Account currentAccount;

	/** �����ѯ����
	 *
	 * @param account Ҫ��ѯ�����˻�
	 */
    public Inqury(Account account){
	    super("��ѯ");

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

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    currentAccount=account;	 
	    
	    id=new JLabel("�˺ţ�"+currentAccount.id);
	    id.setFont(new Font("����",Font.BOLD,25));
	    balance=new JLabel("�˻���"+currentAccount.money);
	    balance.setFont(new Font("����",Font.BOLD,25));
	    ok=new JButton("ȷ��");
    	ok.setFont(new Font("����",Font.PLAIN,25)); 
	    add(id);
        add(balance);
    	add(ok);

	    // ���ô���ɼ�
    	setVisible(true);
	    // ���ô�С
    	setSize(400, 120);
	    // ����
    	setLocationRelativeTo(null);
	    // ���ô����С�̶�
    	setResizable(false);
    	
    	ok.addActionListener(e->dispose());
    }	
}

