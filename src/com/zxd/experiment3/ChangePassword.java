package com.zxd.experiment3;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 


/**
 * ATM�����������
 *
 * @author zz
 */
public class ChangePassword implements ActionListener {
	
	/** ������� */
	public JPasswordField oldPassword,newPassword,checkPassword;
	public JFrame cframe;
	public JPanel cp0;
	public JPanel cp1;
	public JPanel cp2;
	public JLabel l1,l2,l3;
	public JButton confirm,cancel;
	private Account currentAccount;

	/** ��������������
	 *
	 * @param account Ҫ����������˻�
	 */
	public ChangePassword(Account account){
		cframe=new JFrame("��������");
		cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		cp0=new JPanel();
		l1=new JLabel("ԭ���룺");
		l1.setFont(new Font("����",Font.BOLD,25));
		cp0.add(l1);
		oldPassword=new JPasswordField(20);
		oldPassword.setFont(new Font("����",Font.BOLD,25));
		oldPassword.setEchoChar('*');
		cp0.add(oldPassword);
		
		cp1=new JPanel();
		l2=new JLabel("�����룺");
		l2.setFont(new Font("����",Font.BOLD,25));
		cp1.add(l2);
		newPassword=new JPasswordField(20);
		newPassword.setFont(new Font("����",Font.BOLD,25));
		newPassword.setEchoChar('*');
		cp1.add(newPassword);
		
		cp2=new JPanel();
		l3=new JLabel("�ٴ����������룺");
		l3.setFont(new Font("����",Font.BOLD,25));
		cp2.add(l3);
		checkPassword=new JPasswordField(20);
		checkPassword.setFont(new Font("����",Font.BOLD,25));
		checkPassword.setEchoChar('*');
		cp2.add(checkPassword);
		
		confirm=new JButton("ȷ��");  
		confirm.setFont(new Font("����",Font.PLAIN,25));
	    cancel=new JButton("����"); 
	    cancel.setFont(new Font("����",Font.PLAIN,25));
	    
	    cframe.add(cp0);  
	    cframe.add(cp1);  
	    cframe.add(cp2); 
	    cframe.add(confirm);  
	    cframe.add(cancel);  
	    cframe.setLayout(new FlowLayout());  
	    cframe.setVisible(true);
		// �����С
	    cframe.setSize(550, 250);
		// ����Ļ�м���ʾ(������ʾ)
	    cframe.setLocationRelativeTo(null);
	    cframe.setResizable(false);
	    
	    // ��Ӽ���
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  	
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if("ȷ��".equals(e.getActionCommand())){
			// ԭ����ƥ��
			if (currentAccount.password.equals(new String(oldPassword.getPassword()))) {
                try {
	                // ��������������ͬ
                    if(newPassword.getText().equals(checkPassword.getText())) {
	                    // �������6λ��
                    	if(newPassword.getText().length()>=6) {
                    		currentAccount.changePassword(newPassword.getText());
		                    // ����
                    		JOptionPane.showMessageDialog(null, "��������ɹ�");
		                    // �رո����������
                    		cframe.setVisible(false);
                    }
                    	else {
		                    // ����
                    		JOptionPane.showMessageDialog(null,"���벻������6λ��\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
                    		// ��������
                    		oldPassword.setText("");
        					newPassword.setText("");
        					checkPassword.setText("");
                    	}
                    }  
                    else{
	                    // ����
                        JOptionPane.showMessageDialog(null, "������������벻һ��");
                        // ��������
                        oldPassword.setText("");
    					newPassword.setText("");
    					checkPassword.setText("");
                    }  
                }
                // �����˻����и������뺯�����쳣��������ʾ
             catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage()); 
                    oldPassword.setText("");
					newPassword.setText("");
					checkPassword.setText("");
                }  
            } 
			else { 
                JOptionPane.showMessageDialog(null, "ԭ�������");  
                oldPassword.setText("");
				newPassword.setText("");
				checkPassword.setText("");
            }  
        } 			
		if("����".equals(e.getActionCommand())){
			// �رո����������
			cframe.dispose();
		}
	}
}
