package com.zxd.experiment3;

/**
 * @author zz
 */
public class Account {
	int money;
	/** �˺��� */
	String id;
	String password;

	/**
	 * ���췽��
	 *
	 * @param id �˺�
	 * @param password ����
	 * @param money ��ʼ�����Ǯ��
	 */
	public Account(String id, String password, String money) {
	    this.id = id;  
	    this.password = password;  
	    this.money=Integer.parseInt(money);  
	}  	  
	
	public void outMoney (int money)throws Exception { 
	    if (money > this.money) { 
	        throw new Exception("����");  
	    }
	    if(money<0){
	        throw new Exception("����ȡ������");  
	    }  
	    this.money -= money;  
	}  	  
	
	public void inMoney(int money)throws Exception {
		if(money<0){
	        throw new Exception("���ܴ��븺��");  
	    } 
		this.money+=money;
    }  	   
	
	public void changePassword(String newPassword)throws Exception{
	    if(newPassword.equals(this.password)) {
	        throw new Exception("ԭ����������벻��һ��");  
	    }  
	    else {
	        if("".equals(newPassword)) {
	            throw new Exception("���벻��Ϊ��");  
	        }  
	    }  
        password=newPassword;  
	}  	  
}
