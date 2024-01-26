package Servlets;

import DAO.ClienteDAO;
import DAO.ConexionDB;
import Entidad.Cliente;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

public class UsarDataSource extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ConexionDB conexionDB=new ConexionDB();
            Connection _con=conexionDB.AbrirConexionDS();
            ClienteDAO _clienteDAO=new ClienteDAO();
            List<Cliente> _clientes1=_clienteDAO.findByNumberDNIStart(_con, 3);
            out.println("CLIENTES CUYO DNI COMIENZA CON 3");
            out.println("<HR><BR>");
            Cliente _cliente1=null;
            for (int i=0;i<_clientes1.size();i++)
            {
                _cliente1=_clientes1.get(i);
                out.println("Cliente DNI->"+_cliente1.getDNI()+"<BR>");           
                out.println("Cliente nombre->"+_cliente1.getNombre()+"<BR>");   
                out.println("Cliente Primer apellido->"+_cliente1.getApellido1()+"<BR>"); 
                out.println("Cliente Segundo apellido->"+_cliente1.getApellido2()+"<BR>"); 
                out.println("Cliente Nick->"+_cliente1.getNick()+"<BR>"); 
                out.println("Cliente Password->"+_cliente1.getPassword()+"<BR>"); 
                out.println("Cliente Saldo->"+_cliente1.getSaldo()+"<BR>"); 
                out.println("Cliente Moroso->"+_cliente1.isMoroso()+"<BR>");
                out.println("<HR><BR>");
            }   
            conexionDB.CerrarConexion(_con); //Cerramos la conexión */ 
        } catch (Exception ex) {
            ex.printStackTrace();
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
