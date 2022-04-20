package com.chat;

import com.userDao.ConnectionToDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Chat extends HttpServlet {

    public Chat() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            ConnectionToDatabase database = new ConnectionToDatabase();
            Connection connection = database.getConnection();
            response.setContentType("text/html");
            Statement statement = connection.createStatement();
            String username = request.getParameter("uname");
            System.out.println(username);
            String password = request.getParameter("pw");
            System.out.println(password);
            String SQLStatement = "select*from chatting where Username='" + username + "' AND password='" + password + "'";

            ResultSet resultSet = statement.executeQuery(SQLStatement);

            if (resultSet.next()) {
                String succesLogin = resultSet.getString("username");
                HttpSession session = request.getSession();
                session.setAttribute("name", succesLogin);
                printWriter.println("Hello, " + succesLogin.toUpperCase());
                printWriter.println("<a href='startchat.jsp'>Welcome to our chat</a>");
                printWriter.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");
            } else {
                printWriter.println("Incorrect UserName or Password");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Invalid User");
        }
    }
}