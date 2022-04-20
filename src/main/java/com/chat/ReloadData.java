package com.chat;

import com.userDao.ConnectionToDatabase;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReloadData  extends HttpServlet{
    public ReloadData() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ConnectionToDatabase database = new ConnectionToDatabase();
        Connection connection = database.getConnection();

        try {
            response.setContentType("text/html");
            String SQLStatement = "select*from chatting_data";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            while (resultSet.next()){
                String str1 = resultSet.getString(1); //
                String str2 = resultSet.getString(2);
                String str3 = resultSet.getString(3);
                String str4 = resultSet.getString(4);
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<p>" + str1 + "-<g>" + str2 + "</g><br><small>" + str3 + " " + str4 + "</small></p>");
            }
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }

    }
}
