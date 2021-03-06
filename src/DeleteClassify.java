import com.dao.ClassfiyDao;

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
 * Created by Constantine on 2017/6/2.
 */
@WebServlet("/delete_classify")
public class DeleteClassify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");

        int resultCode= ClassfiyDao.deleteClassify(name);

        List list = ClassfiyDao.queryClassifyInfo();
        HttpSession session=req.getSession();
        session.setAttribute("allClassify",list);
        req.setAttribute("allClassify",list);

        req.getRequestDispatcher("classify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");
        PrintWriter out=resp.getWriter();
        int resultCode= ClassfiyDao.deleteClassify(name);
        if(resultCode==0){
            out.print("0");
        }else {
            out.print("1");
        }
    }
}
