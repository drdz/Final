package Modelo;

import java.sql.Date;
public class Noticia {
     private int id_articulo;
    private String titulo="";
    private String contenido="";
    private String url_Imagen="";
    private int id_categoria=0;
    private String usuario="";

    public Noticia(String titulo, String contenido, int categoriaid) {
        this.titulo= titulo;
        this.id_categoria=categoriaid;
        this.contenido=contenido;
        
        
    }
  public Noticia() {
      
    }

    public Noticia( int idNoticia,String titulo, String descripcion, String urlImagen, int idcategoria) {
        this.id_articulo=idNoticia;
        this.titulo=titulo;
        this.url_Imagen= urlImagen;
        this.contenido= descripcion;
        this.id_categoria= idcategoria;
 
    }

    public Noticia(int id, String titulo, String contenido) {
        this.id_articulo=id;
        this.contenido=contenido;
        this.titulo=titulo;
    }

    public Noticia(int idNoticia, String titulo, String contenido, int categoriaid) {
            this.id_articulo=idNoticia;
            this.titulo=titulo;
            this.contenido=contenido;
            this.id_categoria=categoriaid;

    }



     public int getIdNoticia() {
        return id_articulo;
    }

    /**
     * @param id_articulo the id_articulo to set
     */
    public void setIdNoticia(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return contenido;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.contenido = descripcion;
    }

    /**
     * @return the url_Imagen
     */
    public String getUrl_Imagen() {
        return url_Imagen;
    }

    /**
     * @param url_Imagen the url_Imagen to set
     */
    public void setUrl_Imagen(String url_Imagen) {
        this.url_Imagen = url_Imagen;
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
