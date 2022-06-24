
package inicial.modelo;
import inicial.controlador.clsUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoUsuario {
    private static final String SQL_SELECT = "SELECT usuid, usunombre, usucontrasena, usucorreoe, usutelefono, usudireccion FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(usunombre, usucontrasena, usucorreoe, usutelefono, usudireccion) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET usunombre=?, usucontrasena=?, usucorreoe=?, usutelefono=?, usudireccion=? WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERY = "SELECT usuid, usunombre, usucontrasena, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERYN = "SELECT usuid, usunombre, usucontrasena, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usunombre=?";    

    public List<clsUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsUsuario usuario = null;
        List<clsUsuario> usuarios = new ArrayList<clsUsuario>();
        try {
            conn = inicial.modelo.clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(rs);
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = inicial.modelo.clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());            
            stmt.setString(6, usuario.getUsucorreoe());
            stmt.setString(7, usuario.getUsutelefono());            
            stmt.setString(8, usuario.getUsudireccion());            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = inicial.modelo.clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());            
            stmt.setString(6, usuario.getUsucorreoe());
            stmt.setString(7, usuario.getUsutelefono());            
            stmt.setString(8, usuario.getUsudireccion());            
            stmt.setInt(9, usuario.getUsuid());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = inicial.modelo.clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getUsuid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        return rows;
    }

    public clsUsuario query(clsUsuario usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = inicial.modelo.clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getUsuid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(rs);
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
public clsUsuario queryn(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = inicial.modelo.clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getUsunombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuario.setUsucorreoe(correoe);
                usuario.setUsutelefono(telefono);
                usuario.setUsudireccion(direccion);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            inicial.modelo.clsConexion.close(rs);
            inicial.modelo.clsConexion.close(stmt);
            inicial.modelo.clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
    
}
