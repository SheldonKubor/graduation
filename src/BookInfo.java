import com.dao.BookDao;
import com.model.BookInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Constantine on 2017/6/5.
 */
@WebServlet("/bookinfo")
public class BookInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String bookname=req.getParameter("bookname");
        BookInfoBean bookInfoBean=new BookInfoBean();
        bookInfoBean.setBookName(bookname);

        BookInfoBean bi = BookDao.queryOneBook(bookInfoBean);
        HttpSession session=req.getSession();
        session.setAttribute("onebook",bi);

        req.setAttribute("onebook",bi);

        req.getRequestDispatcher("book_info.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
