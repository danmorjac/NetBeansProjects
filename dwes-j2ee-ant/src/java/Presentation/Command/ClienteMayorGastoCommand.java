
package Presentation.Command;

import BLL.FacturaBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClienteMayorGastoCommand extends ICommand {

  @Override
  public void initPage(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    Cliente cli = new FacturaBLL().getMayorGasto();
    
    request.getSession().setAttribute("ClienteMayorGasto", cli);
  }

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    return "/clienteMayorGasto.jsp";
  }
  
}
