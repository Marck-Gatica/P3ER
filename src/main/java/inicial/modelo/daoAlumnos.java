
package inicial.modelo;

import inicial.controlador.clsAlumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoAlumnos {
    
    private static final String SQL_SELECT2 = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre_alumno,direccion_alumno,telefono_alumno,email_alumno,estatus_alumno) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno = ?, direccion_alumno = ?, telefono_alumno = ?, email_alumno = ?, estatus_alumno = ? WHERE alumnos.carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE alumnos.carnet_alumno = ?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno = ?";

    public List<clsAlumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAlumnos usuario = null;
        List<clsAlumnos> usuarios = new ArrayList<clsAlumnos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet_alumno = rs.getString("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String telefono_alumno = rs.getString("telefono_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");


                usuario = new clsAlumnos();
                usuario.setCarnet_alumno(carnet_alumno);
                usuario.setNombre_alumno(nombre_alumno);
                usuario.setDireccion_alumno(direccion_alumno);
                usuario.setTelefono_alumno(telefono_alumno);
                usuario.setEmail_alumno(email_alumno);
                usuario.setEstatus_alumno(estatus_alumno);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsAlumnos estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, estudiante.getNombre_alumno());
            stmt.setString(2, estudiante.getDireccion_alumno());
            stmt.setString(3, estudiante.getTelefono_alumno());
            stmt.setString(4, estudiante.getEmail_alumno());
            stmt.setString(5, estudiante.getEstatus_alumno());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }
    
    //LLAVE PRIMARIA DE ULTIMO
    public int update(clsAlumnos estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, estudiante.getNombre_alumno());
            stmt.setString(2, estudiante.getDireccion_alumno());
            stmt.setString(3, estudiante.getTelefono_alumno());
            stmt.setString(4, estudiante.getEmail_alumno());
            stmt.setString(5, estudiante.getEstatus_alumno());
            stmt.setString(6, estudiante.getCarnet_alumno());



            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsAlumnos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, perfil.getCarnet_alumno());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsAlumnos query(clsAlumnos estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, estudiante.getCarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet_alumno = rs.getString("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String telefono_alumno = rs.getString("telefono_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");

                estudiante = new clsAlumnos();
                estudiante.setCarnet_alumno(carnet_alumno);
                estudiante.setNombre_alumno(nombre_alumno);
                estudiante.setDireccion_alumno(direccion_alumno);
                estudiante.setTelefono_alumno(telefono_alumno);
                estudiante.setEmail_alumno(email_alumno);
                estudiante.setEstatus_alumno(estatus_alumno);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return estudiante;
    }    
}
