import com.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/3/25.
 */
@WebServlet("/add_book_num")
public class AddBookNum extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");

        int num=Integer.parseInt(req.getParameter("number"));
        int id=Integer.parseInt(req.getParameter("id"));
        BookDao.addBookNum(num,id);
        List bookList= BookDao.queryBookInfo();
        req.setAttribute("allRestResult",bookList);
        req.getRequestDispatcher("rest_book.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req, resp);
    }
}
