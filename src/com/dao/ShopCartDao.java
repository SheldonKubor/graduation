package com.dao;

import com.model.ShopCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/5/20.
 */
public class ShopCartDao {

    public static int deleteShopCart(int id){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try {
            con=GetConnection.getConnection();
            String sql="DELETE FROM  shop_cart WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
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

    public static List<ShopCart> queryShopCart(String username){
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();

        Connection con=null;
        PreparedStatement ps=null;

        try {
            con=GetConnection.getConnection();
            String sql="SELECT  * FROM  shop_cart WHERE username=?";
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

    //添加购物车
    public static int addShopCart(ShopCart shopCart){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into shop_cart (username,bookname,book_num,price) values (?,?,?,?)";
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
    //添加购物车图书数量
    public static int updateShopCartBookNum(int num,String bookname,String username){
        int resultCode=0;
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=GetConnection.getConnection();
            String sql="UPDATE shop_cart SET book_num=book_num+? WHERE bookname=? AND username=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,num);
            ps.setString(2,bookname);
            ps.setString(3,username);
            resultCode=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            }catch (Exception e){

            }
        }
        return resultCode;
    }
    //查询购物车中是否有某一本图书
    public static int queryBookFromCart(String bookname,String username){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try {
            con=GetConnection.getConnection();
            String sql="SELECT count(*) FROM shop_cart WHERE bookname=? AND username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,bookname);
            ps.setString(2,username);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                resultCode=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            }catch (Exception e){

            }
        }
        return resultCode;
    }

    public static ShopCart queryBookByBooknameUsername(String bookname,String username){
        Connection con=null;
        PreparedStatement ps=null;
        ShopCart shopCart=null;
        try {
            con=GetConnection.getConnection();
            String sql="SELECT * FROM shop_cart WHERE bookname=? AND username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,bookname);
            ps.setString(2,username);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                shopCart.setId(rs.getInt(1));
                shopCart.setUsername(rs.getString(2));
                shopCart.setBookname(rs.getString(3));
                shopCart.setNumber(rs.getInt(4));
                shopCart.setPrice(rs.getDouble(5));
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
        return shopCart;
    }

}
