
package inicial.controlador;

public class clsAlumnos {
    private String carnet_alumno;
    private String nombre_alumno;
    private String direccion_alumno;
    private String telefono_alumno;
    private String email_alumno;
    private String estatus_alumno;

    public clsAlumnos() {  
    }
    
    public clsAlumnos(String carnet_alumno, String nombre_alumno, String direccion_alumno, String telefono_alumno, String email_alumno, String estatus_alumno) {
        this.carnet_alumno = carnet_alumno;
        this.nombre_alumno = nombre_alumno;
        this.direccion_alumno = direccion_alumno;
        this.telefono_alumno = telefono_alumno;
        this.email_alumno = email_alumno;
        this.estatus_alumno = estatus_alumno;    
    }

    public String getCarnet_alumno() {
        return carnet_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    public String getEmail_alumno() {
        return email_alumno;
    }

    public String getEstatus_alumno() {
        return estatus_alumno;
    }

    public void setCarnet_alumno(String carnet_alumno) {
        this.carnet_alumno = carnet_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    public void setEmail_alumno(String email_alumno) {
        this.email_alumno = email_alumno;
    }

    public void setEstatus_alumno(String estatus_alumno) {
        this.estatus_alumno = estatus_alumno;
    }

    @Override
    public String toString() {
        return "clsAlumnos{" + "carnet_alumno=" + carnet_alumno + ", nombre_alumno=" + nombre_alumno + ", direccion_alumno=" + direccion_alumno + ", telefono_alumno=" + telefono_alumno + ", email_alumno=" + email_alumno + ", estatus_alumno=" + estatus_alumno + '}';
    }

    public void setCodigo_sede(String codigo_sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNombre_sede(String nombre_alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setEstatus_sede(String estatus_sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCodigo_sede() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEstatus_sede() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre_sede() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
