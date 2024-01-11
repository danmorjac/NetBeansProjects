package Entidad.Utilidad;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fechas {
    private static Fechas INSTANCE = null;
    private Fechas() {}
    private synchronized static void createInstance() {
        if (INSTANCE == null) { INSTANCE = new Fechas();}
    }
    public static Fechas getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    public String getTicketFecha() {
        GregorianCalendar calendar = new GregorianCalendar();//Crea la fecha del dia actual
        String year=""+calendar.get(Calendar.YEAR);
        String mes=""+(calendar.get(Calendar.MONTH)+1);
        String dia=""+calendar.get(Calendar.DAY_OF_MONTH);
        String hora=""+calendar.get(Calendar.HOUR_OF_DAY);
        String minuto=""+calendar.get(Calendar.MINUTE);
        String segundos=""+calendar.get(Calendar.SECOND);
        if (mes.length()==1) mes="0"+mes;        
        if (dia.length()==1) dia="0"+dia;
        if (hora.length()==1) hora="0"+hora;
        if (minuto.length()==1) minuto="0"+minuto;
        if (segundos.length()==1) minuto="0"+segundos;
        return year+mes+dia+hora+minuto+segundos;           
    } 
    public int getFechatoInt()  {
        GregorianCalendar calendar = new GregorianCalendar();//Crea la fecha del dia actual
        String year=""+calendar.get(Calendar.YEAR);
        String mes=""+(calendar.get(Calendar.MONTH)+1);
        if (mes.length()==1) mes="0"+mes;
        String dia=""+calendar.get(Calendar.DAY_OF_MONTH);
        if (dia.length()==1) dia="0"+dia;
        int fecha=Integer.parseInt(year+mes+dia);
        return fecha;
    }
}
