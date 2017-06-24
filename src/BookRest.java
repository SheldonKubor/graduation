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
@WebServlet("/book_rest")
public class BookRest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        HttpSession session = req.getSession();


        List bookList= BookDao.queryBookInfo();
        session.setAttribute("allRestResult",bookList);

        req.setAttribute("allRestResult",bookList);

        System.out.print(session.getId());
        System.out.print("+++++++++");
        //resp.sendRedirect("rest_book.jsp");

        req.getRequestDispatcher("rest_book.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        String bookname=req.getParameter("book_name");
//        BookInfoBean bookInfoBean=new BookInfoBean();
//        bookInfoBean.setBookName(bookname);
//
//        BookInfoBean resultBean= BookDao.queryOneBook(bookInfoBean);
//
//        HttpSession session = req.getSession();
//        session.setAttribute("bookRestResult",resultBean);
//
//        req.setAttribute("bookRestResult",resultBean);
//        req.getRequestDispatcher("rest_book.jsp").forward(req,resp);
    }
}
