package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo Díaz
 */
public class ServicioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "select * from Servicio";
        List<Servicio> listaServicios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicio servi = new Servicio();
                servi.setCodigoServicio(rs.getInt(1));
                servi.setLugarServicio(rs.getString(2));
                servi.setNumeroServicio(rs.getString(3));
                servi.setHoraServicio(rs.getString(4));
                servi.setFechaServicio(rs.getDate(5));
                servi.setCodigoTipoServicio(rs.getInt(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaServicios;
    }

    public int agregar(Servicio servi) {
        String sql = "insert into Servicio (lugarServicio, numeroServicio, horaServicio, fechaServicio, codigoTipoServicio) values(?, ?, ?, ?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, servi.getLugarServicio());
            ps.setString(2, servi.getNumeroServicio());
            ps.setString(3, servi.getHoraServicio());
            ps.setDate(4, new java.sql.Date(servi.getFechaServicio().getTime()));
            ps.setInt(5, servi.getCodigoTipoServicio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizar(Servicio servi) {
        String sql = "Update Servicio set lugarServicio = ?, numeroServicio = ?, horaServicio = ? fechaServicio = ? where codigoServicio = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, servi.getLugarServicio());
            ps.setString(2, servi.getNumeroServicio());
            ps.setString(3, servi.getHoraServicio());
            ps.setDate(4, (Date) servi.getFechaServicio());
            ps.setInt(5, servi.getCodigoServicio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;

    }

    public void eliminar(int id) {
        String sql = "delete from Servicio where codigoEmpleado = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}