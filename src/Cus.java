import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/cus")
public class Cus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List list= UserDao.queryCusInfo();
        HttpSession session=req.getSession();
        session.setAttribute("allCus",list);
        req.setAttribute("allCus",list);
        req.getRequestDispatcher("delete_user.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
