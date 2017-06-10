import com.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Constantine on 2017/6/10.
 */
@WebServlet("/add_order")
public class AddOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("mail");
        String address = req.getParameter("address");
        String username = (String) session.getAttribute("user");
        double price=(Double) session.getAttribute("allPrice");
        OrderDao.addOrder(username,name,phone,mail,address,price);
        req.getRequestDispatcher("firm_order").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
