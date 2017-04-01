import com.dao.UserDao;
import com.google.gson.Gson;
import com.model.UserBean;
import com.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        //将json字符串转为java对象
        Gson gson=new Gson();
        UserBean userBean=gson.fromJson(json,UserBean.class);
        int resultCode= UserDao.deleteAdmin(userBean);
        if (resultCode==0){
            out.print("0");
        }else {
            out.print("1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
