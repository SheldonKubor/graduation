import com.dao.ShopCartDao;
import com.model.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/5/20.
 */
@WebServlet("/add_shopcart")
public class AddShopCart extends HttpServlet {
    List<ShopCart> list=new ArrayList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("utf-8");
        resp.setCharacterEncoding("utf-8");

        HttpSession session=req.getSession();
        String username=(String) session.getAttribute("user");
        String bookname=req.getParameter("bookname");
        String num=req.getParameter("num");

        int bookNum=ShopCartDao.queryBookFromCart(bookname,username);
        if(bookNum != 0){
            ShopCartDao.updateShopCartBookNum(Integer.parseInt(num),bookname,username);
        }else {

            String price = req.getParameter("price");

            ShopCart shopCart = new ShopCart();
            shopCart.setUsername(username);
            shopCart.setBookname(bookname);
            shopCart.setNumber(Integer.valueOf(num));
            shopCart.setPrice(Double.valueOf(price));

            list.add(shopCart);

            session.setAttribute("shopcart", list);

            ShopCartDao.addShopCart(shopCart);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
