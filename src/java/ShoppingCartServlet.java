
import Data.DataAccessObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Did it work?!?</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> I belive it did! " + "</h1>");

            if (Integer.parseInt(request.getParameter("iMac")) != 0) {

                if (Integer.parseInt(request.getParameter("iMac")) == 1) {
                    dao.addProduct("iMac");
                } else if (Integer.parseInt(request.getParameter("iMac")) > 1) {
                    for (int i = 0; i < Integer.parseInt(request.getParameter("iMac")); i++) {
                        dao.addProduct("iMac");
                    }
                }

            }
            if ((request.getParameter("iPadPro")) != "") {
                if (Integer.parseInt(request.getParameter("iPadPro")) >= 1) {
                    for (int i = 0; i < Integer.parseInt(request.getParameter("iPadPro")); i++) {
                        dao.addProduct("iPad Pro");
                    }
                }
            }
//
//            if (Integer.parseInt(request.getParameter("AppleWatch")) != 0) {
//
//                if (Integer.parseInt(request.getParameter("AppleWatch")) >= 1) {
//                    for (int i = 0; i < Integer.parseInt(request.getParameter("AppleWatch")); i++) {
//                        dao.addProduct("Apple Watch");
//                    }
//
                

                int total = 0;
                total = dao.getTotal();

                if (request.getParameter("iMac") != "") {
                    out.println("<h2>" + " iMac............... " + request.getParameter("iMac") + "x " + dao.getProduct("iMac").getPrice() + " </h2>");
                }
                if (request.getParameter("AppleWatch") != "") {
                    out.println("<h3>" + " Apple Watch............... " + request.getParameter("AppleWatch") + "x " + dao.getProduct("Apple Watch").getPrice() + " </h3>");
                }
                if (request.getParameter("iPadPro") != "") {
                    out.println("<h4>" + " iPad Pro............... " + request.getParameter("iPadPro") + "x " + dao.getProduct("iPad Pro").getPrice() + " </h4>");
                }

                out.println("<h5>" + " Total is: " + total + "</h5>");

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
    
