<%@page import="java.util.List"%>
<%@page import="org.grupo5.webapp.model.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark fixed-top position-relative">
            <div class="container-fluid">
                <a class="navbar-brand" href="../index.jsp">Peliculas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Peliculas</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="./pelicula.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./formulario-peliculas/formulario-peliculas.jsp">Formulario de Peliculas</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./pelicula-servlet">Lista de Peliculas</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container mt-3">
            <form>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID#</th>
                            <th scope="col">Titulo</th>
                            <th scope="col">Genero</th>
                            <th scope="col">Estreno</th>
                            <th scope="col">Direccion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%List<Pelicula> peliculas = (List)request.getAttribute("peliculas"); %>

                        <% for (Pelicula pelicula : peliculas) {%>
                        <tr>
                            <th scopre="row"><%=pelicula.getPeliculaId()%></th>
                            <th scopre="row"><%=pelicula.getTitulo()%></th>
                            <th scopre="row"><%=pelicula.getGenero()%></th>
                            <th scopre="row"><%=pelicula.getEstreno()%></th>
                            <th scopre="row"><%=pelicula.getDirector()%></th>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
