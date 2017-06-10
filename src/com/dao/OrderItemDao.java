package com.dao;

import com.model.ShopCart;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Constantine on 2017/6/10.
 */
public class OrderItemDao {
    public static int addOrderItem(ShopCart shopCart){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into order_item (username,bookname,book_num,price) values (?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,shopCart.getUsername());
            ps.setString(2,shopCart.getBookname());
            ps.setInt(3,shopCart.getNumber());
            ps.setDouble(4,shopCart.getPrice());

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
