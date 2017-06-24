import com.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/5/13.
 */
@WebServlet("/classfiy_search")
public class ClassifySearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String classify=req.getParameter("classify");
        System.out.print(classify);
        List list= BookDao.queryBook(classify);
        HttpSession session=req.getSession();
        session.setAttribute("searchResult",list);
        req.setAttribute("searchResult",list);
        req.getRequestDispatcher("search_result.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
