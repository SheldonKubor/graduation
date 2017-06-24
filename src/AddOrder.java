import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.model.OrderBean;
import com.model.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Constantine on 2017/6/12.
 */
@WebServlet("/add_order")
public class AddOrder extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        HttpSession session=req.getSession();
        String username=(String) session.getAttribute("user");
        OrderBean orderBean=(OrderBean) session.getAttribute("order_info");
        int id=OrderDao.addOrder(username,orderBean.getName(),orderBean.getPhone(),orderBean.getMail(),orderBean.getAddress(),orderBean.getPrice());
        List<ShopCart> list = (List<ShopCart>) session.getAttribute("settlementBook");
        for(int i=0;i<list.size();i++){
            OrderItemDao.addOrderItem(list.get(i),id);
        }
        out.print("<h1>支付成功<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
