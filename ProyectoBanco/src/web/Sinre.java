package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Movimiento;
import persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class Sinre
 */
@WebServlet("/sinre")
public class Sinre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sinre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean exito = false;
		
		AccesoCuentasBancarias acb = new AccesoCuentasBancarias();
		Movimiento m1;
		
			if(request.getParameter("accion")!=null) {
				if (request.getParameter("accion").equals("Ingresar")) {
					try {
						int cuenta = Integer.valueOf(request.getParameter("cuenta"));
						double monto = Double.valueOf(request.getParameter("monto"));
						m1 = new Movimiento(monto, cuenta);
						exito = acb.Ingreso(m1);
						request.setAttribute("jspresultado", "Ingreso realizado");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
					} catch (ClassNotFoundException | SQLException ex) {
						request.setAttribute("jsperror", "Error en la BBDD, no se ha realizado la accion");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
			        } catch (NumberFormatException ex) {
			        	request.setAttribute("jsperror", "Los datos deben ser numéricos");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
			        }
				}else {
					try {
						int cuenta = Integer.valueOf(request.getParameter("cuenta"));
						double monto = Double.valueOf(request.getParameter("monto"));
						m1 = new Movimiento(monto, cuenta);
						exito = acb.retiro(m1);
						request.setAttribute("jspresultado", "Retiro realizado");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
					} catch (ClassNotFoundException | SQLException ex) {
						request.setAttribute("jsperror", "Error en la BBDD, no se ha realizado la accion");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
			        } catch (NumberFormatException ex) {
			        	request.setAttribute("jsperror", "Los datos deben ser numéricos");
						RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
						rd.forward(request, response);
			        }
				}
			}else {
				request.setAttribute("jsperror", "Selección de acción requerida");
				RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
				rd.forward(request, response);
			}
			
		
	}

}
