import com.dao.BookDao;
import com.dao.ClassfiyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/book")
public class Book extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List bookList= BookDao.queryBookInfo();
        System.out.print(bookList.size());
//        HttpSession session = req.getSession();
//        session.setAttribute("book",bookList);

        List list= ClassfiyDao.queryClassifyInfo();
//        session.setAttribute("allClassify",list);

        req.setAttribute("allClassify",list);
        req.setAttribute("book",bookList);
        req.getRequestDispatcher("book.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
