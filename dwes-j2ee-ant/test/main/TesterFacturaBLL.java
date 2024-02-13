package main;

import BLL.ArticuloBLL;
import BLL.FacturaBLL;
import Entidad.Cliente;
import Entidad.Factura;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class TesterFacturaBLL {

  private static FacturaBLL FCT_BLL = new FacturaBLL();

  public static void main(String[] args) {
    try {
      System.out.println("TesterFacturaBLL");

//    int dni = 33;
//    int idArticuloOG = 6;
//    
//    try {
//      int idFactura = comprar(dni, idArticuloOG);
//      comprarOtroProd(dni, idFactura);
//      comprarMismoProd(dni, idFactura, idArticuloOG);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//      Factura fct = FCT_BLL.findLessById(3);
//      FCT_BLL.getArticulosFactura(fct);
//      System.out.println(fct);
//      System.out.println(FCT_BLL.getPropietarioFactura(3));
//      FCT_BLL.deleteByIdWithRollback(6);

      new ArticuloBLL().insertArticulo(
        "Zapatillas",
        Float.parseFloat("5"),
        Integer.parseInt("5")
     );
    } catch (Exception ex) {
      Logger.getLogger(TesterFacturaBLL.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static int comprar(int dni, int idArticulo) throws Exception {
    int cantidadPedida = 10;

    Factura fct = FCT_BLL.insertFactura(dni);

    int idFactura = fct.getId();

    Cliente cli = FCT_BLL.addArticuloFactura(
      dni, idFactura, idArticulo, cantidadPedida, true
    );
    System.out.println("Articulo comprado");
    System.out.println(cli);

    return idFactura;
  }

  private static void comprarOtroProd(
    int dni, int idFactura
  ) throws Exception {
    int idArticulo = 5;
    int cantidadPedida = 10;

    Cliente cli = FCT_BLL.addArticuloFactura(
      dni, idFactura, idArticulo, cantidadPedida, true
    );
    System.out.println("Nuevo articulo comprado");
    System.out.println(cli);
  }

  private static void comprarMismoProd(
    int dni, int idFactura, int idArticulo
  ) throws Exception {
    int cantidadPedida = 1;

    Cliente cli = FCT_BLL.addArticuloFactura(
      dni, idFactura, idArticulo, cantidadPedida, false
    );
    System.out.println("Nuevo articulo comprado");
    System.out.println(cli);
  }
}
