/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
import java.sql.* ;

/**
 *
 * @author ckc
 */
public class DatabaseServlet extends HttpServlet {

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
            out.println("<title>Servlet DatabaseServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatabaseServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
String connectionURL = "jdbc:derby://localhost:1527/EmployeeDB";
response.setContentType("text/html;charset=UTF-8"); 
PrintWriter out = response.getWriter();
	try {
Connection conn = DriverManager.getConnection(connectionURL, "root","root");
String sql = "SELECT * FROM EMPLOYEE"; 
Statement stmt = conn.createStatement(); 
ResultSet rs = stmt.executeQuery(sql); 
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet DatabaseServlet</title>"); 
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet DatabaseServlet at " + request.getContextPath() + "</h1>");
//Display the table format out.println(<table>
while (rs.next()) {
//Display the database record by using tr, td and rs

}
rs.close();
stmt.close(); 
conn.close(); 
out.println("</body>"); 
out.println("</html>");
} catch(SQLException ex) { 
	System.out.println("Connect failed ! ");
}

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
