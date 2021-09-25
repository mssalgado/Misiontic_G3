package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import to.TOUsuarios;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuarios {

    private ConexionDB con;
    private final String nombreTabla = "usuarios";
    private final String[] columnas = {"nombreUsuario", "clave", "rolUsuario", "nombres", "apellidos", "genero", "fechaNacimiento",
        "tipoIdentificacion", "numeroIdentificacion", "direccion", "telefono", "correoPersonal", "ciudadDomicilio"};

    public DAOUsuarios() {
        try {
        con = new ConexionDB();
        } catch (Exception ex) {
        System.out.println("Error en DAOUsuarios.constructor: " + ex.getMessage());
        }
    }

    public int insertarUsuario(TOUsuarios ToUsuario) {
        String[] valores = {ToUsuario.getNombreUsuario(), ToUsuario.getClave(), ToUsuario.getRolUsuario(), ToUsuario.getNombres(), ToUsuario.getApellidos(), ToUsuario.getGenero(), ToUsuario.getFechaNacimiento().toString(),
            ToUsuario.getTipoIdentificacion(), ToUsuario.getNumeroIdentificacion(), ToUsuario.getDireccion(), ToUsuario.getTelefono(), ToUsuario.getCorreoPersonal(), ToUsuario.getCiudadDomicilio()};
        try {
            return con.insertar(nombreTabla, columnas, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario" + ex.getMessage());
            return 0;
        }
    }

    public boolean actualizarUsuario(TOUsuarios ToUsuario) {
        String[] valores = {ToUsuario.getNombreUsuario(), ToUsuario.getClave(), ToUsuario.getRolUsuario(), ToUsuario.getNombres(), ToUsuario.getApellidos(), ToUsuario.getGenero(), ToUsuario.getFechaNacimiento().toString(),
            ToUsuario.getTipoIdentificacion(), ToUsuario.getNumeroIdentificacion(), ToUsuario.getDireccion(), ToUsuario.getTelefono(), ToUsuario.getCorreoPersonal(), ToUsuario.getCiudadDomicilio()};
        try {
            return con.actualizar(nombreTabla, columnas, valores, ToUsuario.getIdUsuarios());
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario" + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(int idUsuario) {
        try {
            return con.borrar(nombreTabla, idUsuario);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.elimnarUsuario" + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOUsuarios> listarUsuario(TOUsuarios ToUsuario) {
        ArrayList<TOUsuarios> usuarios = new ArrayList<>();
        TOUsuarios usuario;
        try {
            ResultSet rs = con.consultartabla(nombreTabla);
            while(rs.next()){
                usuario = new TOUsuarios();
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCiudadDomicilio(rs.getString("ciudadDomicilio"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCorreoPersonal(rs.getString("correoPersonal"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setIdUsuarios(rs.getInt("idUsuarios"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                usuario.setRolUsuario(rs.getString("rolUsuario"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipoIdentificacion(rs.getString("tipoIdentifiacion"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario" + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario" + ex.getMessage());
            return null;
        }
    }
}
