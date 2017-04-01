package com.dao;

import com.model.BookInfoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/3/19.
 */
public class BookDao {
    //新增图书信息
    public static int addBook(BookInfoBean bookInfoBean){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into book_info (book_name,auther,in_price,classify,out_price) values (?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,bookInfoBean.getBookName());
            ps.setString(2,bookInfoBean.getAuthor());
            ps.setDouble(3,bookInfoBean.getInPrice());
            ps.setString(4,bookInfoBean.getClassify());
            ps.setDouble(5,bookInfoBean.getOutPrice());
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
    //删除图书
    public static int deleteBook(String bookname){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="DELETE FROM book_info WHERE book_name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,bookname);
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
            return resultCode;
        }

    }
    //更新图书信息
    public static int updateBook(BookInfoBean bookInfoBean){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try {
            con=GetConnection.getConnection();
            String sql="UPDATE book_info SET auther=?,in_price=?,out_price=?,classify=? WHERE book_name=?";

            ps=con.prepareStatement(sql);
            ps.setString(1,bookInfoBean.getAuthor());
            ps.setDouble(2,bookInfoBean.getInPrice());
            ps.setDouble(3,bookInfoBean.getOutPrice());
            ps.setString(4,bookInfoBean.getClassify());
            ps.setString(5,bookInfoBean.getBookName());
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
    //添加图书数量
    public static int addBookNum(BookInfoBean bookInfoBean){
        int resultCode=0;
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=GetConnection.getConnection();
            String sql="UPDATE book_info SET book_num=book_num+? WHERE book_name=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,bookInfoBean.getBookNum());
            ps.setString(2,bookInfoBean.getBookName());
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
    //查询所有图书信息
    public static List<BookInfoBean> queryBookInfo(){
        List<BookInfoBean> bookInfoBeanList=new ArrayList<BookInfoBean>();

        Connection con=null;
        PreparedStatement ps=null;

        try {
            con=GetConnection.getConnection();
            String sql="SELECT  * FROM  book_info";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                BookInfoBean bookInfoBean=new BookInfoBean();
                bookInfoBean.setId(rs.getInt(1));
                bookInfoBean.setBookName(rs.getString(2));
                bookInfoBean.setAuthor(rs.getString(3));
                bookInfoBean.setInPrice(rs.getDouble(4));
                bookInfoBean.setOutPrice(rs.getDouble(5));
                bookInfoBean.setClassify(rs.getString(6));
                bookInfoBean.setBookNum(rs.getInt(7));
                bookInfoBeanList.add(bookInfoBean);
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

        return bookInfoBeanList;
    }
    //根据书名查询某一本书的信息
    public static BookInfoBean queryOneBook(BookInfoBean bookInfoBean){
        BookInfoBean bookInfo=new BookInfoBean();
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con=GetConnection.getConnection();
            String sql="SELECT * FROM book_info WHERE book_name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,bookInfoBean.getBookName());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                bookInfo.setId(rs.getInt(1));
                bookInfo.setBookName(rs.getString(2));
                bookInfo.setAuthor(rs.getString(3));
                bookInfo.setInPrice(rs.getDouble(4));
                bookInfo.setOutPrice(rs.getDouble(5));
                bookInfo.setClassify(rs.getString(6));
                bookInfo.setBookNum(rs.getInt(7));
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
        return bookInfo;
    }
}
