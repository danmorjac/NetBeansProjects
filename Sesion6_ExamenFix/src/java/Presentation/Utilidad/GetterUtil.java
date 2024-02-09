package Presentation.Utilidad;

import javax.servlet.http.HttpServletRequest;
public class GetterUtil {
    private static GetterUtil INSTANCE = null;
    private GetterUtil() {}
 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { INSTANCE = new GetterUtil();}
    }
    public static GetterUtil getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    public String getValue(HttpServletRequest request,String key)
    {
        String _value=(String) request.getAttribute(key);
        if (_value==null) _value="";
        return _value;
    } 
    public int getValueInt(HttpServletRequest request,String key)
    {
        int _value=-1;
        String _valor=(String) request.getAttribute(key);
        if (_valor!=null) _value=Integer.parseInt(_valor);
        return _value;
    } 
}
