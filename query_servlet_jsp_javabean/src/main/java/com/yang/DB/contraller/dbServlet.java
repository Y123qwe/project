package com.yang.DB.contraller;
import com.yang.DB.model.*;
import com.yang.DB.vo.UserInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //1、获取表单参数
       String username=request.getParameter("username");
       String password=request.getParameter("password");
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(username);
        userInfo.setUserPass(password);
        //2、调用业务逻辑

        IuserInfoService iuserInfoService=new UserInfoServiceImpl();
       int flag= iuserInfoService.checkUserInfoService(userInfo);
        if (flag==1){
            //跳转
            request.setAttribute("userInfoKey",userInfo);
        request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {
request.getRequestDispatcher("false.jsp").forward(request,response);
        }
    }
}
