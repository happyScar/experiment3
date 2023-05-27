package com.zxd.experiment3;

/**
 * @author zz
 */
public class Account {
	int money;
	/** 账号名 */
	String id;
	String password;

	/**
	 * 构造方法
	 *
	 * @param id 账号
	 * @param password 密码
	 * @param money 初始化存款钱数
	 */
	public Account(String id, String password, String money) {
	    this.id = id;  
	    this.password = password;  
	    this.money=Integer.parseInt(money);  
	}  	  
	
	public void outMoney (int money)throws Exception { 
	    if (money > this.money) { 
	        throw new Exception("余额不足");  
	    }
	    if(money<0){
	        throw new Exception("不能取出负数");  
	    }  
	    this.money -= money;  
	}  	  
	
	public void inMoney(int money)throws Exception {
		if(money<0){
	        throw new Exception("不能存入负数");  
	    } 
		this.money+=money;
    }  	   
	
	public void changePassword(String newPassword)throws Exception{
	    if(newPassword.equals(this.password)) {
	        throw new Exception("原密码和新密码不能一样");  
	    }  
	    else {
	        if("".equals(newPassword)) {
	            throw new Exception("密码不能为空");  
	        }  
	    }  
        password=newPassword;  
	}  	  
}
