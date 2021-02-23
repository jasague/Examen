package negocio;

import java.sql.SQLException;

import persistencia.AccesoCuentasBancarias;

public class Cajero {
    
    public double consultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldo(idCuenta);
    }
    
    //Consultar saldo CDT
     public double consultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldoCDT(idInversion);
    }
     
     //Consulta saldo total
      public double consultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldoTotal(nif);
    }
    
}