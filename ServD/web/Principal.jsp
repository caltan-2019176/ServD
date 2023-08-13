<%-- 
    Document   : Principal
    Created on : 11/08/2023, 01:01:30 PM
    Author     : abads
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Home Page</title>
    </head>
    <body>
        <nav style="background-color: #CBF5F4; display: flex; justify-content: center; align-items: center;" class="navbar navbar-expand-lg navbar-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav align-items-center">
                    <style>
                        
                    </style>
                    <a href="Controlador?menu=Principal">
                        <img src="img/logo2.png" alt="ServD" width="120" height="55">
                    </a>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Empleado" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Compra" target="myFrame"">Compra</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Empresa" target="myFrame"">Empresa</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Proveedor" target="myFrame"">Proveedor</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Equipo" target="myFrame"">Equipo</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Servicio" target="myFrame"">Servicio</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=TipoServicio" target="myFrame"">Tipo Servicio</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=TipoEmpleado" target="myFrame"">Tipo Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=MedioTransporte&accion=Listar" target="myFrame">Medio Transporte</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=Compra" target="myFrame"">Servicio Compra</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=ProveedorEquipo" target="myFrame"">Proveedor Equipo</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=EquipoEmpleado" target="myFrame"">Equipo Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="border: none; color: #32325a; font-size: 16px;" class="btn btn-outline-light" href="Controlador?menu=EmpleadoServicio" target="myFrame"">Empleado Servicio</a>
                    </li>
                </ul>
            </div>

            <div class="dropdown">
                <button style="border: none; position: relative; color: #32325a" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNombresEmpleado()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton" style="transform: translateX(-95px)">
                    <a class="dropdown-item" href="#">
                        Imagen
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="m-4" style="height: 640px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
