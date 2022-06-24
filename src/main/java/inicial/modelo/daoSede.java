
package inicial.modelo;

import inicial.controlador.clsAlumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class daoSede {
    
    private static final String SQL_SELECT2 = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes";
    private static final String SQL_INSERT = "INSERT INTO sedes(nombre_sedes,estatus_alumno) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE sede SET nombre_sede = ?, estatus_sede = ? WHERE sedes.codigo_sede = ?";
    private static final String SQL_DELETE = "DELETE FROM sedes WHERE sedes.codigo_sede = ?";
    private static final String SQL_QUERY = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes WHERE codigo_sede = ?";

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
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_sede");
                String estatus_sede = rs.getString("estatus_sede");


                usuario = new clsAlumnos();
                usuario.setCodigo_sede(codigo_sede);
                usuario.setNombre_sede(nombre_sede);
                usuario.setEstatus_sede(estatus_sede);

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
            stmt.setString(1, estudiante.getNombre_sede());
            stmt.setString(5, estudiante.getEstatus_sede());
            stmt.setString(6, estudiante.getCodigo_sede());



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
            stmt.setString(1, perfil.getCodigo_sede());
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
            stmt.setString(1, estudiante.getCodigo_sede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_sede = rs.getString("codigo_sede");
                String nombre_sede = rs.getString("nombre_alumno");
                String estatus_sede = rs.getString("estatus_alumno");

                estudiante = new clsAlumnos();
                estudiante.setCodigo_sede(codigo_sede);
                estudiante.setNombre_sede(nombre_sede);
                estudiante.setEstatus_sede(estatus_sede);
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
