import com.dao.UserDao;
import com.google.gson.Gson;
import com.model.UserBean;
import com.util.JsonUtil;

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
 * Created by Constantine on 2017/3/25.
 */
@WebServlet("/delete_user")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");

        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        Gson gson=new Gson();
        UserBean userBean=gson.fromJson(json,UserBean.class);
        int resultCode= UserDao.deleteUser(userBean);
        HttpSession session=req.getSession();
        List list=UserDao.queryCusInfo();
        session.setAttribute("allCus",list);
        req.setAttribute("allCus",list);
        if (resultCode == 0) {
            out.print("0");
        } else {
            out.print("1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        UserBean userBean=new UserBean();
        userBean.setUsername(name);
        UserDao.deleteUser(userBean);
        HttpSession session=req.getSession();
        List list=UserDao.queryCusInfo();
        session.setAttribute("allCus",list);
        req.setAttribute("allCus",list);
        req.getRequestDispatcher("delete_user.jsp").forward(req,resp);
    }
}
