import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
public
class catalog extends HttpServlet {
 @Override
 protected
  void doGet(HttpServletRequest req,
             HttpServletResponse res) throws ServletException,
      IOException {
    HttpSession ses = req.getSession();
    int itemcount = 0;
    ArrayList cart = (ArrayList)ses.getAttribute("cart");
    if (cart != null) {
      itemcount = cart.size();
    }
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<html><head><title>Shopping cart Example</title></head>");
    out.println("<body><table border=\"0\" width=\"100%\"><tr>");
    out.println("<td valign=\"top\">");
    out.println("<td align=\"left\" valign=\"bottom\" >");
    out.println("<h1>Apress Book store</h1></td></tr></table><hr>");
    out.println("<p>We've " + itemcount + " items in wer cart.</p>");
    out.println("<form action=\"");
    out.println(res.encodeURL("/shopping/cart"));
    out.println("\"method=\"post\">");
    out.println("<table cellspacing=\"5\" cellpadding=\"5\"><tr>");
    out.println("<td align=\"center\"><b>Add to cart</b></td>");
    out.println("<td align=\"center\"></td></tr><tr>");
    out.println("<td align=\"center\">");
    out.println("<input name =\"item\" value =\"Pro type =\"checkbox\" programming\"></td>");
    
    out.println("<td align=\"left\">Item 1:" +
                           "Projava programming</td></tr><tr>");
    out.println("<td align=\"center\">");
    out.println("<input name =\"item\" value =\"Beginning  type =\"checkbox\" objects\"></td>");
    
    out.println("<td align=\"left\">Item 2:" + "Beginning java objects</td></tr><tr>");
    out.println("<td align=\"center\">");
     out.println("<input type=\"checkbox\" name=\"item\" value=\"Professional java server programming\"></td>");
out.println("<td align=\"left\">Item programming</td></tr><tr>"); 
out.println("</table><hr>"); 
out.println("<input type=\"submit\" name=\"btn_submit\" value=\"Add to cart\">"); 
out.println("</form></body></html>"); 
out.close();
  }
}