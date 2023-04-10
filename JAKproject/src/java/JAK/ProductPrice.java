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
@WebServlet(name = "ProductPrice", urlPatterns = {"/ProductPrice"})
public class ProductPrice extends HttpServlet {

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
            out.println("<title>Servlet ProductPrice</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductPrice at " + request.getContextPath() + "</h1>");
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
        String loct = request.getParameter("site");
        String stat = "Updated";
        
        out.print("<head>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<style>\n" +
".alert {\n" +
"  padding: 20px;\n" +
"  background-color: #00ff00;\n" +
"  color: white;\n" +
"}\n" +
"\n" +
".closebtn {\n" +
"  margin-left: 15px;\n" +
"  color: white;\n" +
"  font-weight: bold;\n" +
"  float: right;\n" +
"  font-size: 22px;\n" +
"  line-height: 20px;\n" +
"  cursor: pointer;\n" +
"  transition: 0.3s;\n" +
"}\n" +
"\n" +
".closebtn:hover {\n" +
"  color: black;\n" +
"}\n" +
"</style>\n" +
"</head>");
        
        out.print("<table border=\"3\" width=\"96%\" bgcolor=\"cyan\" height=\"8%\"><tr><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"Home.html\">Home</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"orders.html\">Orders</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"Pricing.html\">Pricing</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"users.html\">Users</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"reports.html\">Reports</a></font></th><th width=\"16%\"><font color=\"white\" size=\"4\"><a href=\"index.html\">Logout</a></font></th></tr></table>");
       
        out.print("<form action=\"./ProductPriceb\">");
        
        
        
        
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
            String loctid="";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from location where `location`='"+loct+"'");
            if(rs.next()==true){
                loctid = rs.getString(1);
            }
            else{
                loctid=request.getParameter("loctid");
                out.print("<div class=\"alert\">\n" +
"  <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n" +
"   <strong>Update Successful!</strong>\n" +
"</div>");
            }
            
            out.print("<button type=\"submit\" name=\"rate\" value=\""+loctid+"\">Update</button>");
            
            
 //           out.print("<input type=\"submit\" name=\""+ loctid +"\" ");
 //               out.print("value=\"");
//                out.print("Update");
//                out.print("\" > "); 
                
//                out.print("<input type=\"submit\" name=\""+ loctid +"\" ");
 //               out.print("value=\"");
//                out.print("Back");
 //               out.print("\" > ");    
             
 
            out.print("<font color=\"white\" size=\"4\"><a href=\"./ExchangeRateServ\">Back</a></font>");
 
            out.print("<center><table border=1><tr><th>#</th><th>Currency</th><th>Rates</th><th>Update</th></tr>");
            
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from paytype where (`extloc`='"+loctid+"')");
            int m=1;
            while(rs.next()){
                out.print("<>");
                out.print("<tr><td>");
                out.print(m);
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString(3));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString(4));
                out.print("</td>");
                out.print("<td>");
                out.print("<input type=\"text\" name=\""+ rs.getString(1) +"\" value=\" \" /></td></tr>");
                m++;
            }
            
        }catch(ClassNotFoundException | SQLException p){
            System.out.println(p);
        }
        out.print("</table></center>");
        out.print("</form>");
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
