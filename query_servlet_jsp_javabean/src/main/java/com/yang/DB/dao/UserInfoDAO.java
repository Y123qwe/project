package com.yang.DB.biz;

import com.yang.DB.DbManager;
import com.yang.DB.vo.UserInfo;

import java.sql.ResultSet;
//数据访问对象
public class UserInfoDAO {
    public int checkUserInfo(UserInfo userInfo){
        int flag=0;
        String strsql="select t_username,t_userpass   from t_user where t_username='"+userInfo.getUserName()+"' and t_pass='"+userInfo.getUserPass()+"'";
        DbManager dbManager=new DbManager();
        try {
            ResultSet resultSet = dbManager.queryMethod(strsql);
            while (resultSet.next()) {
            String  str=    resultSet.getString("t_username");
               String str1= resultSet.getString("t_userpass");
                if (str.equals(userInfo.getUserName()) && str1.equals(userInfo.getUserPass())) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  flag;
    }
}
