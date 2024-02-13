/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.ClienteBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarClientesCommand extends ICommand {
  
  @Override
  public void initPage(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    request.setAttribute("listadoClientes", new ClienteBLL().findAll());
  }

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    return "/muestraClientes.jsp";
  }
  
}
