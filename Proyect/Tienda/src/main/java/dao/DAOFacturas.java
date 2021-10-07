package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import to.TOFacturas;

public class DAOFacturas {

    private ConexionDB con;
    private final String nombreTabla = "facturas";
    

    public DAOFacturas() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOFacturas.constructor: " + ex.getMessage());
        }
    }

    public int insertarFactura(TOFacturas ToFactura) {
        String[] valores = {String.valueOf(ToFactura.getIdUsuario()), String.valueOf(ToFactura.getValorTotal()),
            ToFactura.getFechaCompra().toString(),ToFactura.getTipoFactura()};
        try {
            return con.insertar(nombreTabla, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOFacturas.insertarFactura: " + ex.getMessage());
            return 0;
        }
    }

    public boolean actualizarFactura(TOFacturas ToFactura) {
        String[] valores = {String.valueOf(ToFactura.getIdUsuario()), String.valueOf(ToFactura.getValorTotal()),
            ToFactura.getFechaCompra().toString(),ToFactura.getTipoFactura()};
        try {
            return con.actualizar(nombreTabla, valores, ToFactura.getIdFacturas());
        } catch (Exception ex) {
            System.out.println("Error en DAOFacturas.actualizarFactura: " + ex.getMessage());
            return false;
        }
    }
/*
    public boolean eliminarFactura(int idFactura) {

        try {
            return con.borrar(nombreTabla, idFactura);
        } catch (Exception ex) {
            System.out.println("Error en DAOFacturas.eliminarFactura: " + ex.getMessage());
            return false;
        }
    }
*/
    public ArrayList<TOFacturas> listarFacturas() {
        ArrayList<TOFacturas> facturas = new ArrayList<>();
        TOFacturas factura;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                factura = new TOFacturas();
                //factura.setApellidos(rs.getString("apellidos"));
                

            }
            return facturas;
        } catch (SQLException ex) {
            System.out.println("Error en DAOFacturas.listarFacturas: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOFacturas.listarFacturas: " + ex.getMessage());
            return null;
        }
    }

}
