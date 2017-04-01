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
 * Created by Constantine on 2017/3/23.
 */
@WebServlet("/delete_book")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        //将json字符串转为java对象
        Gson gson=new Gson();
        BookInfoBean bookInfoBean=gson.fromJson(json, BookInfoBean.class);

        System.out.print(bookInfoBean.toString());

        String bookName=bookInfoBean.getBookName();
        System.out.print(bookName);

        int resultCode= BookDao.deleteBook(bookName);

        if(resultCode==0){
            out.print("0");
        }else {
            out.print("1");
        }
        //out.print("0");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp);
    }
}
