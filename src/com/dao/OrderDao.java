package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Constantine on 2017/6/10.
 */
public class OrderDao {
    public static int addOrder(String username,String myname,String phone,String mail,String address,double price){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        int id=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into order_info (user_name,my_name,phone,mail,address,price) values (?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,myname);
            ps.setString(3,phone);
            ps.setString(4,mail);
            ps.setString(5,address);
            ps.setDouble(6,price);
            resultCode=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getInt(1);
            }
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
        return id;
    }
}
