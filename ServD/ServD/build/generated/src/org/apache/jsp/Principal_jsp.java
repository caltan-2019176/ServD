package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav style=\"background-color: #CBF5F4; display: flex; justify-content: center; align-items: center;\" class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav align-items-center\">\n");
      out.write("                    <style>\n");
      out.write("                        \n");
      out.write("                    </style>\n");
      out.write("                    <a href=\"Controlador?menu=Principal\">\n");
      out.write("                        <img src=\"img/logo2.png\" alt=\"ServD\" width=\"120\" height=\"55\">\n");
      out.write("                    </a>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Empleado&accion=Listar\" target=\"myFrame\">Empleado</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Compra&accion=Listar\" target=\"myFrame\">Compra</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Empresa&accion=Listar\" target=\"myFrame\">Empresa</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Proveedor&accion=Listar\" target=\"myFrame\">Proveedor</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Equipo&accion=Listar\" target=\"myFrame\">Equipo</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=Servicio&accion=Listar\" target=\"myFrame\">Servicio</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=TipoServicio&accion=Listar\" target=\"myFrame\">Tipo Servicio</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=TipoEmpleado&accion=Listar\" target=\"myFrame\">Tipo Empleado</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=MedioTransporte&accion=Listar\" target=\"myFrame\">Medio Transporte</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=ServicioCompra&accion=Listar\" target=\"myFrame\">Servicio Compra</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=ProveedorEquipo&accion=Listar\" target=\"myFrame\">Proveedor Equipo</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=EquipoEmpleado&accion=Listar\" target=\"myFrame\">Equipo Empleado</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a style=\"border: none; color: #32325a; font-size: 16px;\" class=\"btn btn-outline-light\" href=\"Controlador?menu=EmpleadoServicio&accion=Listar\" target=\"myFrame\">Empleado Servicio</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <button style=\"border: none; position: relative; color: #32325a\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getNombresEmpleado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </button>\n");
      out.write("                <div class=\"dropdown-menu text-center\" aria-labelledby=\"dropdownMenuButton\" style=\"transform: translateX(-95px)\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                        <img src=\"img/EmpleadoProv.png\" alt=\"60\" width=\"60\"/>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getUsuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getUsuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("@gmail.com</a>\n");
      out.write("                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <form action=\"Validar\" method=\"POST\">\n");
      out.write("                        <button name=\"accion\" value=\"Salir\" class=\"dropdown-item\">Salir</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"m-4\" style=\"height: 640px\">\n");
      out.write("            <iframe name=\"myFrame\" href=\"HomePage.jsp\" style=\"height: 100%; width: 100%; border: none\"></iframe>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
