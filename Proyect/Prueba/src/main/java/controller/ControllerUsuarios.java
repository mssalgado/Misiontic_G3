package controller;

import dao.DAOUsuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOUsuarios;

public class ControllerUsuarios {

    DAOUsuarios usuariosDAO = new DAOUsuarios();

    public int insertarUsuario(TOUsuarios ToUsuario) {
 
        return usuariosDAO.insertarUsuario(ToUsuario);
    }

    public boolean actualizarUsuario(TOUsuarios ToUsuario) {
        ToUsuario.setIdUsuarios(ToUsuario.getIdUsuarios());
        return usuariosDAO.actualizarUsuario(ToUsuario);
    }

    public boolean eliminarUsuario(TOUsuarios ToUsuario) {
        usuariosDAO.eliminarUsuario(ToUsuario.getIdUsuarios()); 
        return usuariosDAO.eliminarUsuario(ToUsuario.getIdUsuarios());
    }

    public ArrayList<TOUsuarios> listarUsuarios() {
        return usuariosDAO.listarUsuarios();
    }
    
    public TOUsuarios verificarUsuario(String nombreUsuario, String clave) {
        return usuariosDAO.verificarUsuario(nombreUsuario, clave);
    }
}

