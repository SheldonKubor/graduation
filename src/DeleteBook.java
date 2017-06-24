import com.dao.BookDao;

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
 * Created by Constantine on 2017/3/23.
 */
@WebServlet("/delete_book")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out=resp.getWriter();
        String name = req.getParameter("bookname");
        int resultCode=BookDao.deleteBook(name);
        if(resultCode==0){
            out.print("0");
        }else {
            out.print("1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        BookDao.deleteBook(name);

        List list=BookDao.queryBookInfo();
        HttpSession session = req.getSession();
        session.setAttribute("book",list);
        req.setAttribute("book",list);
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }
}
