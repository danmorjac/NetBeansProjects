/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletCicloVida extends HttpServlet {
    int contadorAccesos=0;    
    @Override
    public void init(ServletConfig cfg) throws ServletException
    {
    contadorAccesos=5;
    super.init(cfg);
    }
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
            if (contadorAccesos!=0){             
            out.println("Quedan "+contadorAccesos+" accesos antes de " +
                    "dejar de mostrar este mensaje");          
            contadorAccesos--;
            }
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
