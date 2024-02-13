/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation.Command;

import BLL.FacturaBLL;
import Entidad.Cliente;
import Entidad.Factura;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListaFacturasCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    Cliente cli = (Cliente) request.getSession()
      .getAttribute("ClienteSesion");
    
    ArrayList<Factura> listaFactura = 
      new FacturaBLL().findLessByClienteDNI(cli.getDNI());
    
    request.setAttribute("facturas", listaFactura);
    
    return "/listaFacturas.jsp";
  }

}
