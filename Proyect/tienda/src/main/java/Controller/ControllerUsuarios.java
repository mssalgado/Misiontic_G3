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

        return usuariosDAO.actualizarUsuario(ToUsuario);
    }

    public boolean eliminarUsuario(int idUsuario) {

        return usuariosDAO.eliminarUsuario(idUsuario);
    }

    public ArrayList<TOUsuarios> listarUsuarios() {
        return usuariosDAO.listarUsuarios();
    }
}
