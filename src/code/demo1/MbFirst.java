package demo1;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author iMaKingtan
 * @create 2020-10-03 10:47
 */
public class MbFirst extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/HTML;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            ArrayList<String> al = new ArrayList<>();
            for (Cookie cookie:cookies){
                if ("car".equals(cookie.getName())){
                    String name = URLDecoder.decode(cookie.getValue(),"utf-8");
                    al.add(name);
                    System.out.println(name);
                }
            }
            if (al.size()==0){
                writer.print("你的购物车空空如也");
            }else {
                for (String str:al){
                    System.out.println(str);
                    writer.print(str);
                    writer.print("<br>");
                }
            }
        }else {
            writer.print("你的购物车空空如也");
        }



    }
}
