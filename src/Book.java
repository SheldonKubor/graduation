import com.dao.BookDao;
import com.dao.ClassfiyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/book")
public class Book extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List bookList= BookDao.queryBookInfo();
        System.out.print(bookList.size());
        HttpSession session = req.getSession();
        session.setAttribute("book",bookList);

        List list= ClassfiyDao.queryClassifyInfo();
        session.setAttribute("allClassify",list);

        req.setAttribute("allClassify",list);

        req.getRequestDispatcher("book.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
