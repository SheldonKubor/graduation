package com.dao;

import com.model.ClassifyBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/5/24.
 */
public class ClassfiyDao {

    public static List<ClassifyBean> queryClassifyInfo(){
        List<ClassifyBean> classifyBeanList=new ArrayList<ClassifyBean>();
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=GetConnection.getConnection();
            String sql="SELECT  * FROM  classify";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                ClassifyBean classifyBean=new ClassifyBean();
                classifyBean.setId(rs.getInt(1));
                classifyBean.setName(rs.getString(2));
                classifyBeanList.add(classifyBean);
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

        return classifyBeanList;
    }

    public static int addClassify(String name){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="insert into classify(name) values (?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,name);

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
    public static int deleteClassify(String name){
        Connection con=null;
        PreparedStatement ps=null;
        int resultCode=0;
        try{
            con=GetConnection.getConnection();
            String sql="DELETE FROM classify WHERE name=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,name);

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
