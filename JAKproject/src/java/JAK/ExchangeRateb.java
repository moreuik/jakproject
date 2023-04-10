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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author HP
 */
@WebServlet(name = "ExchangeRateb", urlPatterns = {"/ExchangeRateb"})
public class ExchangeRateb extends HttpServlet {

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
            out.println("<title>Servlet ExchangeRateb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExchangeRateb at " + request.getContextPath() + "</h1>");
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
        
        out.print("<h1>UPDATING</h1>");
        out.print("<h1>PLEASE WAIT...</h1>"); //maybe insert running animation or something
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
            String loctid="";
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            Statement stmt=con.createStatement();
//            stmt.executeUpdate("ALTER TABLE exchangerate ADD `"+ dtf2.format(now) +"` decimal(65,2);");
            String ratee = "";
            
            PreparedStatement pst = con.prepareStatement("select * from location");
            ResultSet rs =pst.executeQuery();
            
            while(rs.next()){
                String act="";
             act = request.getParameter("rate");
             
             
if (act == null) {
    //no button has been selected
}  else if (act.equals(rs.getString(1))) {
    //update button was pressed
    loctid = rs.getString(1);
} 
            
            }
            
            out.print("<h1>"+loctid+"</h1>");
            
            rs=pst.executeQuery("select * from paytype where (`extloc`='"+loctid+"')");
            
            while(rs.next()){
                
                
                if(request.getParameter(rs.getString(1)).trim()==null || request.getParameter(rs.getString(1)).trim().equals("")){
                    
                }
                
                else if( request.getParameter(rs.getString(1)).trim() != null){
                    ratee = request.getParameter(rs.getString(1)).trim();
                stmt.executeUpdate("update exchangerate set `"+dtf2.format(now)+"`='"+ratee+"' where `paytype`='"+rs.getString(1)+"'");
                stmt.executeUpdate("update paytype set `exchangerate`='"+ratee+"' where `paytypeid`='"+rs.getString(1)+"'");
            }
            
            }
            
            response.sendRedirect("ExchangeRate?loctid="+loctid);
            
            
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
