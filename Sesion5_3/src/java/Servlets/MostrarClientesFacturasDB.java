package Servlets;

import DAO.ClienteDAO;
import DAO.ConexionDB;
import Entidad.Cliente;
import Entidad.Factura;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class MostrarClientesFacturasDB extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ConexionDB conexionDB=new ConexionDB();
            Connection _con=conexionDB.AbrirConexion();
            ClienteDAO _clienteDAO=new ClienteDAO();
            Cliente _cliente=new Cliente();
            Factura _factura=new Factura();
            _cliente.setDNI(456781);
            _cliente=_clienteDAO.findByDNI(_con, _cliente);
            _cliente=_clienteDAO.getClienteFacturas(_con, _cliente);
            out.println("<H1>CLIENTE</H1>");
            out.println("<HR><BR>");
                out.println("Cliente DNI->"+_cliente.getDNI()+"<BR>");           
                out.println("Cliente nombre->"+_cliente.getNombre()+"<BR>");   
                out.println("Cliente Primer apellido->"+_cliente.getApellido1()+"<BR>"); 
                out.println("Cliente Segundo apellido->"+_cliente.getApellido2()+"<BR>"); 
                out.println("Cliente Nick->"+_cliente.getNick()+"<BR>"); 
                out.println("Cliente Password->"+_cliente.getPassword()+"<BR>"); 
                out.println("Cliente Saldo->"+_cliente.getSaldo()+"<BR>"); 
                out.println("Cliente Moroso->"+_cliente.isMoroso()+"<BR>");
                out.println("<HR><BR>");
            
            for (int i=0;i<_cliente.getFacturas().size();i++)
            {
                _factura=_cliente.getFacturas().get(i);
                out.println("<B>FACTURA</B>-> ID:"+_factura.getIdFactura()+"<BR>");           
                out.println("Fecha: "+formatoFecha(_factura.getFecha())+"<BR>");   
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
    public String formatoFecha(int fecha){
        String year=(""+fecha).substring(0, 4);
        String mes=(""+fecha).substring(4, 6);
        String dia=(""+fecha).substring(6, 8);
        return (dia+"/"+mes+"/"+year);
    }
}
