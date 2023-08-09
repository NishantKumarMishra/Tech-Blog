import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public
class shoppingcart extends HttpServlet {
 @Override
 protected void doPost(HttpServletRequest req,
              HttpServletResponse res) throws ServletException,
      IOException {
    HttpSession ses = req.getSession(true);
    int itemcount = 0;
    ArrayList cart = (ArrayList)ses.getAttribute("cart");
    if (cart == null) {
      cart = new ArrayList();
      ses.setAttribute("cart", cart);
    }
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String[] itemselected;
    String itemname;
    itemselected = req.getParameterValues("item");
    if (itemselected != null) {
      for (int i = 0; i < itemselected.length; i++) {
        itemname = itemselected[i];
        cart.add(itemname);
      }
    }
    // print the contents of the cart
    out.println("<html><head><title>Shopping cart contents</title></head>");
    out.println("<body>");
    out.println("<h1>Items currently in wer cart</h1>");
    out.println("<hr>");
    Iterator iterator = cart.iterator();
    while (iterator.hasNext()) {
      out.println("<p>" + iterator.next() + "</p>");
    }
    out.println("<hr><p><a href=\"");
    out.println(res.encodeURL("/shopping/catalog"));
    out.println("\">Back to the shop</a></p>");
    out.close();
  }
}