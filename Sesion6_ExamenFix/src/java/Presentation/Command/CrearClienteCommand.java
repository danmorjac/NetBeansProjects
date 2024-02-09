
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw-a
 */
public class CrearClienteCommand extends ICommand {
    @Override
     public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{  
        
        Cliente _cliente=new Cliente();
        
        _cliente.setDNI(Integer.parseInt(request.getParameter("DNI")));
        _cliente.setNombre(request.getParameter("Nombre"));
        _cliente.setApellido1(request.getParameter("Apellido1"));
        _cliente.setApellido2(request.getParameter("Apellido2"));
        _cliente.setNick(request.getParameter("Nick"));
        _cliente.setPassword(request.getParameter("Password"));
        _cliente.setSaldo(Float.parseFloat(request.getParameter("Saldo")));
        
        ClienteBLL _clienteBLL = new ClienteBLL();
        _clienteBLL.crearUsuario(_cliente);
        
        return "/registroFinalizado.jsp";         
    }      
}