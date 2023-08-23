<%-- 
    Document   : Empleado
    Created on : 16/08/2023, 04:20:58 PM
    Author     : Ricardo Colindres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Empleado</title>
        <style>

        body {
            background-color:  #ffffffa0;
        }
        .card-form {
            width: 750px;
            height: 400;
            left: 25%;
            margin-right: -150;
            margin-top: 15px;
            background-color: #b8f4f4;
        }
        .card-table {
            margin: 35px;
        }
        .action-btns {
            display: flex;
            justify-content: space-between;
        }
        .colorLabel{
            color: rgb(0, 0, 0);
        }
        .table-hover{
            text-align: center;

        }
        .btn{
            background-color: #ffffff;
            color: rgb(0, 0, 0);
        }
    </style>
    </head>
    
    <body>
    <div>
            <div class="card col-sm-11.5 card-form">
                
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
               
                <div class="form-group">
                        <label class="colorLabel" for="dato">Usuario</label>
                        <input type="text" id="usuario" name="usuario" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">DPI Empleado</label>
                        <input type="text" id="DPIEmpleado" name="DPIEmpleado" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Nombres Empleado</label>
                        <input type="text" id="nombresEmpleado" name="nombresEmpleado" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Apellidos Empleado</label>
                        <input type="text" id="apellidosEmpleado" name="apellidosEmpleado" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Teléfono Contacto</label>
                        <input type="text" id="telefonoContacto" name="telefonoContacto" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Tipo Empleado</label>
                        <input type="text" id="codigoTipoEmpleado" name="codigoTipoEmpleado" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Medio Transporte</label>
                        <input type="text" id="codigoTransporte" name="codigoTransporte" class="form-control">
                </div>
                <div class="form-group">
                        <label class="colorLabel" for="dato">Equipo</label>
                        <input type="text" id="codigoEquipo" name="codigoEquipo" class="form-control">
                </div>
                <div class="action-btns">
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </div>
            </form>
            </div>
        </div>
            <div class="col-sm-11.5 card-table">
                <table class="table table-hover">
                    <thead class="thead thead-hover">
                        <tr>
                            <td><strong>Código Empleado</strong></td>
                            <td><strong>Usuario</strong></td>
                            <td><strong>DPI</strong></td>
                            <td><strong>Nombres</strong></td>
                            <td><strong>Apellidos</strong></td>
                            <td><strong>Teléfono</strong></td>
                            <td><strong>Tipo Empleado</strong></td>
                            <td><strong>Transporte</strong></td>
                            <td><strong>Equipo</strong></td>
                            <td><strong>Acciones</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <td>${empleado.getCodigoEmpleado()}</td>
                                <td>${empleado.getUsuario()}</td>
                                <td>${empleado.getDPIEmpleado()}</td>
                                <td>${empleado.getNombresEmpleado()}</td>
                                <td>${empleado.getApellidosEmpleado()}</td>
                                <td>${empleado.getTelefonoContacto()}</td>
                                <td>${empleado.getCodigoTipoEmpleado()}</td>
                                <td>${empleado.getCodigoTransporte()}</td>
                                <td>${empleado.getCodigoEquipo()}</td>
                                <td>
                                    <a class="btn btn-warning" href="">Editar</a>
                                    <a class="btn btn-danger" href="">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </div>  
</div>
    
    
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    
    </body>
</html>
