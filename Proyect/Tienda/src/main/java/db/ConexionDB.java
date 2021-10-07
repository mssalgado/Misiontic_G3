package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private String DB_driver = "";
    private String url = "";
    private String db = "";
    private String host = "";
    private String username = "";
    private String password = "";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public ConexionDB() {
        DB_driver = "com.mysql.jdbc.Driver";
        host = "localhost:3306";
        db = "tienda_virtual_v2";
        url = "jdbc:mysql://" + host + "/" + db;
        username = "root";
        password = "root";

        try {
            Class.forName(DB_driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(8);
            System.out.println("Conectado");
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            con.setAutoCommit(true);
            return con;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

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

    public boolean commitDB() {
        try {
            con.commit();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rollBack() {
        try {
            con.rollback();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<String> getColumns(String nombreTabla) {
        ArrayList<String> columnas = new ArrayList<>();
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"
                + db + "' AND TABLE_NAME = '" + nombreTabla + "' ORDER BY ORDINAL_POSITION";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (!rs.getString("COLUMN_NAME").equals("id" + nombreTabla)) {
                    columnas.add(rs.getString("COLUMN_NAME"));
                }
            }
            return columnas;
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

    public ResultSet consultarTabla(String nombreTabla) {
        String query = "SELECT * FROM " + nombreTabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

    public ResultSet consultarWhere(String nombreTabla, String condicion) {
        String query = "SELECT * FROM " + nombreTabla + " WHERE " + condicion;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

    public ResultSet consultarVista(String nombreTabla) {
        String query = "SELECT * FROM vista " + nombreTabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

    public int insertar(String nombreTabla, String[] valores) {

        ArrayList<String> columnas = getColumns(nombreTabla);
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(nombreTabla);
        query.append(" (");
        for (int i = 0; i < columnas.size(); i++) {
            query.append(columnas.get(i));
            if ((i+1) < columnas.size()) {
                query.append(",");
            }
        }
        query.append(") VALUES (");

        for (int i = 0; i < valores.length; i++) {
            query.append("'");
            query.append(valores[i]);
            query.append("'");
            if ((i+1) < valores.length) {
                query.append(",");
            }
        }
        query.append(")");

        try {
            stmt = con.createStatement();
            int columnasAfectadas = stmt.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
            if (columnasAfectadas == 0) {
                throw new SQLException("No se pudo guardar el registro");
            }
            ResultSet idsGenerados = stmt.getGeneratedKeys();
            if (idsGenerados.next()) {
                return idsGenerados.getInt(1);
            } else {
                return 0;
            }
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

    public boolean actualizar(String nombreTabla, String[] valores, int id) {

        ArrayList<String> columnas = getColumns(nombreTabla);
        StringBuilder query = new StringBuilder(" UPDATE ");
        query.append(nombreTabla);
        query.append(" SET ");
        for (int i = 0; i < valores.length; i++) {
            query.append(columnas.get(i));
            query.append(" = '");
            query.append(valores[i]);
            if ((i+1) < valores.length) {
                query.append("',");
            }
        }
        query.append("' WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);
        

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query.toString());
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
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(nombreTabla);
        query.append(" WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query.toString());
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
