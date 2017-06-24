import com.dao.ShopCartDao;
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
 * Created by Constantine on 2017/6/5.
 */
@WebServlet("/delete_shopcart")
public class DeleteShopCart extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(req.getParameter("id"));
        ShopCartDao.deleteShopCart(id);
        HttpSession session=req.getSession();

        List<ShopCart> shopCartList= ShopCartDao.queryShopCart((String) session.getAttribute("user"));
        session.setAttribute("shopCart",shopCartList);
        req.setAttribute("shopCart",shopCartList);
        double allprice=0;
        for (ShopCart shopcart: shopCartList) {
            double eachPrice=shopcart.getNumber()*shopcart.getPrice();
            allprice+=eachPrice;
        }
        session.setAttribute("allPrice",allprice);
        req.setAttribute("allPrice",allprice);
        req.getRequestDispatcher("shop_cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
