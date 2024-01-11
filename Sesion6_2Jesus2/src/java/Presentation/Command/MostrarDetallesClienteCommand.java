package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarDetallesClienteCommand extends ICommand{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        Cliente _cliente=new Cliente();//Crea un objeto Cliente con el DNI que se solicita
        _cliente.setDNI(Integer.parseInt(request.getParameter("clienteElegido")));

        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente=_clienteBLL.findByDNI(_cliente);
        request.setAttribute("Cliente", _cliente);

        return "/muestraDetallesCliente.jsp";         
    }       
}
