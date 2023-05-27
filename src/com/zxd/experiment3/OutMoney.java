package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Statement;

/*
 * 取款界面
 */

public class OutMoney implements ActionListener{

	/** 定义组件 */
	public JTextField money;
	public JFrame oframe;
	public JPanel op0,op1,op2,op3,op4;
	public JButton confirm,cancel,exit;
	public JLabel id,yue,qu,tishi;
	boolean flag1=false;
	boolean flag2=false;
	private Account currentAccount;

	/**
	 * 构造取款界面
	 *
	 * @param account 要取款的账户
	 */
	public OutMoney(Account account){

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

		oframe=new JFrame("取款");
		oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		op0=new JPanel();
		id=new JLabel("账号："+currentAccount.id);
		id.setFont(new Font("黑体",Font.BOLD,25));
		op0.add(id);
		
		op1=new JPanel();
		yue=new JLabel("账户余额："+currentAccount.money);
		yue.setFont(new Font("黑体",Font.BOLD,25));
		op1.add(yue);
		
		op2=new JPanel();
		qu=new JLabel("取款金额：");
		qu.setFont(new Font("黑体",Font.BOLD,25));
		money=new JTextField(20);
		money.setFont(new Font("黑体",Font.BOLD,25));
		
		op2.add(qu);
		op2.add(money);
		
		op3=new JPanel();  
	    confirm=new JButton("确定");  
	    confirm.setFont(new Font("黑体",Font.PLAIN,25));
	    op3.add(confirm);  
	    cancel=new JButton("返回"); 
        cancel.setFont(new Font("黑体",Font.PLAIN,25));
	    op3.add(cancel);  

	    oframe.add(op0);  
	    oframe.add(op1);  
	    oframe.add(op2); 
	    oframe.add(op3);
	    
	    oframe.setLayout(new FlowLayout());  
	    oframe.setVisible(true);
		// 窗体大小
	    oframe.setSize(450, 200);
		// 在屏幕中间显示(居中显示)
	    oframe.setLocationRelativeTo(null);
	    oframe.setResizable(false);
	      
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			flag1=false;
        	flag2=false;
            try { 
            	int money1=Integer.parseInt(money.getText());
	            // 取款金额为整百的数
            	if(money1%100==0) {
            		flag1=true;
            	}
	            // 取款金额不超过5000
            	if(money1<=5000&&money1>0) {
            		flag2=true;
            	}
            	if(flag1&&flag2) {            		
            		currentAccount.outMoney(Integer.parseInt(money.getText()));
		            Statement statement = new MySqlConnection().getConnection().createStatement();
		            String sql = "UPDATE card_info SET money=money-%s WHERE card_id='%s'";
		            String[] strings = {money.getText(),currentAccount.id};
		            if(statement.executeUpdate(String.format(sql,strings[0],strings[1]))!=0){
			            System.out.println("更新成功");
		            }else {
			            System.out.println("更新失败");
		            }
		            // 弹窗
            		JOptionPane.showMessageDialog(null, "取款成功");
		            // 更新余额显示
            		yue.setText("账户余额:"+currentAccount.money);
		            // 清空文本框
            		money.setText("");
            	}
            	if(!flag1) {
		            // 弹窗
            		JOptionPane.showMessageDialog(null, "系统不支持非100元整钞取款\n 请重新输入取款金额 ！ ");
            		money.setText("");
            	}
            	if(!flag2){
		            // 弹窗
            		JOptionPane.showMessageDialog(null, "系统不支持取款超过5000元\n 请重新输入取款金额 ！ ");
            		money.setText("");
            	}
            	if(money1>currentAccount.money){
		            // 弹窗
            		JOptionPane.showMessageDialog(null, "余额不足，请重新输入取款金额 ！ ");
            		money.setText("");
            	}
            }  
            catch (ClassCastException e1){
	            // 捕获 Test 类中 outMoney 方法的异常
                JOptionPane.showMessageDialog(null, "输入数据类型错误，请输入整数");
            }  
            catch (Exception e1){  
                JOptionPane.showMessageDialog(null, e1.getMessage());  
            }  
        }  
		else if("返回".equals(e.getActionCommand())){
			// 关闭取款界面
			oframe.dispose();
		}
	}
}
