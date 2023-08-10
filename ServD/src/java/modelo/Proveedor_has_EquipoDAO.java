package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Proveedor_has_EquipoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    /**
     * Metodo que lista los elementos de Proveedor_has_equipo
     * @return lista de Proveedor_has_equipo
     */
    public List listar(){
        String sql = "select * from Proveedor_has_Equipo";
        List<Proveedor_has_Equipo> listaProveedor_has_Equipo = new ArrayList<>();
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery(); 
            while(rs.next()){
                Proveedor_has_Equipo pe = new Proveedor_has_Equipo();
                pe.setCodigoProveedor_has_Equipo(rs.getInt(1));
                pe.setDescripcionProveedor(rs.getString(2));
                pe.setCodigoProveedor_has_Equipo(rs.getInt(3));
                pe.setCodigoEquipo(rs.getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaProveedor_has_Equipo;
    }
    
    // Método Agregar
    
    public int agregar(Proveedor_has_Equipo pro){
        String sql = "insert into Proveedor_has_Equipo (codigoProveedor_has_Equipo, descripcionProveedor, codigoProveedor, codigoEquipo) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigoProveedor_has_Equipo());
            ps.setString(2, pro.getDescripcionProveedor());
            ps.setInt(3, pro.getCodigoProveedor());
            ps.setInt(4, pro.getCodigoEquipo());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Método Buscar
    
    public Proveedor_has_Equipo listaProveedor_has_Equipo(int id){
        Proveedor_has_Equipo phe = new Proveedor_has_Equipo();
        String sql = "select * from Proveedor_has_Equipo where codigoProveedor_has_Equipo = "+id;
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            while (rs.next()){
                phe.setDescripcionProveedor(rs.getString(2));
                phe.setCodigoProveedor(rs.getInt(3));
                phe.setCodigoEquipo(rs.getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return phe;
    }
    
    // Método Editar
    
    public int editar(Proveedor_has_Equipo ex){
        String sql = "Update Proveedor_has_Equipo set descripcionProveedor = ? where codigoProveedor_has_Equipo = ?";
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql);
            ps.setString(1, ex.getDescripcionProveedor());
            ps.setInt(2, ex.getCodigoProveedor_has_Equipo());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();        
        }
        return resp;
    }
    
    // Método Eliminar
    
    public void eliminar(int id){
        String sql = "delete from Proveedor_has_Equipo where codigoProveedor_has_Equipo = "+id;
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}