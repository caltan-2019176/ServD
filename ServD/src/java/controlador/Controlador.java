/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
    int codMedioTransporte;
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
    int codServicio;
    int codEquipo;
    int codTipoEmpleado;
    int codTipoServicio;
    int codEmpresa;
    int Equipo_codigoEmpleado;
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
            
        } 
         else if (menu.equals("HomePage")){
            request.getRequestDispatcher("HomePage.jsp").forward(request,response);
        } 
        else if (menu.equals("Equipo")) {
            switch (accion) {
                case "Listar":
                    List listaEquipo = equipoDAO.listar();
                    request.setAttribute("equipos", listaEquipo);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreEquipo");
                    String decri = request.getParameter("txtDescripcionEquipo");
                    String cantidad = request.getParameter("txtCantidad");
                    equipo.setNombreEquipo(nombre);
                    equipo.setDescripcionEquipo(decri);
                    equipo.setCantidad(Integer.parseInt(cantidad));
                    equipoDAO.agregar(equipo);
                    request.getRequestDispatcher("Controlador?menu=Equipo&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    codEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                    Equipo e = equipoDAO.listarEquipo(codEquipo);
                    request.setAttribute("equipo", e);
                    request.getRequestDispatcher("Controlador?menu=Equipo&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nombreEM = request.getParameter("txtNombreEquipo");
                    String descriEM = request.getParameter("txtDescripcionEquipo");
                    String cantidadEM = request.getParameter("txtCantidad");
                    equipo.setNombreEquipo(nombreEM);
                    equipo.setDescripcionEquipo(descriEM);
                    equipo.setCantidad(Integer.parseInt(cantidadEM));
                    equipo.setCodigoEquipo(codEquipo);
                    equipoDAO.editar(equipo);
                    request.getRequestDispatcher("Controlador?menu=Equipo&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                    equipoDAO.eliminar(codEquipo);
                    request.getRequestDispatcher("Controlador?menu=Equipo&accion=Listar").forward(request, response);
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
                    List listaEmpresa = empresaDao.listar();
                    request.setAttribute("empresas", listaEmpresa);
                    break;
                case "Agregar":
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String costo = request.getParameter("txtCostoCompra");
                    String descri = request.getParameter("txtDescripcionCompra");
                    String fecha = request.getParameter("txtFechaCompra");
                    String codEmpre = request.getParameter("cmbCodigoEmpresa");
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
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String lugar = request.getParameter("txtLugarServicio");
                    String numero = request.getParameter("txtNumeroServicio");
                    String hora = request.getParameter("txtHoraServicio");
                    String fecha = request.getParameter("txtFechaServicio");
                    int codigoTipo = Integer.parseInt(request.getParameter("cmbCodigoTipoServicio"));
                    try {
                        java.util.Date formato = formatoFecha.parse(fecha);
                        java.sql.Date fechaCompra = new java.sql.Date(formato.getTime());
                        servicio.setLugarServicio(lugar);
                        servicio.setNumeroServicio(numero);
                        servicio.setHoraServicio(hora);
                        servicio.setFechaServicio(fechaCompra);
                        servicio.setCodigoTipoServicio(codigoTipo);
                        servicioDAO.agregar(servicio);
                        request.getRequestDispatcher("Controlador?menu=Servicio&accion=Listar").forward(request, response);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case "Editar":

                    codServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                    Servicio s = servicioDAO.listarCodigoServicio(codServicio);
                    request.setAttribute("servicio", s);
                    request.getRequestDispatcher("Controlador?menu=Servicio&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
                    String lugarS = request.getParameter("txtLugarServicio");
                    String numeroS = request.getParameter("txtNumeroServicio");
                    String horaS = request.getParameter("txtHoraServicio");
                    String fechaSer = request.getParameter("txtFechaServicio");
                    try {
                        java.util.Date formato = fechaFormato.parse(fechaSer);
                        java.sql.Date fechaServicio = new java.sql.Date(formato.getTime());
                        servicio.setLugarServicio(lugarS);
                        servicio.setNumeroServicio(numeroS);
                        servicio.setHoraServicio(horaS);
                        servicio.setFechaServicio(fechaServicio);
                        servicio.setCodigoServicio(codServicio);
                        servicioDAO.actualizar(servicio);
                        request.getRequestDispatcher("Controlador?menu=Servicio&accion=Listar").forward(request, response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "Eliminar":
                    codServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                    servicioDAO.eliminar(codServicio);
                    request.getRequestDispatcher("Controlador?menu=Servicio&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Servicio.jsp").forward(request, response);
            
        } else if (menu.equals("EquipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List listaEmpleados = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    List listaEquipoEmpleado = equipo_has_EmpleadoDAO.listar();
                    request.setAttribute("equipoEmpleados", listaEquipoEmpleado);
                    List listaEquipo = equipoDAO.listar();
                    request.setAttribute("equipos", listaEquipo);
                    break;
                case "Agregar":
                    String cadEquipo = request.getParameter("cmbCodigoEquipo");
                    String cadEmpleado = request.getParameter("cmbEmpleadoEquipo");
                    String canEquipo = request.getParameter("txtCantidadEquipo"); 
                    equipo_has_Empleado.setCodigoEquipo(Integer.parseInt(cadEquipo));
                    System.out.println(cadEquipo);
                    equipo_has_Empleado.setCodigoEmpleado(Integer.parseInt(cadEmpleado));
                    System.out.println(cadEmpleado);
                    equipo_has_Empleado.setCantidadEquipo(Integer.parseInt(canEquipo));
                    System.out.println(canEquipo);
                    equipo_has_EmpleadoDAO.agregar(equipo_has_Empleado);
                    request.getRequestDispatcher("Controlador?menu=EquipoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    Equipo_codigoEmpleado = Integer.parseInt(request.getParameter("Equipo_codigoEmpleado"));
                    Equipo_has_Empleado emp = equipo_has_EmpleadoDAO.listarEquipoEmpleado(Equipo_codigoEmpleado);
                    request.setAttribute("equipoEmpleado", emp);
                    request.getRequestDispatcher("Controlador?menu=EquipoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                        String canEquipos = request.getParameter("txtCantidadEquipo");
                        equipo_has_Empleado.setCantidadEquipo(Integer.parseInt(canEquipos));
                        equipo_has_Empleado.setEquipo_codigoEmpleado(Equipo_codigoEmpleado);
                        equipo_has_EmpleadoDAO.actualizar(equipo_has_Empleado);
                        request.getRequestDispatcher("Controlador?menu=EquipoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    Equipo_codigoEmpleado = Integer.parseInt(request.getParameter("Equipo_codigoEmpleado"));
                    equipo_has_EmpleadoDAO.eliminar(Equipo_codigoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=EquipoEmpleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("EquipoEmpleado.jsp").forward(request, response);

        } else if (menu.equals(
                "TipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List listaTiposEmpleados = tipoEmpleadoDAO.Listar();
                    request.setAttribute("tiposEmpleados", listaTiposEmpleados);
                    break;
                case "Agregar":
                    String descrip = request.getParameter("txtDescripcionTipoEmpleado");
                    String cate = request.getParameter("txtCategoria");
                    String sueldo = request.getParameter("txtSueldo");
                    tipoEmpleado.setDescripcionTipoEmpleado(descrip);
                    tipoEmpleado.setCategoria(cate);
                    tipoEmpleado.setSueldo(Double.parseDouble(sueldo));
                    tipoEmpleadoDAO.agregar(tipoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    codTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
                    TipoEmpleado te = tipoEmpleadoDAO.listarCodigoTipoEmpleado(codTipoEmpleado);
                    request.setAttribute("tipoEmpleado", te);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String descripTE = request.getParameter("txtDescripcionTipoEmpleado");
                    String cateTE = request.getParameter("txtCategoria");
                    String sueldoTE = request.getParameter("txtSueldo");
                    tipoEmpleado.setDescripcionTipoEmpleado(descripTE);
                    tipoEmpleado.setCategoria(cateTE);
                    tipoEmpleado.setSueldo(Double.parseDouble(sueldoTE));
                    tipoEmpleado.setCodigoTipoEmpleado(codTipoEmpleado);
                    tipoEmpleadoDAO.actualizar(tipoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    codTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
                    tipoEmpleadoDAO.eliminar(codTipoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
        } else if (menu.equals(
                "Empleado")) {
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
                    String placa = request.getParameter("txtPlaca");
                    String tipoVehiculo = request.getParameter("txtTipoVehiculo");
                    String marca = request.getParameter("txtMarca");
                    medioTransporte.setPlaca(placa);
                    medioTransporte.setTipoVehiculo(tipoVehiculo);
                    medioTransporte.setMarca(marca);
                    medioTransporteDAO.agregar(medioTransporte);
                    request.getRequestDispatcher("Controlador?menu=MedioTransporte&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    codMedioTransporte = Integer.parseInt(request.getParameter("codigoTransporte"));
                    MedioTransporte me = medioTransporteDAO.listarMedioTransporte(codMedioTransporte);
                    request.setAttribute("medioTransporte", me);
                    request.getRequestDispatcher("Controlador?menu=MedioTransporte&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String placaT = request.getParameter("txtPlaca");
                    String tipoVehiculoT = request.getParameter("txtTipoVehiculo");
                    String marcaT = request.getParameter("txtMarca");
                    medioTransporte.setPlaca(placaT);
                    medioTransporte.setTipoVehiculo(tipoVehiculoT);
                    medioTransporte.setMarca(marcaT);
                    medioTransporte.setCodigoTransporte(codMedioTransporte);
                    medioTransporteDAO.editar(medioTransporte);
                    request.getRequestDispatcher("Controlador?menu=MedioTransporte&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    codMedioTransporte = Integer.parseInt(request.getParameter("codigoTransporte"));
                    medioTransporteDAO.eliminar(codMedioTransporte);
                    request.getRequestDispatcher("Controlador?menu=MedioTransporte&accion=Listar").forward(request, response);
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
                    String nombre = request.getParameter("txtNombreEmpresa");
                    String telefono = request.getParameter("txtTelefonoEmpresa");
                    String direccion = request.getParameter("txtDireccionEmpresa");
                    String estado = request.getParameter("txtEstadoEmpresa");
                    
                    empresa.setNombreEmpresa(nombre);
                    empresa.setTelefonoEmpresa(telefono);
                    empresa.setDireccionEmpresa(direccion);
                    empresa.setEstadoEmpresa(estado);
                    empresaDao.agregar(empresa);
                    request.getRequestDispatcher("Controlador?menu=Empresa&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codEmpresa = Integer.parseInt(request.getParameter("codigoEmpresa"));
                    Empresa e = empresaDao.listarCodigoEmpresa(codEmpresa);
                    request.setAttribute("empresa", e);
                    request.getRequestDispatcher("Controlador?menu=Empresa&accion=Listar").forward(request, response);
                    System.out.println("yvcgfrtd");
                    break;
                case "Actualizar":
                    codEmpresa = Integer.parseInt(request.getParameter("txtCodigoEmpresa"));
                    String nombreEmp = request.getParameter("txtNombreEmpresa");
                    String telefonoEmp = request.getParameter("txtTelefonoEmpresa");
                    String direccionEmp = request.getParameter("txtDireccionEmpresa");
                    String estadoEmp = request.getParameter("txtEstadoEmpresa");
                    empresa.setCodigoEmpresa(codEmpresa);
                    empresa.setNombreEmpresa(nombreEmp);
                    empresa.setTelefonoEmpresa(telefonoEmp);
                    empresa.setDireccionEmpresa(direccionEmp);
                    empresa.setEstadoEmpresa(estadoEmp);
                    empresaDao.editarEmpresa(empresa);
                    request.getRequestDispatcher("Controlador?menu=Empresa&accion=Listar").forward(request, response);
                    
                    break;
                case "Eliminar":
                    codEmpresa = Integer.parseInt(request.getParameter("codigoEmpresa"));
                    empresaDao.eliminarEmpresa(codEmpresa);
                    request.getRequestDispatcher("Controlador?menu=Empresa&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empresa.jsp").forward(request, response);
        }else if (menu.equals(
                "EmpleadoServicio")) {
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
