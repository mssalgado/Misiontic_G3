package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import to.TOUsuarios;

public class DAOUsuarios {

    private ConexionDB con;
    private final String nombreTabla = "usuarios";
    

    public DAOUsuarios() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.constructor: " + ex.getMessage());
        }
    }

    public int insertarUsuario(TOUsuarios ToUsuario) {
        //if(ToUsuario.getFechaNacimiento()== null){
         //   ToUsuario.setFechaNacimiento("1900-01-01");
        //}        
        
        try {
            String[] valores = {String.valueOf(ToUsuario.getIdUsuarios()),ToUsuario.getNombreUsuario(), ToUsuario.getClave(), ToUsuario.getRolUsuario(), ToUsuario.getNombres(),
            ToUsuario.getApellidos(), ToUsuario.getGenero(), ToUsuario.getFechaNacimiento(), ToUsuario.getTipoIdentificacion(),
            ToUsuario.getNumeroIdentificacion(), ToUsuario.getDireccion(), ToUsuario.getTelefono(), ToUsuario.getCorreoPersonal(),
            ToUsuario.getCiudadDomicilio()};
            return con.insertar(nombreTabla, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario: " + ex.getMessage());
            return 0;
        }
    }
        /*try {
            String[] valores = {String.valueOf(ToUsuario.getIdUsuarios()), ToUsuario.getNombreUsuario(), ToUsuario.getClave(), ToUsuario.getRolUsuario(), ToUsuario.getNombres(),
            ToUsuario.getApellidos(), ToUsuario.getGenero(),String.valueOf(ToUsuario.getFechaNacimiento()), ToUsuario.getTipoIdentificacion(),
            ToUsuario.getNumeroIdentificacion(), ToUsuario.getDireccion(), ToUsuario.getTelefono(), ToUsuario.getCorreoPersonal(),
            ToUsuario.getCiudadDomicilio()};
            return con.insertar(nombreTabla, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuario: " + ex.getMessage());
            return 0;
        }
        
    }*/
    public boolean actualizarUsuario(TOUsuarios ToUsuario) {
        
        try {
            String[] valores = {String.valueOf(ToUsuario.getIdUsuarios()),ToUsuario.getNombreUsuario(), ToUsuario.getClave(), ToUsuario.getRolUsuario(), ToUsuario.getNombres(),
            ToUsuario.getApellidos(), ToUsuario.getGenero(), ToUsuario.getFechaNacimiento(), ToUsuario.getTipoIdentificacion(),
            ToUsuario.getNumeroIdentificacion(), ToUsuario.getDireccion(), ToUsuario.getTelefono(), ToUsuario.getCorreoPersonal(),
            ToUsuario.getCiudadDomicilio()};
            return con.actualizar(nombreTabla, valores, ToUsuario.getIdUsuarios());
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.actualizarUsuario: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(int idUsuario) {

        try {
            return con.borrar(nombreTabla, idUsuario);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.eliminarUsuario: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOUsuarios> listarUsuarios() {
        ArrayList<TOUsuarios> usuarios = new ArrayList<>();
        TOUsuarios usuario;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                usuario = new TOUsuarios();
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCiudadDomicilio(rs.getString("ciudadDomicilio"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCorreoPersonal(rs.getString("correoPersonal"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setIdUsuarios(rs.getInt("idUsuarios"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                usuario.setRolUsuario(rs.getString("rolUsuario"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                usuario.setFechaNacimiento(rs.getString("fechaNacimiento"));
                usuarios.add(usuario);

            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuarios.listarUsuarios: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.listarUsuarios: " + ex.getMessage());
            return null;
        }
    }
    
   
    public TOUsuarios verificarUsuario(String nombreUsuario, String clave){
        String condicion = " nombreUsuario = '" + nombreUsuario + "' AND clave = '" + clave + "'";
        TOUsuarios usuarioTO = new TOUsuarios();
        try {
            ResultSet rs = con.consultarWhere(nombreTabla, condicion);
            while (rs.next()) {
                
                usuarioTO.setApellidos(rs.getString("apellidos"));
                usuarioTO.setCiudadDomicilio(rs.getString("ciudadDomicilio"));
                usuarioTO.setClave(rs.getString("clave"));
                usuarioTO.setCorreoPersonal(rs.getString("correoPersonal"));
                usuarioTO.setDireccion(rs.getString("direccion"));
                usuarioTO.setGenero(rs.getString("genero"));
                usuarioTO.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarioTO.setNombreUsuario(rs.getString("nombreUsuario"));
                usuarioTO.setNombres(rs.getString("nombres"));
                usuarioTO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                usuarioTO.setRolUsuario(rs.getString("rolUsuario"));
                usuarioTO.setTelefono(rs.getString("telefono"));
                usuarioTO.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                usuarioTO.setFechaNacimiento(rs.getString("fechaNacimiento"));
            }
            return usuarioTO;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuarios.verificarUsuario: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.verificarUsuario: " + ex.getMessage());
            return null;
        }
    }
    

}
