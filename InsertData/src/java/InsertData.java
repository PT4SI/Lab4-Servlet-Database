/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author ckc
 */
public class InsertData extends HttpServlet {

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
            out.println("<title>Servlet InsertData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertData at " + request.getContextPath() + "</h1>");
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String connectionURL = "jdbc:derby://localhost:1527/EmployeeDB";// Connection connection;
try{
String id = request.getParameter("id");
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String bdate = request.getParameter("bd");
String sal = request.getParameter("sal");


Connection conn= DriverManager.getConnection(connectionURL, "root", "root");
PreparedStatement pst = conn.prepareStatement
("insert into EMPLOYEE(ID, FIRSTNAME,LASTNAME, BIRTHDATE,SALARY) " + "values(" + id+ ",'" + fname + "','" + lname + "','" + bdate + "'," + sal + ")");
// Assign the value and store in the PreparedStatement Pst.setString(1, id);
//...
pst.setString(1, id);
pst.setString(2, fname);
pst.setString(3, lname);
pst.setString(4, bdate);
pst.setString(5, sal);

int i = pst.executeUpdate(); if(i!=0){
pw.println("<br>Record has been inserted"); }
else{
pw.println("failed to insert the data");
} }
catch (Exception e){ pw.println(e);
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
