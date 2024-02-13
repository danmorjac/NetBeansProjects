/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCommand extends ICommand {
  
  private ClienteBLL _clienteBLL = new ClienteBLL();
  
  public void initPage(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    // Solicitar a la BBDD todos los clientes registrados
    request.setAttribute("listadoClientes", _clienteBLL.findAll());
  }

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    Cliente newCli = _clienteBLL.validateCliente(
      request.getParameter("Nick"), 
      request.getParameter("Password")
    );
    
    request.getSession().setAttribute("ClienteSesion", newCli);
    return "/muestraClientes.jsp";
  }
}
