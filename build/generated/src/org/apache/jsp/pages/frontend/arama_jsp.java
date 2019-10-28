package org.apache.jsp.pages.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.sql.*;

public final class arama_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>Başlıksız Belge</title>\n");
      out.write("</head>\n");
      out.write(" \n");
      out.write("<body>\n");
      out.write("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"<b style=\"color:white;background-color:#880000\">arama</b>.<b style=\"color:black;background-color:#ffff66\">jsp</b>\">\n");
      out.write("<p>\n");
      out.write("<label for=\"arama_ad\">Aranacak Şehir</label>\n");
      out.write(":\n");
      out.write("<input type=\"text\" name=\"arama_ad\" id=\"arama_ad\" />\n");
      out.write("<input type=\"submit\" name=\"ara\" id=\"ara\" value=\"<b style=\"color:white;background-color:#880000\">Arama</b> Yap\" />\n");
      out.write("</p>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
 request.setCharacterEncoding("UTF-8");
 
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
 

      out.write('\n');

request.setCharacterEncoding("UTF-8");
String otel_Adi = request.getParameter("otelAdi");

      out.write("\n");
      out.write("request.setCharacterEncoding(\"utf-8\");\n");
      out.write("Statement stmt = con.createStatement();\n");
      out.write(" \n");
      out.write("ResultSet rs = stmt.executeQuery(\"SELECT * FROM otel where otelAdi='\" + otel_Adi + \"' ;\");\n");
      out.write("<&out.print(\"<table>\");\n");
      out.write("while (rs.next()) {\n");
      out.write("out.println(\"<tr><td>\" + rs.getLong(\"otelID\") + \"</td>\");\n");
      out.write("out.println(\"<td>\" + rs.getString(\"otelAdi\") + \"</td>\");\n");
      out.write("out.println(\"<td>\" + rs.getLong(\"yildiz\") + \"</td>\");\n");
      out.write("out.println(\"<td>\" + rs.getString(\"ortPuan\") + \"</td>\");\n");
      out.write("out.println(\"<td>\" + rs.getLong(\"sehirID\") + \"</td>\");}\n");
      out.write("out.print(\"</table>\");%>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
