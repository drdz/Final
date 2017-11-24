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
             List<Noticia> noticias = new ArrayList();
                      noticias = (ArrayList<Noticia>)  request.getAttribute("noticias");
                      String name ="";
                      Boolean tipoUsuario =false;
                      
           if (session.getAttribute("tipoUsuario")!=null) {
                tipoUsuario= (Boolean)session.getAttribute("tipoUsuario");
                name= (String)session.getAttribute("name");
            } 
             
             if (noticias==null){
              noticias= (List) session.getAttribute("noticias");
           
             }
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
            
                <li><a href="logout.jsp" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesion</a></li>
           
               
                <li ><a href="registro.jsp">Registrarse</a></li>
                <%
                    if (tipoUsuario==true){
                %>
                 <li ><a href="Agregarnoticia.jsp">Registrar Noticia</a></li>
                 <li><%=name%></li>
                 
                 <% 
                    }
                 %>
                 
                
                     
            </ul>
        </div> 
        <br>
        <div id="lista_noticias_recientes">
            
            <%   
          if (noticias!=null){
                
             for(Noticia noticia:noticias){
             
        %>
   <form action="NoticiaServlet" method= "post" >
       
           <th><%=noticia.getDescripcion()%></th>
            <ul>
                <li>
                    <img src="http://www.panorama.com.ve/__export/1464206555677/sites/panorama/img/bellezaysalud/2016/05/25/aceite-de-coco-coco-830x456.jpg">
                    <h3><a href="error.jsp"><%=noticia.getTitulo()%> </a></h3>
                    
                        
                        <p><%=noticia.getDescripcion()%></p>
               
                     <textarea  name="comentario" required></textarea>
                    <input type="hidden" name="idNoticia"value="<%=noticia.getIdNoticia()%>">
                     <input type="hidden" name="action" value="comenta"> 
                     <input  name="boton" type="submit" value= "Comenta" />
                    
                     
                </li>
            </ul>
           <%
                    if (tipoUsuario==true){
                %>
                 <a href="CategoriasServlet?idEliminarNoticia=<%=noticia.getIdNoticia()%>">Eliminar</a>
           <a href="CategoriasServlet?idModificarNoticia=<%=noticia.getIdNoticia()%>">Modificar</a>
                 <% 
                    }
                 %>
           
   </form>
           
        <%
        }
}
        %>
           
        </div>
       
    </body>
</html>



