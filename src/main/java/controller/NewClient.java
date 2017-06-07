package controller;

import java.io.IOException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Client;
import service.ClientService;

@WebServlet(name = "NewClient", urlPatterns = {"/NewClient"})
public class NewClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewClient() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    public static final String CHAMP_PRENOM = "FirstName";
    public static final String CHAMP_NOM = "LastName";
    public static final String CHAMP_ADDRESS = "address";
    public static final String CHAMP_EMAIL = "em";
    public static final String CHAMP_PHONE = "phone";
    public static final String VUE_FORM = "/WEB-INF/InscriptionClient.jsp";
    public static final String VUE_SUCCES = "AcceuilServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String nom = getValeurChamp(request,CHAMP_NOM);
        String prenom = getValeurChamp(request,CHAMP_PRENOM);
        String address = getValeurChamp(request,CHAMP_ADDRESS);
        String tel = getValeurChamp(request,CHAMP_PHONE);
        String email = getValeurChamp(request,CHAMP_EMAIL);
        Client client = new Client();
        System.out.println(client.toString());
        ClientService clientService = new ClientService();
        clientService.addClient(client);
        response.sendRedirect(VUE_SUCCES);
	}
	
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }

}
