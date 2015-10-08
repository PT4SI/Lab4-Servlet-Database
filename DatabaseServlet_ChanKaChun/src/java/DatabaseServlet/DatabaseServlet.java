
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
import java.sql.* ;
public class DatabaseServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String connectionURL = "jdbc:derby://localhost:1527/EmployeeDB";
response.setContentType("text/html;charset=UTF-8"); PrintWriter out = response.getWriter();
try {
Connection conn = DriverManager.getConnection(connectionURL, "root","root");
String sql = "SELECT * FROM EMPLOYEE"; 
Statement stmt = conn.createStatement(); 
ResultSet rs = stmt.executeQuery(sql); 
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet DatabaseServlet</title>"); out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet DatabaseServlet at " + request.getContextPath()
+ "</h1>");
//Display the table format out.println(<table> ...
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

} }