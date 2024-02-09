package Presentation.Command;

import BLL.ArticuloBLL;
import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import Presentation.Command.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaFacturasCommand extends ICommand{
    @Override
    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");
        FacturaBLL _facturaBll = new FacturaBLL();
        ArrayList<Factura> facturas = _facturaBll.getFacturas(_cliente);
        request.setAttribute("facturas", facturas);
        
        return "/listaFacturas.jsp";          
    }
}
