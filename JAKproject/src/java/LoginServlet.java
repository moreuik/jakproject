/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //work on dopost method
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //accept username and pasword from index.html file
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //database
        try{
            //open connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
            
            //get data from login table using query
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from user where username='"+username+"' and password= '"+password+"'");
            if(rs.next()){
                //if username and password true then go to Home.html file
                response.sendRedirect("Home.html");
            }else{
                //wrong username and password
                out.println("wrong username and password!");
            }
            
            //close connection
            con.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
