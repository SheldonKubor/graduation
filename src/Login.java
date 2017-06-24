import com.dao.BookDao;
import com.dao.ClassfiyDao;
import com.dao.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet("/HelloWorld")
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型  
        resp.setContentType("text/html");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        Connection con= null;
        Statement st=null;

        try{
            con= GetConnection.getConnection();
            st=con.createStatement();
            String sql="select * from users where username="+"'"+username+"'";
            ResultSet rs=st.executeQuery(sql);
                if (rs.next()) {
                    if (rs.getString(3).equals(password) && rs.getInt(4) == 0) {
                        session.setAttribute("user",username);
                        List classifyList = ClassfiyDao.queryClassifyInfo();

                        List topBook= BookDao.queryTopBookInfo();

                        session.setAttribute("topBook",topBook);

                        session.setAttribute("allClassify",classifyList);

                        req.setAttribute("topBook",topBook);
                        req.setAttribute("allClassify",classifyList);
                        System.out.print(session.getAttribute("user"));
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                    } else if (rs.getString(3).equals(password) && rs.getInt(4) == 1) {
                        session.setAttribute("admin",username);
                        System.out.print(session.getAttribute("admin"));
                        req.getRequestDispatcher("admin.jsp").forward(req,resp);
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