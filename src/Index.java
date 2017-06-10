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
 * Created by Constantine on 2017/6/3.
 */
@WebServlet("/index_info")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        List classifyList = ClassfiyDao.queryClassifyInfo();

        List topBook= BookDao.queryTopBookInfo();

        session.setAttribute("topBook",topBook);

        session.setAttribute("allClassify",classifyList);

        req.setAttribute("topBook",topBook);
        req.setAttribute("allClassify",classifyList);



        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
