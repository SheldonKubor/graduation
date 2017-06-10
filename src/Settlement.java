import com.dao.OrderItemDao;
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
@WebServlet("/settlement")
public class Settlement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShopCart> list=new ArrayList<ShopCart>();
        String [] bookname=req.getParameterValues("checked_book");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("user");

        System.out.print(bookname.length);
        System.out.print(username);
        for (int i=0;i<bookname.length;i++){
            System.out.print(bookname[i]);
        }

        for(int i=0;i<bookname.length;i++){
            ShopCart shopCart = ShopCartDao.queryBookByBooknameUsername(bookname[i],username);
            OrderItemDao.addOrderItem(shopCart);
        }

        resp.sendRedirect("order.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
