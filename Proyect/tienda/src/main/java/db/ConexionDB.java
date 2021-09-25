package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionDB {

    private String DB_driver = "";
    private String url = "";
    private String db = "";
    private String host = "";
    private String username = "";
    private String password = "";
    public Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private boolean local;
//Constructor sin parmetros

    public ConexionDB() {
        local = true;//pude establecer este valor en falso para conectarse al servidor remoto
        DB_driver = "com.mysql.jdbc.Driver";
        if (local) {
            host = "localhost:3306";
            db = "nombreBaseDeDatos";
            url = "jdbc:mysql://" + host + "/" + db; //URL DB
            username = "root"; //usuario base de datos 
            password = "root";
        } else {
            host = "mysql1007.mochahost.com:3306";
            db = "tienda";
            url = "jdbc:mysql://" + host + "/" + db; //URL DB
            username = "root"; //usuario base de datos global 
            password = "root";
        }
        try {
//Asignacin del Driver
            Class.forName(DB_driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
// Realizar la conexion
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(8);
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Realizar la conexin
    }
//Retornar la conexin

    public Connection getConnection() {
        try {
            con.setAutoCommit(true);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//Cerrar la conexin

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean setAutocommitDB(boolean param) {
        try {
            con.setAutoCommit(param);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean commitDB(boolean param) {
        try {
            con.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean rollbackDB(boolean param) {
        try {
            con.rollback();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
// Mtodo que devuelve un ResultSet de una consulta (tratamiento de SELECT)

    public ResultSet consultartabla(String nombretabla) {
        String query = "SELECT * FROM" + nombretabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    public ResultSet consultarVista(String nombretabla) {
        String query = "SELECT * FROM vista" + nombretabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

// Metodo que realiza un INSERT 
    public int insertar(String nombreTabla, String[] columnas, String[] valores) {

        StringBuilder query = new StringBuilder("INSERT INTO");
        query.append(nombreTabla);
        query.append(" (");
        for (int i = 0; i < columnas.length; i++) {
            query.append(columnas[i]);
            if (i < columnas.length) {
                query.append(",");
            }
        }
        query.append(") VALUES(");
        for (int i = 0; i < valores.length; i++) {
            query.append("'");
            query.append(valores[i]);
            query.append("'");
            if (i < valores.length) {
                query.append(",");
            }
        }
        query.append(" )");

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query.toString());
            return rs.getInt("id" + nombreTabla);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }

    }
    // Metodo que realizar un UPDATE

    public boolean actualizar(String nombreTabla, String[] columnas, String[] valores, int id) {

        StringBuilder query = new StringBuilder("INSERT INTO");
        query.append(nombreTabla);
        query.append(" SET ");
        for (int i = 0; i < columnas.length; i++) {
            query.append(columnas[i]);
            query.append(" = '");
            query.append(valores[i]);
            query.append("'");
            if (i < columnas.length) {
                query.append(",");
            }
        }
        query.append("WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);

        try {
            stmt = con.createStatement();
            stmt.executeQuery(query.toString());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public boolean borrar(String nombreTabla, int id) {
        StringBuilder query = new StringBuilder("DELETE FROM");
        query.append(nombreTabla);
        query.append(" WHERE id ");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);
        try {
            stmt = con.createStatement();
            stmt.executeQuery(query.toString());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
