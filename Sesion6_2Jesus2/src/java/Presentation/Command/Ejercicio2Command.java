/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BLL.ClienteBLL;
import Entidad.Cliente;

/**
 *
 * @author Usuario
 */
public class Ejercicio2Command extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
                
        Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");
        ClienteBLL _clienteBLL = new ClienteBLL(); 
        Cliente _clienteLista = new Cliente();
        
        try {
            request.removeAttribute("FacturasCliente");
            _clienteLista=_clienteBLL.listadoFacturas(_cliente);
            request.setAttribute("FacturasCliente", _clienteLista);
        } catch (Exception e) {
                
        }
               
        return "/dameFacturas.jsp";       
    }
}
