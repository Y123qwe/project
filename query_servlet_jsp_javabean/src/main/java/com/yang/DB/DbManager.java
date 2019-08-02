package com.yang.DB;
import java.sql.*;

public class DbManager {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    String user="root";
    String pass="123456";
    String str="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://127.0.0.1:3306/t_user    ";
    public  Connection getConnection(){
        try {
            Class.forName(str);
            System.out.println("loding success");
            connection=DriverManager.getConnection(url,user,pass);
            System.out.println("connection db success");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }
    //更新和删除
    public  int nonQueryMethod(String strsql){
        int flag=0;
        try {
            connection=this.getConnection();
            statement=connection.createStatement();
            flag=statement.executeUpdate(strsql);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
//查询
    public  ResultSet queryMethod(String strsql){
        connection=this.getConnection();
        try {
            statement=connection.createStatement();
          resultSet=  statement.executeQuery(strsql);
          return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  resultSet;
    }
    public  void closedb(){
        try {
        if (connection!=null)
                connection.close();
        if (statement!=null)
            statement.close();
        if (resultSet!=null)
            resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
