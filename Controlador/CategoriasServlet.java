package Controlador;

import Data.NoticiaDB;
import Modelo.Noticia;
import Modelo.Password;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            String ID= request.getParameter("categoria");
            String idEliminarNoticia= request.getParameter("idEliminarNoticia");
            String idModificarNoticia= request.getParameter("idModificarNoticia");
            if (idEliminarNoticia!=null)
            {
                    int id=Integer.parseInt(idEliminarNoticia);
                  boolean eliminado = NoticiaDB.eliminarNoticia(id);
                  if(eliminado==true)
                  {

                  }

            }
            
            if(idModificarNoticia!=null){
                int id=Integer.parseInt(idModificarNoticia);
                Noticia noticia = NoticiaDB.getNoticia(id);
                        if(noticia!=null)
                        {
                         request.setAttribute("noticia", noticia);
                        RequestDispatcher rd=request.getRequestDispatcher("/noticia.jsp");
                        rd.forward(request, response);
                        }

          }
             int IDCATEGORIA=0;
             
            
             try {
                IDCATEGORIA=Integer.parseInt(ID);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
                List<Noticia> noticias = NoticiaDB.getNoticiasbyId(IDCATEGORIA);
                        request.setAttribute("noticias", noticias);
                        RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
