package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conn = null;
    private static Conexion conexion;

    private Conexion() throws SQLException, ClassNotFoundException{
        this.createConexion();
    }

    public static Conexion getInstance() throws SQLException, ClassNotFoundException{
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }

    private void createConexion()throws SQLException, ClassNotFoundException{
        String urlDatabase =  "jdbc:mysql://localhost:1521/examen";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(urlDatabase,  "mysql", "Azul");
    }

    public Connection getConn() {
        return conn;
    }
}
