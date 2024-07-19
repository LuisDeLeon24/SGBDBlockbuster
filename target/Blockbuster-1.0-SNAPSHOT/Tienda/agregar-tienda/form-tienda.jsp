<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiendas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <nav class="navbar navbar-dark bg-dark fixed-top position-relative">
            <div class="container-fluid">
                <img width="150" alt="Bluckbuster" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Blockbuster_logo.svg/2560px-Blockbuster_logo.svg.png">
                <a class="navbar-brand" href="#">Tiendas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Tiendas</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div> 
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="../../index.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./form-tiendas/form-tiendas.jsp">Formulario de Tiendas</a>
                            </li> 
                            <li class="nav-item">
                                <a class="nav-link" href=".--/tienda-servlet">Lista de Tiendas</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container mt-3 text-center">

            <% ArrayList<String> datosPelicula = (ArrayList) request.getAttribute("datosPelicula"); %>
            <% String mensaje = (String) request.getAttribute("mensaje");%>
            <% if (datosPelicula != null) {%>
            <% for (String pelicula : datosPelicula) {%>
            <ul>   
                <li><%=pelicula%></li>
            </ul>
            <%}%>
            <%if (mensaje == null) {%>
            <div class="alert alert-success d-flex align-items-center" role="alert">
                <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                <div>
                    <h1>¡Tienda creada con Exito!</h1>
                </div>
            </div>
            <%}%>
            <%}%>
            <% if (mensaje != null) {%>
            <div class="alert alert-warning d-flex align-items-center" role="alert">
                <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                <div>
                    <h1><%=mensaje%></h1>
                </div>
                <%}%>



            </div>
            <div class="container mt-3 form-container">
                <form action="/Blockbuster/tienda-servlet" method="post" endtype="multipart/form-data">
                    <br>
                    <br>
                    <br>
                    <div class="form-floating mb-3">
                        <input type="nombre" class="form-control" id="titulo" name="direccion" placeholder="">
                        <label for="floatingInput">Direccion</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="marca" class="form-control" id="genero" name="ciudad" placeholder="">
                        <label for="floatingPassword">Ciudad</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" placeholder="" id="generoFavorito" name="tematica"></textarea>
                        <label for="floatingTextarea">Temática</label>
                    </div>

                    <br>
                    <br>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-dark">Ingresar</button>
                    </div>
                </form>
            </div>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
