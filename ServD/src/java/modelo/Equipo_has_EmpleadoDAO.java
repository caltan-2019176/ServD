package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Equipo_has_EmpleadoDAO{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Equipo_has_Empleado validar(int Equipo_codigoEmpleado){
        // Vamos a instanciar Equipo_Has_Empleado
        Equipo_has_Empleado equipo_has_empleado = new Equipo_has_Empleado();
        String sql = "Select * from Equipo_has_Empleado where Equipo_codigoEmpleado = ?";
        //Consulta del Sql
        try{
        con = cn.Conexion();
        ps = con.prepareCall(sql);
        ps.setInt(1, Equipo_codigoEmpleado);
        rs = ps.executeQuery();
        while(rs.next()){
            equipo_has_empleado.setEquipo_codigoEmpleado(rs.getInt("Equipo_codigoEmpleado"));
            equipo_has_empleado.setCantidadEquipo(rs.getString("cantidadEquipo"));
            equipo_has_empleado.setEquipo_codigoEquipo(rs.getInt("Equipo_codigoEquipo"));
            equipo_has_empleado.setEmpleado_codigoEmpleado(rs.getInt("Empleado_codigoEmpleado"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return equipo_has_empleado;// Retorna Equipo_has_EmpleadoDAO 
        
    }
    
    // Metodo Listar Equipo_has_Empleado
    public List Listar(){
        String sql = "Select * from Equipo_has_Empleado";
        List<Equipo_has_Empleado> listaEquipo_has_Empleado = new ArrayList<>();
        try{
            con= cn.Conexion();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Equipo_has_Empleado es = new Equipo_has_Empleado();
                es.setEquipo_codigoEmpleado(rs.getInt(1));
                es.setCantidadEquipo(rs.getString(2));
                es.setEquipo_codigoEquipo(rs.getInt(3));
                es.setEmpleado_codigoEmpleado(rs.getInt(4));
                listaEquipo_has_Empleado.add(es);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaEquipo_has_Empleado;
        
    }
    
    // Metodo Agregar Equipo_has_Empleado
    public int agregar(Equipo_has_Empleado emp){
        String sql ="Insert into Equipo_has_Empleado (Equipo_codigoEmpleado, CantidadEquipo, Equipo_codigoEquipo, Empleado_codigoEmpleado) values (?,?,?,?)" ;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getEquipo_codigoEmpleado());
            ps.setString(2, emp.getCantidadEquipo());
            ps.setInt(3, emp.getEquipo_codigoEquipo());
            ps.setInt(4, emp.getEmpleado_codigoEmpleado());
            
            ps.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return resp;
    }
    
    // Buscar Equipo_has_Empleado
    public Equipo_has_Empleado listaEquipo_has_Empleado(int id){
    Equipo_has_Empleado ts = new Equipo_has_Empleado();
    String sql ="Select * from Equipo_has_Empleado where Empleado_codigoEmpleado = "+id;
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
                ts.setEquipo_codigoEmpleado(rs.getInt(1));
                ts.setCantidadEquipo(rs.getString(2));
                ts.setEquipo_codigoEquipo(rs.getInt(3));
                ts.setEmpleado_codigoEmpleado(rs.getInt(4));
        }
    
    }catch(Exception e){
        e.printStackTrace();
    }
    
    
    return ts;
    }

   // Metodo Eliminar Equipo_has_Empleado
   public void eliminar(int id){
        String sql = "delete from Equipo_has_Empleado where Equipo_codigoEmpleado = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}