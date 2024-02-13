
package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.FacturaBLL;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLineaFacturaCommand extends ICommand {

  private static FacturaBLL FCT_BLL = new FacturaBLL();

  @Override
  public void initPage(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    String idFactura = request.getParameter("idFactura");
    Factura fct;

    if (idFactura == null) {
      Cliente cli = (Cliente) request.getSession()
        .getAttribute("ClienteSesion");

      fct = FCT_BLL.insertFactura(cli.getDNI());
    } else {
      fct = FCT_BLL.findLessById(Integer.parseInt(idFactura));
      FCT_BLL.getArticulosFactura(fct);
    }

    request.setAttribute("FacturaCliente", fct);
    request.setAttribute("listadoArticulos", new ArticuloBLL().findAll());
  }

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    String idArticulo = request.getParameter("productoElegido");
    String cantidad = request.getParameter("cantidad");
    String idFactura = request.getParameter("idFactura");

    if ((idArticulo != null)
      && (cantidad != null)
      && (idFactura != null)) {
      Cliente cli = (Cliente) request.getSession()
        .getAttribute("ClienteSesion");

      int idFCT = Integer.parseInt(idFactura);

      cli = FCT_BLL.removeArticuloFactura(
        cli.getDNI(),
        idFCT,
        Integer.parseInt(idArticulo),
        Integer.parseInt(cantidad)
      );

      Factura fct = FCT_BLL.findLessById(idFCT);
      FCT_BLL.getArticulosFactura(fct);

      request.getSession().setAttribute("ClienteSesion", cli);
      request.setAttribute("FacturaCliente", fct);
    }

    return "/editarFactura.jsp";
  }

}
