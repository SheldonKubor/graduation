package com.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Created by Constantine on 2017/3/24.
 */
public class JsonUtil {

    //读取请求传递过来的JSON格式数据，返回JSON字符串

    public static String readJSONData(HttpServletRequest request) {
        StringBuffer json=new StringBuffer();
        String lineString=null;
        try {
            BufferedReader reader=request.getReader();
            while ((lineString=reader.readLine())!=null) {
                json.append(lineString);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }

    //将json字符串转为java对象
}
