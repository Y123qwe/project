package com.yang.DB.model;
import com.yang.DB.dao;
import com.yang.DB.vo.UserInfo;

public class UserInfoServiceImpl  implements IuserInfoService{
    private UserInfoDAO userInfoDAO= new UserInfoDAO();
    public int checkUserInfoService(UserInfo userInfo) {
       return userInfoDAO.checkUserInfo(userInfo);
    }
}
