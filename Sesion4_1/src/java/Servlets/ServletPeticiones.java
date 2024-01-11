/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class ServletPeticiones extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Servlet Basico</title></head>");
            out.println("<body>");
            out.println("<b>Las variables enviadas son: </b> <br>");
            // Imprime en pantalla las variables indicadas en la URL            
            java.util.Enumeration _enum=request.getParameterNames();
            String _key="";
            String _value="";
            while (_enum.hasMoreElements()) {
                _key = (String) _enum.nextElement();
                _value =(String) request.getParameter(_key);
                out.println("   " +_key + " = " +_value+"<br>"); 
            }
            out.println("</body></html>");           
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
