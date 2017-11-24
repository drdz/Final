<%@page import="Data.NoticiaDB"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    session = request.getSession();
    List<Noticia> noticias = NoticiaDB.noticias();
    request.setAttribute("noticias", noticias);
                                RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
                                rd.forward(request, response);

    %>

