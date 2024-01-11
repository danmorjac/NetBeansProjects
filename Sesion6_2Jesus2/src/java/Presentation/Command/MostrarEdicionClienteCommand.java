/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jjavier
 */
public class MostrarEdicionClienteCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        Cliente _cliente=new Cliente();//Crea un objeto Cliente con el DNI que se solicita
        _cliente.setDNI(Integer.parseInt(request.getParameter("clienteElegido")));

        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente=_clienteBLL.findByDNI(_cliente);
        request.setAttribute("Cliente", _cliente);

        return "/editarCliente.jsp";         
    }       
    
}
