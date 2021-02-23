package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.CDT;
import persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SCDT
 */
@WebServlet("/scdt")
public class SCDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCDT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccesoCuentasBancarias acb = new AccesoCuentasBancarias();
		boolean exito = false;
		
		if (request.getParameter("accion")!=null) {
			
			if (request.getParameter("accion").equals("CrearCDT")) {
				
				int cuenta;
				double interes, monto;
				CDT inversion;
				try {
	                cuenta = Integer.parseInt(request.getParameter("cuenta"));
	                interes = Double.parseDouble(request.getParameter("interes"));
	                monto = Double.parseDouble(request.getParameter("monto"));

	                inversion = new CDT(cuenta, interes, monto);

	                exito = acb.crearInversion(inversion);

	                if (exito) {
	                	request.setAttribute("jspresultado", "Se ha realizado el alta de su CDT correctamente");
						RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
						rd.forward(request, response);
						
	                } else {
	                	request.setAttribute("jsperror", "Se ha producido un error, no se realizó la acción correctamente");
						RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
						rd.forward(request, response);
	                 }

	            } catch (ClassNotFoundException | SQLException ex) {
	            	request.setAttribute("jsperror", "Se ha producido un error, no se realizó la acción correctamente");
					RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
					rd.forward(request, response);
	               
	            } catch (NumberFormatException ex) {
	            	request.setAttribute("jsperror", "Los datos deben ser numéricos");
					RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
					rd.forward(request, response);
				}
			}else {
				int cdt;
				try {
	                //2. Recoger los datos de los controles
	                cdt = Integer.parseInt(request.getParameter("cdt"));
	                //3 . Llamar al método correspondiente para cerrarla
	                exito = acb.cerrarInversion(cdt);
	                if (exito) {
	                	request.setAttribute("jspresultado", "Se ha realizado el cierre de su CDT correctamente");
						RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
						rd.forward(request, response);
	                } else {
	                	request.setAttribute("jsperror", "Se ha producido un error, no se realizó la acción correctamente");
						RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
						rd.forward(request, response);
	                }
	                
	            } catch (ClassNotFoundException | SQLException ex) {
                	request.setAttribute("jsperror", "Se ha producido un error en la BBDD, no se realizó la acción correctamente");
					RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
					rd.forward(request, response);
	            } catch (NumberFormatException ex) {
	            	request.setAttribute("jsperror", "Los datos deben ser numéricos");
					RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
					rd.forward(request, response);
	            }
				
			}
		}else {
			request.setAttribute("jsperror", "Selección de acción requerida");
			RequestDispatcher rd = request.getRequestDispatcher("/gestionarUnCDT.jsp");
			rd.forward(request, response);
		}
	}

}
