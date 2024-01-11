<%-- 
    Document   : mapa
    Created on : 10-mar-2014, 15:50:17
    Author     : Usuario
--%>

<!DOCTYPE HTML PUBLIC " *W3C*DTD HTML 4.01//EN"
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Mapa Google</title>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;hl=es&amp;key=ABQIAAAA30JtKUU8se-7KKPRGSfCMBT2yXp_ZAY8_ufC3CFXhHIE1NvwkxRZNdns2BwZvEY-V68DvlyUYwi1-Q" type="text/javascript"></script>
<script type="text/javascript">
function load() {
  if (GBrowserIsCompatible()) {
    var lati = 39.45481540915281;
    var long = -0.39553247011417625;  
    var zoom = 15;
    var mapa = new GMap2(document.getElementById("mapa"));
    mapa.setCenter(new GLatLng(lati, long), zoom);
  }
}</script>

</head>
<body onload="load()" onunload="GUnload()">
  <div id="mapa" style="width: 500px; height: 400px"></div>
</body>
</html>
