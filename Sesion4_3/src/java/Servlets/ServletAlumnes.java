/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Entitats.AlumneBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesusmtimoneda
 */
public class ServletAlumnes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList alumnes=new ArrayList();    

    @Override
    public void init(ServletConfig cfg) throws ServletException
    {
    
    AlumneBean alu1=new AlumneBean();
    alu1.setDni("123");
    alu1.setNom("Jesús");
    alu1.setPrimerCognom("Timoneda");
    alu1.setSegonCognom("Timoneda");
    AlumneBean alu2=new AlumneBean();
    alu2.setDni("456");
    alu2.setNom("Cèsar");
    alu2.setPrimerCognom("LLopis");
    alu2.setSegonCognom("Mollà");
    AlumneBean alu3=new AlumneBean();
    alu3.setDni("789");
    alu3.setNom("Moises");
    alu3.setPrimerCognom("Mascuñan");
    alu3.setSegonCognom("Trolero");
    
    alumnes.add(alu1);
    alumnes.add(alu2);
    alumnes.add(alu3);
    
    super.init(cfg);
    }
    
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        String dni=request.getParameter("dni");
        Iterator it =alumnes.iterator();
        
        while (it.hasNext()){
            AlumneBean alumne=(AlumneBean)it.next();
            if (alumne.getDni().equals(dni)){
                request.setAttribute("alumne", alumne);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MostraDadesAlumne.jsp");
                rd.forward(request, response);  
       
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<B>DNI NO ENREGISTRAT</B>.Prova amb 123, 456 &oacute; 789");
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
