package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand extends ICommand{
    @Override
    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ClienteBLL _clienteBLL = new ClienteBLL();
        request.setAttribute("listadoClientes", _clienteBLL.listaClientes());    
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{        
        Cliente _cliente=new Cliente();//Crea un objeto Cliente los datos ingresados
        _cliente.setNick(request.getParameter("Nick"));
        _cliente.setPassword(request.getParameter("Password"));
        Cliente admin=new Cliente();

        ClienteBLL _clienteBLL = new ClienteBLL();
        _cliente=_clienteBLL.validaCliente(_cliente);
        request.getSession().setAttribute("ClienteSesion", _cliente);
        return "/muestraClientes.jsp";         
    }       
}
