package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SVisualizarSaldos
 */
@WebServlet("/svisualizarsaldos")
public class SVisualizarSaldos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVisualizarSaldos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int datoNumerico;
		double saldo;
		AccesoCuentasBancarias acb = new AccesoCuentasBancarias();
		if (request.getParameter("accion")!=null) {
			if (request.getParameter("accion").equals("saldoCuenta")) {
		        try {
		            datoNumerico = Integer.parseInt(request.getParameter("datos"));
		            saldo = acb.consultaSaldo(datoNumerico);
		            request.setAttribute("jspresultado", saldo);
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
		        } catch (ClassNotFoundException | SQLException ex) {
	            	request.setAttribute("jsperror", "Se ha producido un error, no se realizó la acción correctamente");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
	               
	            } catch (NumberFormatException ex) {
	            	request.setAttribute("jsperror", "Los datos deben ser numéricos");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
				}
	        }

	        //En caso de que se seleccione el boton CDT
	        if (request.getParameter("accion").equals("saldoCDT")) {	 
	            try {
	            	datoNumerico = Integer.parseInt(request.getParameter("datos"));
	            	saldo = acb.consultaSaldoCDT(datoNumerico);
	            	request.setAttribute("jspresultado", saldo);
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
	            } catch (ClassNotFoundException | SQLException ex) {
	            	request.setAttribute("jsperror", "Se ha producido un error, no se realizó la acción correctamente");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
	               
	            } catch (NumberFormatException ex) {
	            	request.setAttribute("jsperror", "Los datos deben ser numéricos");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
				}
	        }

	       
	        if (request.getParameter("accion").equals("saldoCliente")) {
	        	
	            String numNIf = request.getParameter("datos");
	            try {
	            	saldo = acb.consultaSaldoTotal(numNIf);
	            	request.setAttribute("jspresultado", saldo);
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
	            } catch (ClassNotFoundException | SQLException ex) {
	            	request.setAttribute("jsperror","Se ha producido un error, no se realizó la acción correctamente");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
	            } catch (NumberFormatException ex) {
	            	request.setAttribute("jsperror", "Los datos deben ser numéricos");
					RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
					rd.forward(request, response);
				}
	        }
		}else {
			request.setAttribute("jsperror", "Seleccione una accion");
			RequestDispatcher rd = request.getRequestDispatcher("/visualizarSaldos.jsp");
			rd.forward(request, response);
		}
	}

}
