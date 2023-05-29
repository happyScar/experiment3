package com.zxd.experiment3;

import javax.swing.*;
import java.awt.*;


/**
 * 查询余额界面
 *
 * @author zz
 */
public class Inqury extends JFrame{
	
	// 定义组件
	private JLabel id,balance;
	private JButton ok;
	private Account currentAccount;

	/** 构造查询界面
	 *
	 * @param account 要查询存款的账户
	 */
    public Inqury(Account account){
	    super("查询");

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

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    currentAccount=account;	 
	    
	    id=new JLabel("账号："+currentAccount.id);
	    id.setFont(new Font("黑体",Font.BOLD,25));
	    balance=new JLabel("账户余额："+currentAccount.money);
	    balance.setFont(new Font("黑体",Font.BOLD,25));
	    ok=new JButton("确定");
    	ok.setFont(new Font("黑体",Font.PLAIN,25)); 
	    add(id);
        add(balance);
    	add(ok);

	    // 设置窗体可见
    	setVisible(true);
	    // 设置大小
    	setSize(400, 120);
	    // 居中
    	setLocationRelativeTo(null);
	    // 设置窗体大小固定
    	setResizable(false);
    	
    	ok.addActionListener(e->dispose());
    }	
}

