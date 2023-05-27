package com.zxd.experiment3;
import javax.swing.*; 
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;
/*
 *操作主界面 
 */

public class Menu extends JFrame implements ActionListener {
	/** 定义面板 */
	private JPanel mp1,mp2;
	/** 查询 */
	private JButton inqury;
	/** 取款 */
	private JButton outmoney;
	/** 存款 */
	private JButton inmoney;
	/** 更改密码 */
	private JButton changepassword;
	/** 退卡 */
	private JButton exit;
	/** 操作的账户 */
	private Account currentAccount;

	/**
	 * 构造菜单界面
	 *
	 * @param account 账户
	 */
	public Menu(Account account){
		super("ATM自动取款机系统");
		currentAccount=account;
		// 设置窗体为3*1的网格布局
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 定义按钮
		inqury=new JButton("查询");
		outmoney=new JButton("取款");
		inmoney=new JButton("存款");
		changepassword=new JButton("更改密码");
		exit=new JButton("退卡");
		inqury.setFont(new Font("黑体",Font.BOLD,30));
		outmoney.setFont(new Font("黑体",Font.BOLD,30));
    	inmoney.setFont(new Font("黑体",Font.BOLD,30));
		changepassword.setFont(new Font("黑体",Font.BOLD,30));
		exit.setFont(new Font("黑体",Font.BOLD,30));

		// 将mp1面板设置为边界布局
		mp1=new JPanel(new BorderLayout());
		// 定义标签，标签居中
		JLabel jlb1=new JLabel("ATM业务选择",JLabel.CENTER);
		jlb1.setFont(new Font("黑体",Font.BOLD,60));
		// 设置标签的文字颜色为蓝色
		jlb1.setForeground(Color.blue);
		// 将标签添加到面板布局的中间位置
		mp1.add(jlb1,BorderLayout.CENTER);

		mp2=new JPanel();
		mp2.add(inqury);
		mp2.add(inmoney);
		mp2.add(outmoney);
		mp2.add(changepassword);
		mp2.add(exit);
		// 设置面板mp2为5*1的网格布局
		mp2.setLayout(new GridLayout(5,1));

		add(mp1);
		add(mp2);
		// 设置可见
		setVisible(true);
		// 设置大小
		setSize(800, 600);
		// 居中
		setLocationRelativeTo(null);
		//设置窗体大小固定
		setResizable(false);


		// 绑定监听器
		inqury.addActionListener(this);
		inmoney.addActionListener(this);
		outmoney.addActionListener(this);
		changepassword.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// cmd 赋值为点击的按钮的标题文字
		String cmd=e.getActionCommand();
		if("查询".equals(cmd)){
			new Inqury(currentAccount);
		}
		else if("取款".equals(cmd)){
			new OutMoney(currentAccount);
		}
	    else if("存款".equals(cmd)){
			new InMoney(currentAccount);
		}
	    else if("更改密码".equals(cmd)){
			new ChangePassword(currentAccount);
		}
		else if("退卡".equals(cmd)){
			// 弹窗
			JOptionPane.showMessageDialog(null,"请记得取走您的银行卡");
			// 关闭窗体
			dispose();
			// 再次打开登录界面
			new Login(currentAccount);
		}
	}
}