<%-- 
    Document   : error
    Created on : 22/10/2017, 02:46:01 AM
    Author     : fernando martinez bautista 1702824
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="maincss.css">
        <title>Registrar Noticia</title>
    </head>
    <body>
        <div id="encabezado">
            <h1><a href="index.jsp">Useless team</a></h1>
        </div>
        <div id="menu">        
            <ul>
                <li><a href="Categorías/Entretenimiento.jsp">Entretenimiento</a></li>
                <li><a href="Categorías/Ciencia.jsp">Ciencia</a></li>
                <li><a href="Categorías/Politica.jsp">Política</a></li>
                <li><a href="Categorías/Internacional.jsp">Internacional</a></li>
                <li><a href="Categorías/Deportes.jsp">Deportes</a></li>
                <li id="botonIniciarSesion"><a href="login.jsp">Iniciar Sesión</a></li>
                 <li ><a href="Agregarnoticia.jsp">Registrarse</a></li>
            </ul>
        </div> 
        <br>
        <div class="contenido" id="formularioLogin">
            <h1>Registrar noticia</h1>
            <form action="NoticiaServlet" method="POST"  >
                <label><b>Titulo<b/></label>
                <input type="text" placeholder="Ingresar Titulo" name="titulo">
                    <label><b>Contenido<b/></label>
                <input type="text" placeholder="Ingresar contenido" name="contenido">
                <label><b>Imagen</b></label>
                  <input type="file"  name="imagen">
                      <select name="categoria">
                       <option value="1">Entretenimiento</option>
                       <option value="2">Ciencia</option>
                       <option value="3">Política</option>
                       <option value="4">Internacional</option>
                       <option value="5">Deportes</option>
                     </select>       
                <input type="hidden" name="action" value="registroNoticia">
                <button type="submit">Agregar Noticia</button>
            </form>
        </div>
    </body>
</html>

