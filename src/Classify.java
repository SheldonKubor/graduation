import com.dao.ClassfiyDao;
import com.model.ClassifyBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/classify")
public class Classify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<ClassifyBean> list = new ArrayList<ClassifyBean>();
        list = ClassfiyDao.queryClassifyInfo();
        System.out.print(list.size());
        HttpSession session = req.getSession();
        session.setAttribute("allClassify",list);
        req.setAttribute("allClassify",list);
        req.getRequestDispatcher("classify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
