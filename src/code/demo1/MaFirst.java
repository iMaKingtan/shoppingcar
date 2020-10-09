package demo1;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("bookname");
        Cookie cookie = new Cookie("car", URLEncoder.encode(name,"utf-8"));
        response.addCookie(cookie);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
