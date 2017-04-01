import com.dao.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型  
        resp.setContentType("text/html");
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        Connection con= null;
        Statement st=null;

        try{
            con= GetConnection.getConnection();
            st=con.createStatement();
            String sql="select * from users where username="+"'"+username+"'";
            ResultSet rs=st.executeQuery(sql);
            /*if(rs.next()==false){
                resp.sendRedirect("user_login_fail.jsp");
            }*/

                if (rs.next()) {
                    if (rs.getString(3).equals(password) && rs.getInt(4) == 0) {
                        //HttpSession session=req.getSession();
                        //session.setAttribute("isLogin","yes");
                        resp.sendRedirect("index.jsp");
                    } else if (rs.getString(3).equals(password) && rs.getInt(4) == 1) {
                        //HttpSession session=req.getSession();
                        //session.setAttribute("isLogin","yes");
                        resp.sendRedirect("admin.jsp");
                    } else {
                        resp.sendRedirect("user_login_fail.jsp");
                    }
                }else {
                    resp.sendRedirect("user_login_fail.jsp");
                }


        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}  