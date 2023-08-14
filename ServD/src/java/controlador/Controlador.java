/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.MedioTransporte;
import modelo.MedioTransporteDAO;
import modelo.Servicio;
import modelo.ServicioDAO;

/**
 *
 * @author colin
 */
public class Controlador extends HttpServlet {

    MedioTransporte medioTransporte = new MedioTransporte();
    MedioTransporteDAO medioTransporteDAO = new MedioTransporteDAO();
    Servicio servicio = new Servicio();
    ServicioDAO servicioDAO = new ServicioDAO();
    int codCompra;

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
        } else if (menu.equals("Empleado")) {
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        } else if (menu.equals("Compra")) {
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("Empresa")) {
            request.getRequestDispatcher("Empresa.jsp").forward(request, response);
        } else if (menu.equals("Proveedor")) {
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        } else if (menu.equals("Equipo")) {
            request.getRequestDispatcher("Equipo.jsp").forward(request, response);
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
        } else if (menu.equals("TipoServicio")) {
            request.getRequestDispatcher("TipoServicio.jsp").forward(request, response);
        } else if (menu.equals("TipoEmpleado")) {
            request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
        } else if (menu.equals("ServicioCompra")) {
            request.getRequestDispatcher("ServicioCompra.jsp").forward(request, response);
        } else if (menu.equals("ProveedorEquipo")) {
            request.getRequestDispatcher("ProveedorEquipo.jsp").forward(request, response);
        } else if (menu.equals("EquipoEmpleado")) {
            request.getRequestDispatcher("EquipoEmpleado.jsp").forward(request, response);
        } else if (menu.equals("EmpleadoServicio")) {
            request.getRequestDispatcher("EmpleadoServicio.jsp").forward(request, response);
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
