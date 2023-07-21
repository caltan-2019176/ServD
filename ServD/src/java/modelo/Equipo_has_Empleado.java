package modelo;


public class Equipo_has_Empleado{
    
    private int Equipo_codigoEmpleado;
    private String cantidadEquipo;
    private int Equipo_codigoEquipo;
    private int Empleado_codigoEmpleado;

    //Contructor vacio
    public Equipo_has_Empleado(){
        
    }

    public Equipo_has_Empleado(int Equipo_codigoEmpleado, String cantidadEquipo, int Equipo_codigoEquipo, int Empleado_codigoEmpleado) {
        this.Equipo_codigoEmpleado = Equipo_codigoEmpleado;
        this.cantidadEquipo = cantidadEquipo;
        this.Equipo_codigoEquipo = Equipo_codigoEquipo;
        this.Empleado_codigoEmpleado = Empleado_codigoEmpleado;
    }

    public int getEquipo_codigoEmpleado() {
        return Equipo_codigoEmpleado;
    }

    public void setEquipo_codigoEmpleado(int Equipo_codigoEmpleado) {
        this.Equipo_codigoEmpleado = Equipo_codigoEmpleado;
    }

    public String getCantidadEquipo() {
        return cantidadEquipo;
    }

    public void setCantidadEquipo(String cantidadEquipo) {
        this.cantidadEquipo = cantidadEquipo;
    }

    public int getEquipo_codigoEquipo() {
        return Equipo_codigoEquipo;
    }

    public void setEquipo_codigoEquipo(int Equipo_codigoEquipo) {
        this.Equipo_codigoEquipo = Equipo_codigoEquipo;
    }

    public int getEmpleado_codigoEmpleado() {
        return Empleado_codigoEmpleado;
    }

    public void setEmpleado_codigoEmpleado(int Empleado_codigoEmpleado) {
        this.Empleado_codigoEmpleado = Empleado_codigoEmpleado;
    }
    
    
}