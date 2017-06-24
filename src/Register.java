import com.dao.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Constantine on 2017/3/6.
 */

@WebServlet("/user_register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String qr_password=req.getParameter("qr_password");

        PrintWriter out=resp.getWriter();

        Connection con=null;
        Statement stat=null;
        PreparedStatement ps=null;
        boolean flag=true;
        try{
            con= GetConnection.getConnection();
            String sql="insert into users (username,password,is_admin) values(?,?,?)";
            String sql2="select * from users where username="+"'"+username+"'";

            stat=con.createStatement();
            ResultSet rs=stat.executeQuery(sql2);
            //判断用户名是否重复
            while(rs.next()){
                resp.sendRedirect("back_to_login.jsp");
                flag=false;
                break;
            }
            //若不重复，向数据库新加用户
            while(flag){
                ps=con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setInt(3,0);
                ps.executeUpdate();
                System.out.println("success");
                resp.sendRedirect("back_to_login.jsp");
                break;
            }
            //out.print("register success")
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("exception");
        }finally{
            try {
                ps.close();
                stat.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("exception");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
