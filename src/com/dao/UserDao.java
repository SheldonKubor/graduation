package com.dao;

import com.model.UserBean;

import java.sql.*;

/**
 * Created by Constantine on 2017/2/28.
 */
public class UserDao {
    //添加用户
    public static int addUser(UserBean userBean){

        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try {
            con=GetConnection.getConnection();
            String sql="insert into users (username,password) values (?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,userBean.getUsername());
            ps.setString(2,userBean.getPassword());
            resultCode = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultCode;

    }
    //管理员删除用户
    public static int deleteUser(UserBean userBean){
        int resultCode=0;
        Connection con=null;
        PreparedStatement ps=null;
        try{
            con=GetConnection.getConnection();
            String sql = "DELETE FROM users WHERE username=? AND is_admin=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,userBean.getUsername());
            ps.setInt(2,0);
            resultCode=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultCode;
    }
    //查看密码
    public static String queryPw(UserBean userBean){
        Connection con=null;
        PreparedStatement ps=null;
        String password="";
        try{
            con=GetConnection.getConnection();
            String sql="SELECT password FROM users WHERE username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,userBean.getUsername());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                password=rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return password;
    }
    //查看所有用户
    public UserBean queryUser(){

        UserBean userBean=new UserBean();
        Connection con=null;
        Statement st=null;
        String sql="select * from users";
        try {
            con=GetConnection.getConnection();
            st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBean;
    }
    //添加管理员
    public static int addAdmin(UserBean userBean){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try {
            con=GetConnection.getConnection();
            String sql="insert into users (username,password,is_admin) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,userBean.getUsername());
            ps.setString(2,userBean.getPassword());
            ps.setInt(3,1);
            resultCode=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultCode;
    }
    //删除管理员
    public static int deleteAdmin(UserBean userBean){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="delete from users where username=? AND password=? AND is_admin=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,userBean.getUsername());
            ps.setString(2,userBean.getPassword());
            ps.setInt(2,1);
            resultCode=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                ps.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultCode;
    }

}
