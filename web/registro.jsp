<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="maincss.css">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <div id="encabezado">
            <h1><a href="index.jsp">Useless team</a></h1>
        </div>
        <div id="menu">        
            <ul>
                <li><a href="CategoriasServlet">Inicio</a></li>
                <li><a href="CategoriasServlet?categoria=1">Entretenimiento</a></li>
                <li><a href="CategoriasServlet?categoria=2">Ciencia</a></li>
                <li><a href="CategoriasServlet?categoria=3">Política</a></li>
                <li><a href="CategoriasServlet?categoria=4">Internacional</a></li>
                <li><a href="CategoriasServlet?categoria=5">Deportes</a></li>
                <li id="botonIniciarSesion"><a href="login.jsp">Iniciar Sesión</a></li>
            </ul>
        </div> 
        <br>
        <div class="contenido" id="formularioLogin">
            <h1>Registrate aqui</h1>
            <form action="UsuarioServlet" method="POST">
                <label><b>Nombre<b/></label>
                <input type="text" placeholder="Ingresar Usuario" name="name">
                    <label><b>Email<b/></label>
                <input type="text" placeholder="Ingresar email" name="email">
                <label><b>Contraseña</b></label>
                <input type="password" placeholder="Ingresar Contraseña" name="password">
                <input type="hidden" name="action" value="registro">
                <select name="tipousuario">
                       <option value="0">cliente</option>
                       <option value="1">administrador</option>
                       </select>  
                <button type="submit">Registrarse</button>
                <br><a href="index.jsp">Regresar</a><br>
            </form>
        </div>
    </body>
</html>
