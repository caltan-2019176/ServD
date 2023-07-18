package config;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection conexion;
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBServD?useSSL=false","kinal", "admin"); //Cambian la contraseña :3
=======
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBServD?useSSL=false","kinal", "admin"); 
>>>>>>> rcolindres-2019169
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return conexion;
    }
    
}
