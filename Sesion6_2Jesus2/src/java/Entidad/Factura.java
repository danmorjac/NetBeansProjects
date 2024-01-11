/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javax.print.attribute.standard.MediaPrintableArea.MM;

/**
 *
 * @author victor
 */
public class Factura {
private int Id;
private int Fecha;
private List<Articulo> articulos=new ArrayList();

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getFecha() {
        
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

}
