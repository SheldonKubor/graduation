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
 * Created by Constantine on 2017/3/19.
 */
@WebServlet("/add_book")
public class AddBook extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String json= JsonUtil.readJSONData(req);
        System.out.print(json);

        PrintWriter out=resp.getWriter();
        //将json字符串转为java对象
        Gson gson=new Gson();
        BookInfoBean bookInfoBean=gson.fromJson(json, BookInfoBean.class);
        System.out.print(bookInfoBean.toString());
        //String bookName = req.getParameter("book_name");
        //String author = req.getParameter("author");
        //String classify = req.getParameter("classify");
        // String outPriceStr = req.getParameter("sale_price");
        //String inPriceStr = req.getParameter("in_price");

        //double outPrice = Double.valueOf(outPriceStr);
        //double inPrice = Double.valueOf(inPriceStr);

        int resultCode = BookDao.addBook(bookInfoBean);

        System.out.println(resultCode);
        //System.out.print(bookName+author);

        //PrintWriter out = resp.getWriter();

        if (resultCode == 0) {
            out.print("0");
        } else {
            out.print("1");
        }
    }
}
