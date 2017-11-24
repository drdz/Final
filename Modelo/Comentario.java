package Modelo;
public class Comentario {
      private String contenido ;
    private int idusuario;    
    private int idnoticia;


    public Comentario(String contenido,int idnoticia, int idusuario) {
        this.contenido=contenido;
        this.idusuario= idusuario;
        this.idnoticia=idnoticia;
    
}

    public Comentario(int idnoticia, int idUsuario,String contenido) {
        this.idnoticia=idnoticia;
        this.idusuario=idUsuario;
        this.contenido=contenido;
    }

    public int getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(int idnoticia) {
        this.idnoticia = idnoticia;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
}
