import com.dao.BookDao;
import com.dao.ClassfiyDao;
import com.model.BookInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/6/7.
 */
@WebServlet("/book_id")
public class BookId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        BookInfoBean bookInfoBean= BookDao.queryOneBook(id);
        List list= ClassfiyDao.queryClassifyInfo();
        req.setAttribute("classify",list);
        req.setAttribute("bookid",bookInfoBean);
        req.getRequestDispatcher("update_book.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
