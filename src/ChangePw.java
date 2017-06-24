import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Constantine on 2017/6/12.
 */
@WebServlet("/change_pw")
public class ChangePw extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username=req.getParameter("username");
        String oldPw=req.getParameter("old_pw");
        String newPw=req.getParameter("new_pw");
        System.out.print(username+oldPw+newPw);
        int resultCode=0;
        PrintWriter out=resp.getWriter();

        String password= UserDao.queryPw(username);
        if(password.equals(oldPw)){
            resultCode=UserDao.updatePw(username,newPw);
            out.print(resultCode);
        }else {
            out.print(resultCode);
        }

    }
}
