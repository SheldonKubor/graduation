import com.dao.BookDao;
import com.model.BookInfoBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Constantine on 2017/3/19.
 */

@WebServlet("/add_book")
public class AddBook extends HttpServlet{

    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
            String url="";
            // 检测是否为多媒体上传
            if (!ServletFileUpload.isMultipartContent(req)) {
                // 如果不是则停止
                PrintWriter writer = resp.getWriter();
                writer.println("Error: 表单必须包含 enctype=multipart/form-data");
                writer.flush();
                return;
            }

            // 配置上传参数
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            // 设置临时存储目录
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

            // 设置最大文件上传值
            upload.setFileSizeMax(MAX_FILE_SIZE);

            // 设置最大请求值 (包含文件和表单数据)
            upload.setSizeMax(MAX_REQUEST_SIZE);

            // 中文处理
            upload.setHeaderEncoding("UTF-8");

            // 构造临时路径来存储上传的文件
            // 这个路径相对当前应用的目录
            //String uploadPath = req.getServletContext().getRealPath("./images_src") + File.separator + UPLOAD_DIRECTORY;

            String uploadPath="D:/intelljWorkstation/graduation/web/images_src";


            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                // 解析请求的内容提取文件数据
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(req);

                Map<String,String> params=new HashMap<String,String>();

                if (formItems != null && formItems.size() > 0) {
                    // 迭代表单数据
                    for (FileItem item : formItems) {

                        // 处理不在表单中的字段
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + "/"+ fileName;

                            url="./images_src/"+fileName;

                            File storeFile = new File(filePath);
                            // 在控制台输出文件的上传路径
                            System.out.println(filePath);
                            // 保存文件到硬盘
                            item.write(storeFile);
                            req.setAttribute("message",
                                    "文件上传成功!");
                        }
                        if(item.isFormField()){
                            String name=item.getFieldName();
                            String value=item.getString("utf-8");

                            System.out.print(name+value);

                            params.put(name,value);
                        }
                    }
                }

                BookInfoBean bookInfoBean=new BookInfoBean();
                bookInfoBean.setImgUrl(url);
                bookInfoBean.setClassify(params.get("classify"));
                bookInfoBean.setContent(params.get("content"));
                bookInfoBean.setAuthor(params.get("author"));
                bookInfoBean.setBookName(params.get("book_name"));
                bookInfoBean.setInPrice(Double.valueOf(params.get("in_price")));
                bookInfoBean.setOutPrice(Double.valueOf(params.get("sale_price")));

                System.out.print(bookInfoBean.toString());

                int resultCode = BookDao.addBook(bookInfoBean);
                HttpSession session=req.getSession();
                List list=BookDao.queryBookInfo();
                session.setAttribute("book",list);
                req.setAttribute("book",list);
                if(resultCode != 0){
                    PrintWriter out=resp.getWriter();
                    out.print("<script>alert('添加成功!')</script>");
                    req.getRequestDispatcher("book.jsp").forward(req,resp);
                }
            } catch (Exception ex) {
                req.setAttribute("message",
                        "错误信息: " + ex.getMessage());
            }
    }
}

