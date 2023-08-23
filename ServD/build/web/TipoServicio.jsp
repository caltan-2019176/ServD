<%-- 
    Document   : TipoServicio
    Created on : Aug 16, 2023, 7:43:25 PM
    Author     : omary
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Tipo Servicio</title>
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
            <form action="Controlador?menu=TipoServicio" method="POST">
                
                <div class="form-group">
                    <label class="colorLabel" for="dato">tipoServicio</label>
                    <input type="text" value="${tipoServicio.getTipoServicio()}" id="tipoServicio" name="txtTipoServicio" class="form-control">
                </div>
                <div class="form-group">
                    <label class="colorLabel" for="dato">descripcion</label>
                    <input type="text" value="${tipoServicio.getDescripcion()}" id="descripcion" name="txtDescripcion" class="form-control">
                </div>
                <div class="form-group">
                    <label class="colorLabel" for="dato">precioTipoServicio</label>
                    <input type="number" value="${tipoServicio.getPrecioTipoServicio()}" id="precioTipoServicio" name="txtPrecioTipoServicio" class="form-control">
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
                    <td ><strong>Código Tipo Servicio</strong></td>
                    <td><strong>Tipo Servicio</strong></td>
                    <td><strong>Descripcion</strong></td>
                    <td><strong>Precio tipo Servicio</strong></td>                  
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tipoServicio" items="${tipoServicios}">
                    <tr>
                        <td>${tipoServicio.getCodigoTipoServicio()}</td>
                        <td>${tipoServicio.getTipoServicio()}</td>
                        <td>${tipoServicio.getDescripcion()}</td>
                        <td>${tipoServicio.getPrecioTipoServicio()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=TipoServicio&accion=Editar&codigoTipoServicio=${tipoServicio.getCodigoTipoServicio()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=TipoServicio&accion=Eliminar&codigoTipoServicio=${tipoServicio.getCodigoTipoServicio()}">Eliminar</a>
                        </td>
                    </tr>
                 </c:forEach>   
            </tbody>
        </table>
    </div>
   </div>
    </body>
</html>
