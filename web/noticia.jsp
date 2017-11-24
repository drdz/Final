<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Noticia"%>
<!DOCTYPE html>
<html>
    <head>
        <title>"Proyecto Final"</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="maincss.css">
    </head>
    <body>
         <%            
             Noticia noticia =new Noticia();
                      noticia = (Noticia)  request.getAttribute("noticia");
             
        %>
     
        <div id="encabezado">
            <h1><a href="index.jsp">Useless team</a></h1>
        </div>
        <div id="menu">        
            <ul>
                <li><a href="CategoriasServlet">Inicio</a></li>
                <li><a href="CategoriasServlet?categoria=1">Entretenimiento</a></li>
                <li><a href="CategoriasServlet?categoria=2">Ciencia</a></li>
                <li><a href="CategoriasServlet?categoria=3">Pol�tica</a></li>
                <li><a href="CategoriasServlet?categoria=4">Internacional</a></li>
                <li><a href="CategoriasServlet?categoria=5">Deportes</a></li>
                <li id="botonIniciarSesion"><a href="login.jsp">Iniciar Sesi�n</a></li>
                <li ><a href="registro.jsp">Registrarse</a></li>
               
                 <li ><a href="Agregarnoticia.jsp">Registrar Noticia</a></li>
                
            </ul>
        </div> 
        <br>
        <div id="lista_noticias_recientes">
     <h1>Registrar noticia</h1>
            <form action="NoticiaServlet" method="POST" >
                <label><b>Titulo<b/></label>
                <input type="text" placeholder="Ingresar Titulo"value="<%=noticia.getTitulo()%>" name="titulo">
                    <label><b>Contenido<b/></label>
                <input type="text" placeholder="Ingresar contenido"value="<%=noticia.getDescripcion()%>" name="contenido">
            
                  
                      <select name="categoria">
                       <option value="1">Entretenimiento</option>
                       <option value="2">Ciencia</option>
                       <option value="3">Pol�tica</option>
                       <option value="4">Internacional</option>
                       <option value="5">Deportes</option>
                     </select>       
                <input type="hidden" name="action" value="modificarNoticia">
                <input type="hidden" name="idNoticiaModificar" value="<%=noticia.getIdNoticia()%>">
                <button type="submit">Agregar Noticia</button>
            </form>
           
        
           
        </div>
       
    </body>
</html>


