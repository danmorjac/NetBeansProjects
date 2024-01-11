/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class PrimerServlet extends HttpServlet {
   
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
            out.println("<b>Servlet Name:</b> " + getServletName());
            out.println("<br><b>Protocol: </b>" + request.getProtocol().trim());
            out.println("<br><b>Scheme: </b>" + request.getScheme());
            out.println("<br><b>Server Name: </b>" + request.getServerName());
            out.println("<br><b>Server Port: </b>" + request.getServerPort());
            out.println("<br><b>Server Info: </b>" + getServletContext().getServerInfo());
            out.println("<br><b>Remote Addr: </b>" + request.getRemoteAddr());
            out.println("<br><b>Remote Host: </b>" + request.getRemoteHost());
            out.println("<br><b>Locale: </b>"+ request.getLocale());
            out.println("<br><b>Default Response Buffer: </b>"+ response.getBufferSize());
            out.println("<br><b>Request Is Secure: </b>" + request.isSecure());
            out.println("<br><b>HTTP Method: </b>" + request.getMethod());            
            out.println("<br><b>Request URI: </b>" + request.getRequestURI());
            out.println("<br><b>Context Path: </b>" + request.getContextPath());
            out.println("<br><b>Servlet Path: </b>" + request.getServletPath());
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
