import com.dao.BookDao;
import com.google.gson.Gson;
import com.model.BookInfoBean;
import com.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Constantine on 2017/3/25.
 */
@WebServlet("/update_book")
public class UpdateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        //将json字符串转为java对象
        Gson gson=new Gson();
        BookInfoBean bookInfoBean=gson.fromJson(json, BookInfoBean.class);
        System.out.print(bookInfoBean.toString());
        int resultCode = BookDao.updateBook(bookInfoBean);
        System.out.print(resultCode);

        if (resultCode == 0) {
            out.print("0");
        } else {
            out.print("1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
