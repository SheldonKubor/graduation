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
 * Created by Constantine on 2017/5/5.
 */
@WebServlet("/all_book")
public class BookAllSaled extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        String bookname=req.getParameter("bookname");
//        BookInfoBean bookInfoBean=new BookInfoBean();
//        bookInfoBean.setBookName(bookname);
//
//        BookInfoBean resultBean= BookDao.queryOneBook(bookInfoBean);
//
//        HttpSession session = req.getSession();
//        session.setAttribute("bookOneSaledResult",resultBean);
//
//        req.setAttribute("bookOneSaledResult",resultBean);
//        req.getRequestDispatcher("rest_book.jsp").forward(req,resp);
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        List bookList= BookDao.queryBookInfo();

        HttpSession session = req.getSession();
        session.setAttribute("bookSaledResult",bookList);
        req.setAttribute("bookSaledResult",bookList);
        System.out.print(session.getId());
        System.out.print("00000000");
        System.out.print(bookList.toString());

        req.getRequestDispatcher("saled_book.jsp").forward(req,resp);
    }
}
