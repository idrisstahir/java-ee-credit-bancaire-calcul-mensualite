package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Credit;

@WebServlet(urlPatterns = {"/controleur", "*.do"})
public class ControleurServlet extends HttpServlet {
	
	private Credit metier = null;
	
	@Override
	public void init() throws ServletException {
		metier = new Credit();
	}
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setAttribute("model", new ModelMensualiteCredit());
		request.getRequestDispatcher("vue-mensualite-credit.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		double montant = Double.parseDouble(request.getParameter("montant"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		
		ModelMensualiteCredit modelCM = new ModelMensualiteCredit();
		
		modelCM.setMontant(montant);
		modelCM.setDuree(duree);
		modelCM.setTaux(taux);
		
		double mensualite = metier.calculMensualite(montant, duree, taux);
		modelCM.setMensualite(mensualite);
		
		request.setAttribute("model", modelCM);
		
		request.getRequestDispatcher("vue-mensualite-credit.jsp").forward(request, response);
	}
}
