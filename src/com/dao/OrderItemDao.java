package com.dao;

import com.model.ShopCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/6/10.
 */
public class OrderItemDao {
    public static int addOrderItem(ShopCart shopCart,int id){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into order_item (user_name,book_name,book_num,price,order_id) values (?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,shopCart.getUsername());
            ps.setString(2,shopCart.getBookname());
            ps.setInt(3,shopCart.getNumber());
            ps.setDouble(4,shopCart.getPrice());
            ps.setInt(5,id);
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

    public static List<ShopCart> queryOrderItem(String username){
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();

        Connection con=null;
        PreparedStatement ps=null;

        try {
            con=GetConnection.getConnection();
            String sql="SELECT  * FROM  order_item WHERE user_name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);

            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                ShopCart shopCart=new ShopCart();
                shopCart.setId(rs.getInt(1));
                shopCart.setUsername(rs.getString(2));
                shopCart.setBookname(rs.getString(3));
                shopCart.setNumber(rs.getInt(4));
                shopCart.setPrice(rs.getDouble(5));
                shopCartList.add(shopCart);
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

        return shopCartList;
    }
}
