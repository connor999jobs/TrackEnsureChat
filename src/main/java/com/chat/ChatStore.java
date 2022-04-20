package com.chat;

import com.userDao.ConnectionToDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatStore extends HttpServlet {
    public ConnectionToDatabase database;

    public ChatStore() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        ConnectionToDatabase database = new ConnectionToDatabase();
        Connection connection = database.getConnection();

        try {
            response.setContentType("text/html");
            String username = request.getParameter("uname");
            String message = request.getParameter("msg");
            SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("hh:mm:ss a");
            Date localDate = new Date();
            String day = localSimpleDateFormat1.format(localDate);
            String time = localSimpleDateFormat2.format(localDate);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO chatting_data" +
                    "(Username, message,Posted_Date,Posted_Timem)  Values (?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, message);
            ps.setString(3, day);
            ps.setString(4, time);

            ps.executeUpdate();
            System.out.println(ps);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid User");
        }
    }
}















