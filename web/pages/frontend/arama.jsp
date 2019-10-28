<%-- 
    Document   : arama
    Created on : 14.May.2018, 08:09:33
    Author     : haticeozbakir
--%>

<%@ page import="java.io.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Başlıksız Belge</title>
</head>
 
<body>
<form id="form1" name="form1" method="post" action="<b style="color:white;background-color:#880000">arama</b>.<b style="color:black;background-color:#ffff66">jsp</b>">
<p>
<label for="arama_ad">Aranacak Şehir</label>
:
<input type="text" name="arama_ad" id="arama_ad" />
<input type="submit" name="ara" id="ara" value="<b style="color:white;background-color:#880000">Arama</b> Yap" />
</p>
</form>
</body>
</html>

<% request.setCharacterEncoding("UTF-8");
 
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3307/tanitimotel?zeroDateTimeBehavior=convertToNull";
Connection con = null;
 
try {
 
Class.forName(driver);
 
} catch (Exception e) {
 
System.exit(0);
}
try {
con = DriverManager.getConnection(url, "özbakır", "CRAZY1905");
 
} catch (Exception e) {
System.out.println("Mysql Bilgisi : Bağlantı Kurulamadı" + e + "");
System.exit(0);
}
 
%>
<%
request.setCharacterEncoding("UTF-8");
String otel_Adi = request.getParameter("otelAdi");
%>
request.setCharacterEncoding("utf-8");
Statement stmt = con.createStatement();
 
ResultSet rs = stmt.executeQuery("SELECT * FROM otel where otelAdi='" + otel_Adi + "' ;");
<&out.print("<table>");
while (rs.next()) {
out.println("<tr><td>" + rs.getLong("otelID") + "</td>");
out.println("<td>" + rs.getString("otelAdi") + "</td>");
out.println("<td>" + rs.getLong("yildiz") + "</td>");
out.println("<td>" + rs.getString("ortPuan") + "</td>");
out.println("<td>" + rs.getLong("sehirID") + "</td>");}
out.print("</table>");%>