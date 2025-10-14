package ma.fstt.firstjpa.web;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.fstt.firstjpa.entities.Commande;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.services.CommandeService;

import java.io.IOException;
import java.util.List;

@WebServlet("/commande")
public class CommandeController extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("firstJPA");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();
        CommandeService commandeService = new CommandeService(em);

        HttpSession session = request.getSession();
        Internaute internaute = (Internaute) session.getAttribute("internaute");

        if (internaute == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if ("listCommande".equals(action)) {
            List<Commande> commandes = commandeService.getCommandesByInternaute(internaute);
            request.setAttribute("commandes", commandes);
            request.getRequestDispatcher("/WEB-INF/views/commande/listeCommandes.jsp").forward(request, response);
        }

        em.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = emf.createEntityManager();
        CommandeService commandeService = new CommandeService(em);

        HttpSession session = request.getSession();
        Internaute internaute = (Internaute) session.getAttribute("internaute");
        List<LignePanier> panier = (List<LignePanier>) session.getAttribute("panier");

        if (internaute == null || panier == null || panier.isEmpty()) {
            response.sendRedirect("produit?action=list");
            return;
        }

        //  Enregistrer la commande dans la BDD
        commandeService.confirmerAchat(internaute, panier);

        // Vider le panier de la session
        session.removeAttribute("panier");

        // Rediriger vers une page de confirmation
        request.setAttribute("message", "Votre commande a été confirmée avec succès !");
        request.getRequestDispatcher("/WEB-INF/views/commande/confirmation.jsp").forward(request, response);

        em.close();
    }

    @Override
    public void destroy() {
        emf.close();
    }
}
