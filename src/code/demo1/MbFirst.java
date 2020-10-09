package demo1;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;
import java.util.concurrent.TimeUnit;

/**
 * @author iMaKingtan
 * @create 2020-10-03 10:47
 */
public class MbFirst extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/HTML;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        String tenday = null;

        username = request.getParameter("username");
        password = request.getParameter("password");
        tenday = request.getParameter("tenday");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tract?useSSL=false&serverTimezone=UTC", "root", "MAKINGTAN");
            String sql = "select * from book where bookname = ? and price = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            rs = statement.executeQuery();
            if (rs.next()){
                flag = true;

            }

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        if (flag==true){
            if ("yes".equals(tenday)){
                String urlUser = URLEncoder.encode(username,"utf-8");
                Cookie cookie1 = new Cookie("username",urlUser );
                Cookie cookie2 = new Cookie("password",password );
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            response.sendRedirect("/servlettest_war/index.html");
        }else {
            response.sendRedirect("/servlettest_war/dir/FirstPar.html");
        }



    }
}
