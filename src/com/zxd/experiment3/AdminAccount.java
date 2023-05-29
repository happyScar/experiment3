package com.zxd.experiment3;

/**
 * @author scarborough
 * @creat 2023/5/29 - 10:47
 */
public class AdminAccount {
    public String id;
    public String password;

    public AdminAccount(String id, String password){
        this.id = id;
        this.password = password;
    }

    public void createCard(String cardId,String password,int money) throws Exception{
        if(money<0){
            throw new Exception("不能存入负数");
        }
        if(money%100!=0){
            throw new Exception("不支持非整百存入");
        }
    }
}
