/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package JAK;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author HP
 */
@WebServlet(name = "ProductPriceServlet", urlPatterns = {"/ProductPriceServlet"})
public class ProductPriceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductPriceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductPriceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        
        out.print("<table border=\"3\" width=\"96%\" bgcolor=\"cyan\" height=\"8%\"><tr><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"Home.html\">Home</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"orders.html\">Orders</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"Pricing.html\">Pricing</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"users.html\">Users</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"reports.html\">Reports</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"index.html\">Logout</a></font></th></tr></table>");
        
        out.print("<center><table border=1><tr><th>Available Sites</th></tr>");
        out.print("</table></center>");
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
            int m = 0;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from location");
            while(rs.next()){
                out.print("<center><form action=\"./ProductPrice\">");
                out.print("<table border=1>");
                out.print("<tr><th>");
                out.print("<input type=\"submit\" name=\"site\" ");
                out.print("value=\"");
                out.print(rs.getString(2));
                out.print("\"  ");
                
                
                out.print(" />");
                out.print("</th>");
                out.print("</tr>");
                out.print("</table>");
                out.print("</form></center>");
            }
            
        }catch(ClassNotFoundException | SQLException p){
            System.out.println(p);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
