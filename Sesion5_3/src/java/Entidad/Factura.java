/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;


public class Factura {
private int idFactura;
private int Cliente_DNI;
private int Fecha;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getCliente_DNI() {
        return Cliente_DNI;
    }

    public void setCliente_DNI(int Cliente_DNI) {
        this.Cliente_DNI = Cliente_DNI;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }
}
