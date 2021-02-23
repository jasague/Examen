package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    protected Connection miConexion;
    
    public void abrirConexion() throws ClassNotFoundException, SQLException  {
        //Cargar el driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Definicion del String de conexion
        String stringConexion =  "jdbc:sqlserver://localhost:1433;" +
                       "databaseName=CUENTAS_BANCOS;" +
                       "user=J;" +
                        "password=alpha1234;" +
                      "encrypt=false;" +
                     "trustServerCertificate=false;" +
                      "loginTimeout=30;";
        //Obtener un objeto de tipo conexion
        miConexion = DriverManager.getConnection(stringConexion);
        
    }
    
    public void cerrarConexion() throws SQLException {
        miConexion.close();
    }
    
}
