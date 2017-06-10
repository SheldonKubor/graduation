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
 * Created by Constantine on 2017/3/19.
 */
@WebServlet("/delete_admin")
public class DeleteAdmin extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
//        String adminName=req.getParameter("del_admin");
//        UserDao.deleteAdmin(adminName);
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html,charset=utf-8");
//        String json= JsonUtil.readJSONData(req);
//        System.out.print(json);
//
//        PrintWriter out=resp.getWriter();
//        //将json字符串转为java对象
//        Gson gson=new Gson();
//        UserBean userBean=gson.fromJson(json,UserBean.class);
//        int resultCode= UserDao.deleteAdmin(userBean);
//        if (resultCode==0){
//            out.print("0");
//        }else {
//            out.print("1");
//        }
        String name=req.getParameter("name");
        UserBean userBean=new UserBean();
        userBean.setUsername(name);
        UserDao.deleteAdmin(userBean);
        List list=UserDao.queryAdminInfo();
        HttpSession session=req.getSession();
        session.setAttribute("allAdmin",list);
        req.setAttribute("allAdmin",list);
        req.getRequestDispatcher("add_admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String adminName=req.getParameter("del_admin");
//        UserDao.deleteAdmin(adminName);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        //将json字符串转为java对象
        Gson gson=new Gson();
        UserBean userBean=gson.fromJson(json,UserBean.class);
        int resultCode= UserDao.deleteAdmin(userBean);
        List list=UserDao.queryAdminInfo();
        HttpSession session=req.getSession();
        session.setAttribute("allAdmin",list);
        req.setAttribute("allAdmin",list);
        if (resultCode==0){
            out.print("0");
        }else {
            out.print("1");
        }
    }
}
