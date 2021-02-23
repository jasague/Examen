package persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import modelo.CDT;
import modelo.Movimiento;

public class AccesoCuentasBancarias extends Conexion{
    
    //Metodo Consulta Saldo
    
    public double consultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException
    {
        /*1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3a. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
*/
        //Declaracion JDBC
        CallableStatement cmd;
        ResultSet rs;
        //Otras variables
        double saldo=0;
        String sql = "EXEC CONSULTA_CC ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setInt(1, idCuenta);
        
        rs = cmd.executeQuery();
        
        if (rs.next()) {
            saldo = rs.getDouble("SALDO");            
        }
        
        cerrarConexion();
        cmd.close();
        rs.close();
        
        return saldo;
        
    }
    
    //Metodo de Consulta CDT
     public double consultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException
    {
        /*1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3a. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
*/
        //Declaracion JDBC
        CallableStatement cmd;
        ResultSet rs;
        //Otras variables
        double saldo=0;
        String sql = "EXEC CONSULTA_CDT ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setInt(1, idInversion);
        
        rs = cmd.executeQuery();
        
        if (rs.next()) {
            saldo = rs.getDouble("VALOR_INVERSION");            
        }
        
        cerrarConexion();
        cmd.close();
        rs.close();
        
        return saldo;
        
    }
     
     //Metodo de consultar saldo total
     public double consultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException
    {
        /*1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3a. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
*/
        //Declaracion JDBC
        CallableStatement cmd;
      
        //Otras variables
        double saldo=0;
        String sql = "EXEC SALDO_TOTAL ?,  ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setString(1, nif);
        //Registrar un parametro de salida
        cmd.registerOutParameter(2, Types.DOUBLE);
        
        cmd.execute();
        
        //Recoger el valor del parametro de salida
        saldo = cmd.getDouble(2);
        
        cerrarConexion();
        cmd.close();
        
        return saldo;
        
    }
     
     //M�todo para crear una inversion
     //Parametro de entrada -> CDT
     //Salida un boolean
     
     public boolean crearInversion(CDT inversion) throws ClassNotFoundException, SQLException{
         //1. Declarar variables
         //Declaraciones de JDBC
         CallableStatement sentencia;
         //Otras variables
         int resultado;
         String sql = "EXEC ALTA_INVERSION ?, ?, ?";
         //2. Abrir conexion
         abrirConexion();
         //3. Obtener la sentencia de la conexion
         sentencia = miConexion.prepareCall(sql);
         //3a. Dar valor a los parametros
         sentencia.setInt(1, inversion.getIdCuenta());
         sentencia.setDouble(2, inversion.getInteresesMensuales());
         sentencia.setDouble(3, inversion.getValorInversion());
         //4. Ejecutar el comando
         resultado = sentencia.executeUpdate();
         //5. Cerrar la conexion
         cerrarConexion();
         sentencia.close();
         //6. Devolver el resultado
         return (resultado > 0);
         
     }
     //M�todo para hacer un ingreso
     //Parametro de entrada -> movimiento con los datos de cuenta y cantidad
     //Salida un boolean
     public boolean Ingreso(Movimiento m1) throws ClassNotFoundException, SQLException{
         //1. Declarar variables
         //Declaraciones de JDBC
         CallableStatement sentencia;
         //Otras variables
         int resultado;
         String sql = "EXEC INGRESO ?,?";
         //2. Abrir conexion
         abrirConexion();
         //3. Obtener la sentencia de la conexion
         sentencia = miConexion.prepareCall(sql);
         //3a. Dar valor a los parametros
         sentencia.setInt(1, m1.getIdCuenta());
         sentencia.setDouble(2, m1.getCantidad());
         //4. Ejecutar el comando
         resultado = sentencia.executeUpdate();
         //5. Cerrar la conexion
         cerrarConexion();
         sentencia.close();
         //6. Devolver el resultado
         return (resultado > 0);
         
     }
     
     //M�todo para cerrar una inversion
     //Parametro de entrada --> idInversi�n
     //Parametro de salida --> Exito / no exito
     
     public boolean cerrarInversion(int idInversion) throws ClassNotFoundException, SQLException{
         //1.Declarar variables
         //1a. JDBC
         CallableStatement sentencia;
         // variables
         boolean exito = false;
         String sql = "EXEC CERRAR_INVERSION ?;";
         //2. Abrir conexi�n
         abrirConexion();
         //3. Recoger la sentencia de la conexi�n
         sentencia = miConexion.prepareCall(sql);
         //3a. Asignar valor a los par�metros
         sentencia.setInt(1, idInversion);
         
         //4. Ejecutar la sentencia 
         exito = sentencia.execute();
         //5. Cerrar conexi�n y la sentencia
         cerrarConexion();
         sentencia.close();
         //6. Devolver el resultado
         return exito;
         
     }
    
     
     //M�todo para hacer un retiro
     //Parametro de entrada -> movimiento con los datos de cuenta y cantidad
     //Salida un boolean
     public boolean retiro(Movimiento m1) throws ClassNotFoundException, SQLException{
         //1. Declarar variables
         //Declaraciones de JDBC
         CallableStatement sentencia;
         //Otras variables
         int resultado;
         String sql = "EXEC RETIRO ?,?";
         //2. Abrir conexion
         abrirConexion();
         //3. Obtener la sentencia de la conexion
         sentencia = miConexion.prepareCall(sql);
         //3a. Dar valor a los parametros
         sentencia.setInt(1, m1.getIdCuenta());
         sentencia.setDouble(2, m1.getCantidad());
         //4. Ejecutar el comando
         resultado = sentencia.executeUpdate();
         //5. Cerrar la conexion
         cerrarConexion();
         sentencia.close();
         //6. Devolver el resultado
         return (resultado > 0);
         
     }
     
     
      //Metodo de consultar simulacion
     public double simulacion(String nif) throws ClassNotFoundException, SQLException
    {
        /*1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3a. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
*/
        //Declaracion JDBC
        CallableStatement cmd;     
        //Otras variables
        double simulacion =0;
        String sql = "EXEC SIMULACION ?,  ?";       
        abrirConexion();    
        cmd = miConexion.prepareCall(sql);    
        cmd.setString(1, nif);
        //Registrar un parametro de salida
        cmd.registerOutParameter(2, Types.DOUBLE);       
        cmd.execute();
        
        //Recoger el valor del parametro de salida
        simulacion = cmd.getDouble(2);
        
        cerrarConexion();
        cmd.close();
        
        return simulacion;
        
    }
}
