/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Command;

import BLL.ClienteBLL;
import BLL.FacturaBLL;
import Entidad.Cliente;
import Entidad.Factura;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laoyeye
 */
public class BorrarFacturaCommand extends ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     try{
       
        int _idFactura = Integer.parseInt(request.getParameter("idFactura"));
        FacturaBLL _facturaBLL = new FacturaBLL();
        Factura _factura = new Factura();
        _factura.setId(_idFactura);
        _facturaBLL.borrarFactura(_factura);
        
     }catch (Exception e){     
    }
        return "/getFacturas.jsp";       
    }
    
}