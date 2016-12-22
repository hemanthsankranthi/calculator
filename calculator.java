/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author satish
 */
@WebServlet(urlPatterns = {"/Calculator"})
public class Calculator extends HttpServlet {

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
       String strN1 = "";
        String strN2 = "";
        String strResult = "";
        if (request.getMethod().equalsIgnoreCase("POST")) {
            strN1 = request.getParameter("number1");
            strN2 = request.getParameter("number2");
            String action = request.getParameter("action");
            strResult = "";
            int n1 = Integer.parseInt(strN1);
            int n2 = Integer.parseInt(strN2);
            if (action.equals("Add")) {
                strResult = Integer.toString(n1 + n2);
            } else if (action.equals("Subtract")) {
                strResult = Integer.toString(n1 - n2);
            }
            
        }
        request.setAttribute("n1", strN1);
        request.setAttribute("n2", strN2);
        request.setAttribute("result", strResult);
        
        // forward request and response to the view
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher("/calculator.jsp");
        dispatcher.forward(request, response);
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
