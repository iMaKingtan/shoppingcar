package demo1;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author iMaKingtan
 * @create 2020-10-02 11:13
 */
public class MaFirst extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/HTML;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("username")){
                    username = URLDecoder.decode(cookie.getValue(),"utf-8");

                }else if (cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }
        }
        if (username!=null&&password!=null){
            System.out.println("登录成功,用户名"+username);
        }else {
            System.out.println("登录失败");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
