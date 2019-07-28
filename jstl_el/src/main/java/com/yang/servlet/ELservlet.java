package com.yang.servlet;
import com.yang.servlet.vo.Group;
import com.yang.servlet.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/elServlet")
public class ELservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/htmi;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //测试ET表达式
        //普通字符串测试
        request.setAttribute("strKey","yyy");
        //测试结构体
        Group group=new Group();
        group.setgName("jjj");
        UserInfo userInfo=new UserInfo();
        userInfo.setGroup(group);
        userInfo.setUsername("qqq");
        request.setAttribute("userInfoKey",userInfo);
        //测试字符串数组
        String[] str={"aa","bb","cc","dd"};
        request.setAttribute("strKey",str);
        //测试自定义数组
        UserInfo[] userInfos=new UserInfo[5];
        for (int i = 0; i <userInfos.length ; i++) {
            UserInfo userInfo1=new UserInfo();
            userInfo1.setUsername("1"+i);
            userInfos[i]=userInfo1;
        }
        request.setAttribute("userInfoKey1",userInfos);
        //跳转
        request.getRequestDispatcher("jstl_el.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
