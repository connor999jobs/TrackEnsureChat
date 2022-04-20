package com.chat;

import com.userDao.ConnectionToDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ChatRegistration extends HttpServlet {

    public ChatRegistration() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        ConnectionToDatabase database = new ConnectionToDatabase();
        Connection connection = database.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO chatting" +
                    "(Username,password)  Values (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println(ps);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error creating account, please check the details provided.");
        }


    }
}
