
import Data.DataAccessObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Cart"})
public class ShoppingCartServlet extends HttpServlet {

    DataAccessObject dao = new DataAccessObject();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            dao.emptyArrayList();

            RequestDispatcher dispatcher = request.getRequestDispatcher("HolyShitLetsTryThis.jsp");
            String output = "";

            System.out.println("before trycatch");

            try {

                System.out.println("1*");
                System.out.println(request.getParameter("iPadPro"));
                if (!(request.getParameter("iPadPro").equals(""))) {
                    System.out.println("1");
                    if (Integer.parseInt(request.getParameter("iPadPro")) >= 1) {
                        for (int i = 0; i < Integer.parseInt(request.getParameter("iPadPro")); i++) {
                            dao.addProduct("iPad Pro");
                        }
                    }
                }

                if (!(request.getParameter("iPhone")).equals("")) {
                    System.out.println("2");
                    if (Integer.parseInt(request.getParameter("iPhone")) == 1) {
                        dao.addProduct("iPhone 7");
                    } else if (Integer.parseInt(request.getParameter("iPhone")) > 1) {
                        for (int i = 0; i < Integer.parseInt(request.getParameter("iPhone")); i++) {
                            dao.addProduct("iPhone 7");
                        }
                    }
                }
                if (!(request.getParameter("MacBookPro")).equals("")) {
                    System.out.println("3");
                    if (Integer.parseInt(request.getParameter("MacBookPro")) == 1) {
                        dao.addProduct("MacBook Pro");
                    } else if (Integer.parseInt(request.getParameter("MacBookPro")) > 1) {
                        for (int i = 0; i < Integer.parseInt(request.getParameter("MacBookPro")); i++) {
                            dao.addProduct("MacBook Pro");
                        }
                    }
                }

                if (request.getParameter("iPadPro") != "") {
                    if (Integer.parseInt(request.getParameter("iPadPro")) > 0) {
                        output += (dao.getProduct("iPad Pro").getName() + "............... " + request.getParameter("iPadPro") + "x " + dao.getProduct("iPad Pro").getPrice() +"DKK " + "<br/>");
                    }
                }
                if (request.getParameter("iPhone") != "") {
                    if (Integer.parseInt(request.getParameter("iPhone")) > 0) {
                        output += (dao.getProduct("iPhone 7").getName() + "............... " + request.getParameter("iPhone") + "x " + dao.getProduct("iPhone 7").getPrice() +"DKK" + "<br/>");
                    }
                }
                if (request.getParameter("MacBookPro") != "") {
                    if (Integer.parseInt(request.getParameter("MacBookPro")) > 0) {
                        output += (dao.getProduct("MacBook Pro").getName() + "............... " + request.getParameter("MacBookPro") + "x " + dao.getProduct("MacBook Pro").getPrice() +"DKK" + "<br/>");
                    }
                }
                
                int total = dao.getTotal();
                
                output += ("<br/>" + "<br/>" + "Your total is: " + total + "DKK" );

                
                request.setAttribute("ServletOutput", output);
                dispatcher.forward(request, response);

            } catch (NumberFormatException e) {
                System.out.println("Error");
                response.sendRedirect("Frontpage.html");
            }

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
