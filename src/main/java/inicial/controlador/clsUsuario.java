
package inicial.controlador;

public class clsUsuario {
     private int usuid;
    private String usunombre;
    private String usucontrasena;
    private String usucorreoe;
    private String usutelefono;
    private String usudireccion;
    
     public clsUsuario() {
    }
 public clsUsuario(int p_usuid) {
        this.usuid = p_usuid;
    }
    
    public clsUsuario(String p_usunombre, String p_usucontrasena) {
        this.usunombre = p_usunombre;
        this.usucontrasena = p_usucontrasena;
    }
    
    public clsUsuario(int p_usuid, String p_usunombre, String p_usucontrasena) {
        this.usuid = p_usuid;
        this.usunombre = p_usunombre;
        this.usucontrasena = p_usucontrasena;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUsuid() {
        return usuid;
    }

    public void setUsuid(int usuid) {
        this.usuid = usuid;
    }

    public String getUsunombre() {
        return usunombre;
    }

    public void setUsunombre(String usunombre) {
        this.usunombre = usunombre;
    }

    public String getUsucontrasena() {
        return usucontrasena;
    }

    public void setUsucontrasena(String usucontrasena) {
        this.usucontrasena = usucontrasena;
    }

    public String getUsucorreoe() {
        return usucorreoe;
    }

    public void setUsucorreoe(String usucorreoe) {
        this.usucorreoe = usucorreoe;
    }

    public String getUsutelefono() {
        return usutelefono;
    }

    public void setUsutelefono(String usutelefono) {
        this.usutelefono = usutelefono;
    }

    public String getUsudireccion() {
        return usudireccion;
    }

    public void setUsudireccion(String usudireccion) {
        this.usudireccion = usudireccion;
    }    
}
