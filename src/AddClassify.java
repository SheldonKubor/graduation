import com.dao.ClassfiyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/add_classify")
public class AddClassify extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name=req.getParameter("classifyName");
        PrintWriter out=resp.getWriter();
        int resultCode = ClassfiyDao.addClassify(name);
        if (resultCode == 0) {
            out.print("0");
        } else {
            out.print("1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
