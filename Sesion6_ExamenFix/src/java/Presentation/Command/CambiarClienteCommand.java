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
 * @author ivane
 */
public class CambiarClienteCommand extends ICommand{
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
        try {
            Cliente _cliente = new Cliente();   
            ClienteBLL clienteBLL = new ClienteBLL();

            _cliente.setDNI(Integer.parseInt(request.getParameter("DNI")));
            _cliente.setNombre(request.getParameter("Nombre"));
            _cliente.setApellido1(request.getParameter("Apellido1"));
            _cliente.setApellido2(request.getParameter("Apellido2"));
            _cliente.setNick(request.getParameter("Nick"));
            _cliente.setPassword(request.getParameter("Password"));
            _cliente.setSaldo(Float.parseFloat(request.getParameter("Saldo")));

            clienteBLL.modificarCliente(_cliente);
            
        } catch (Exception e) {
        }
      return "/clienteModificado.jsp"; 

    }
    
}
