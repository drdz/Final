package Modelo;

/*
 declaramos las propiedades
 */
public class Usuario {
    private int iduser;
    private String email;
    private String password;
    private String name;
    private boolean tipoUsuario;
    /**
Hacemos el constructor
 */
    
    public Usuario (String email,String password){
    this.email=email;
    this.password=password;
    
    }

    public Usuario(String name, String email, String contraseña,boolean tipou) {
            this.name=name;
            this.email=email;
            this.password=contraseña;
            this.tipoUsuario=tipou;
    }

    public Usuario() {
    }

    public Usuario(String email, int idUsuario,boolean tipoUsuario,String name) {
        this.email=email;
        this.iduser=idUsuario;
        this.tipoUsuario=tipoUsuario;
        this.name=name;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
