/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MostrarEditarClienteCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    int DNI = Integer.parseInt(request.getParameter("clienteElegido"));
    
    Cliente cli = new ClienteBLL().findByDNI(DNI);
    request.setAttribute("Cliente", cli);
    
    return "/editarCliente.jsp";
  }
  
}
