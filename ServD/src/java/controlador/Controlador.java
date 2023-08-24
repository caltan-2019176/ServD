/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Compra;
import modelo.CompraDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Empleados_has_Servicios;
import modelo.Empleados_has_ServiciosDAO;
import modelo.Empresa;
import modelo.EmpresaDao;
import modelo.Equipo;
import modelo.EquipoDAO;
import modelo.Equipo_has_Empleado;
import modelo.Equipo_has_EmpleadoDAO;
import modelo.MedioTransporte;
import modelo.MedioTransporteDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Proveedor_has_EquipoDAO;
import modelo.Servicio;
import modelo.ServicioDAO;
import modelo.Servicio_has_Compra;
import modelo.Servicio_has_CompraDAO;
import modelo.TipoEmpleado;
import modelo.TipoEmpleadoDAO;
import modelo.TipoServicio;
import modelo.TipoServicioDAO;

/**
 *
 * @author colin
 */
public class Controlador extends HttpServlet {

    MedioTransporte medioTransporte = new MedioTransporte();
    MedioTransporteDAO medioTransporteDAO = new MedioTransporteDAO();
    Equipo equipo = new Equipo();
    EquipoDAO equipoDAO = new EquipoDAO();
    Proveedor_has_EquipoDAO proveedor_has_EquipoDAO = new Proveedor_has_EquipoDAO();
    Proveedor_has_EquipoDAO proveedor_has_EquipoDAO1 = new Proveedor_has_EquipoDAO();
    Servicio_has_Compra servicio_has_Compra = new Servicio_has_Compra();
    Servicio_has_CompraDAO servicio_has_CompraDAO = new Servicio_has_CompraDAO();
    Compra compra = new Compra();
    CompraDAO compraDAO = new CompraDAO();
    Servicio servicio = new Servicio();
    ServicioDAO servicioDAO = new ServicioDAO();
    Equipo_has_Empleado equipo_has_Empleado = new Equipo_has_Empleado();
    Equipo_has_EmpleadoDAO equipo_has_EmpleadoDAO = new Equipo_has_EmpleadoDAO();
    TipoEmpleado tipoEmpleado = new TipoEmpleado();
    TipoEmpleadoDAO tipoEmpleadoDAO = new TipoEmpleadoDAO();
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    Empresa empresa = new Empresa();
    EmpresaDao empresaDao = new EmpresaDao();
    Empleados_has_Servicios empleados_has_servicios = new Empleados_has_Servicios();
    Empleados_has_ServiciosDAO empleados_has_serviciosDAO = new Empleados_has_ServiciosDAO();
    TipoServicio tipoServicio = new TipoServicio();
    TipoServicioDAO tipoServicioDAO = new TipoServicioDAO();
    int codCompra;
    int codTipoServicio;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Equipo")) {
            switch (accion) {
                case "Listar":
                    List listaEquipo = equipoDAO.listar();
                    request.setAttribute("equipos", listaEquipo);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("Equipo.jsp").forward(request, response);
        } else if (menu.equals("ProveedorEquipo")) {
            switch (accion) {
                case "Listar":
                    List listaProveedorEquipo = proveedor_has_EquipoDAO.listar();
                    request.setAttribute("proveedorEquipos", listaProveedorEquipo);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("ProveedorEquipo.jsp").forward(request, response);
        } else if (menu.equals("ServicioCompra")) {
            switch (accion) {
                case "Listar":
                    List listaServicioCompra = servicio_has_CompraDAO.listar();
                    request.setAttribute("servicioCompras", listaServicioCompra);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("ServicioCompra.jsp").forward(request, response);
        } else if (menu.equals("Compra")) {
            switch (accion) {
                case "Listar":
                    List listaCompras = compraDAO.listar();
                    request.setAttribute("compras", listaCompras);
                    break;
                case "Agregar":
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String costo = request.getParameter("txtCostoCompra");
                    String descri = request.getParameter("txtDescripcionCompra");
                    String fecha = request.getParameter("txtFechaCompra");
                    String codEmpre = request.getParameter("txtCodigoEmpresa");
                    try {
                        java.util.Date formato = formatoFecha.parse(fecha);
                        java.sql.Date fechaCompra = new java.sql.Date(formato.getTime());
                        compra.setCostoCompra(Double.parseDouble(costo));
                        compra.setDescripcionCompra(descri);
                        compra.setFechaCompra(fechaCompra);
                        compra.setCodigoEmpresa(Integer.parseInt(codEmpre));
                        compraDAO.agregar(compra);
                        request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Editar":
                    codCompra = Integer.parseInt(request.getParameter("codigoCompra"));
                    Compra c = compraDAO.listarCodigoCompra(codCompra);
                    request.setAttribute("compra", c);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
                    String costoCom = request.getParameter("txtCostoCompra");
                    String descriCom = request.getParameter("txtDescripcionCompra");
                    String fechaCom = request.getParameter("txtFechaCompra");
                    try {
                        java.util.Date formato = fechaFormato.parse(fechaCom);
                        java.sql.Date fechaCompra = new java.sql.Date(formato.getTime());
                        compra.setCostoCompra(Double.parseDouble(costoCom));
                        compra.setDescripcionCompra(descriCom);
                        compra.setFechaCompra(fechaCompra);
                        compra.setCodigoCompra(codCompra);
                        compraDAO.actualizar(compra);
                        request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Eliminar":
                    codCompra = Integer.parseInt(request.getParameter("codigoCompra"));
                    compraDAO.eliminar(codCompra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("Servicio")) {
            switch (accion) {
                case "Listar":
                    List listaServicio = servicioDAO.listar();
                    request.setAttribute("servicios", listaServicio);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("Servicio.jsp").forward(request, response);
        } else if (menu.equals("EquipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List listaEquipoEmpleado = equipo_has_EmpleadoDAO.listar();
                    request.setAttribute("equipoEmpleados", listaEquipoEmpleado);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("EquipoEmpleado.jsp").forward(request, response);

        } else if (menu.equals("TipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List listaTiposEmpleados = tipoEmpleadoDAO.Listar();
                    request.setAttribute("tiposEmpleados", listaTiposEmpleados);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
        } else if (menu.equals("Empleado")) {
            switch (accion) {

                case "Listar":
                    List listaEmpleados = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        } else if (menu.equals("MedioTransporte")) {
            switch (accion) {
                case "Listar":
                    List listaMedioTransporte = medioTransporteDAO.listar();
                    request.setAttribute("medioTransportes", listaMedioTransporte);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("MedioTransporte.jsp").forward(request, response);

        } else if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List listaProveedor = proveedorDao.listar();
                    request.setAttribute("proveedores", listaProveedor);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);

        } else if (menu.equals("Empresa")) {
            switch (accion) {
                case "Listar":
                    List listaEmpresa = empresaDao.listar();
                    request.setAttribute("empresas", listaEmpresa);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("Empresa.jsp").forward(request, response);
        } else if (menu.equals("EmpleadoServicio")) {
            switch (accion) {
                case "Listar":
                    List listaEmpleados_has_Servicios = empleados_has_serviciosDAO.listar();
                    request.setAttribute("empleadoServicios", listaEmpleados_has_Servicios);
                    break;
                case "Agregar":

                    break;
                case "Editar":

                    break;
                case "Actualizar":

                    break;
                case "Eliminar":

                    break;
            }
            request.getRequestDispatcher("EmpleadoServicio.jsp").forward(request, response);
        } else if (menu.equals("TipoServicio")) {
            switch (accion) {
                case "Listar":
                    List listaTipoServicio = tipoServicioDAO.listar();
                    request.setAttribute("tipoServicios", listaTipoServicio);
                    break;
                case "Agregar":
                    String tipoServ = request.getParameter("txtTipoServicio");
                    String descripcion = request.getParameter("txtDescripcion");
                    String precioTipoServicio = request.getParameter("txtPrecioTipoServicio");
                    try {
                        tipoServicio.setTipoServicio(tipoServ);
                        tipoServicio.setDescripcion(descripcion);
                        double prec = Double.parseDouble(precioTipoServicio);
                        tipoServicio.setPrecioTipoServicio(prec);
                        tipoServicioDAO.agregar(tipoServicio);
                        request.getRequestDispatcher("Controlador?menu=TipoServicio&accion=Listar").forward(request, response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Editar":
                    codTipoServicio = Integer.parseInt(request.getParameter("codigoTipoServicio"));
                    TipoServicio ts = tipoServicioDAO.listarCodigoTipoServicio(codTipoServicio);
                    request.setAttribute("tipoServicio", ts);
                    request.getRequestDispatcher("Controlador?menu=TipoServicio&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tipoServA = request.getParameter("txtTipoServicio");
                    String descripcionA = request.getParameter("txtDescripcion");
                    String precioTipoServicioA = request.getParameter("txtPrecioTipoServicio");
                        tipoServicio.setTipoServicio(tipoServA);
                        tipoServicio.setDescripcion(descripcionA);
                        double prec = Double.parseDouble(precioTipoServicioA);
                        tipoServicio.setPrecioTipoServicio(prec);
                        tipoServicio.setCodigoTipoServicio(codTipoServicio);
                        tipoServicioDAO.editar(tipoServicio);
                        request.getRequestDispatcher("Controlador?menu=TipoServicio&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoServicio = Integer.parseInt(request.getParameter("codigoTipoServicio"));
                    tipoServicioDAO.eliminar(codTipoServicio);
                    request.getRequestDispatcher("Controlador?menu=TipoServicio&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoServicio.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
