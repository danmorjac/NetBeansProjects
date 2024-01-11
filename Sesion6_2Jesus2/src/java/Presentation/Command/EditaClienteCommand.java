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
public class EditaClienteCommand extends ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
        Cliente _cliente=new Cliente();//Crea un objeto Cliente los datos ingresados
        _cliente.setNick(request.getParameter("Nick"));
        _cliente.setPassword(request.getParameter("Password"));
        _cliente.setApellido1(request.getParameter("Apellido1"));
        _cliente.setApellido2(request.getParameter("Apellido2"));
        _cliente.setNombre(request.getParameter("Nombre"));
    
        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente = _clienteBLL.editaCliente(_cliente);
        return "/edicionRealizada.jsp";            
    }    
}
