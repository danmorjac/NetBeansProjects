/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    new ClienteBLL().insertCliente(
      Integer.parseInt(request.getParameter("DNI")), 
      request.getParameter("Nombre"), 
      request.getParameter("Apellido1"), 
      request.getParameter("Apellido2"), 
      request.getParameter("Nick"), 
      request.getParameter("Password"), 
      Float.parseFloat(request.getParameter("Saldo")), 
      false
    );
    
    return "/registroRealizado.jsp";
  }
  
}
