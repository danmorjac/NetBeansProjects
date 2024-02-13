
package Presentation.Command;

import BLL.FacturaBLL;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BorrarFacturaCommand extends ICommand  {

  private static FacturaBLL FCT_BLL = new FacturaBLL();

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    String idFactura = request.getParameter("idFactura");
    
    Cliente cli = 
      new FacturaBLL().deleteByIdWithRollback(Integer.parseInt(idFactura));
    
    request.getSession().setAttribute("ClienteSession", cli);
    
    return "/eliminarFacturaRealizado.jsp";
  }
  
}
