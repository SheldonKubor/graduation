import com.model.OrderBean;
import com.model.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/6/10.
 */
@WebServlet("/firm_order")
public class FirmOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");

        double allprice=0;
        HttpSession session=req.getSession();
        String username = (String) session.getAttribute("user");

        List<ShopCart> list = (List<ShopCart>) session.getAttribute("settlementBook");
        req.setAttribute("orderItem",list);
        for (ShopCart shopcart: list) {
            double eachPrice=shopcart.getNumber()*shopcart.getPrice();
            allprice+=eachPrice;
        }

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("mail");
        String address = req.getParameter("address");

        OrderBean orderBean=new OrderBean();
        orderBean.setAddress(address);
        orderBean.setMail(mail);
        orderBean.setName(name);
        orderBean.setPhone(phone);
        orderBean.setPrice(allprice);
       // OrderDao.addOrder(username,name,phone,mail,address,allprice);
        req.setAttribute("order_info",orderBean);
        session.setAttribute("order_info",orderBean);
        req.getRequestDispatcher("firm_order.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
