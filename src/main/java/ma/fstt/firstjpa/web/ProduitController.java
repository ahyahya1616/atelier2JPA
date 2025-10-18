package ma.fstt.firstjpa.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.entities.Produit;
import ma.fstt.firstjpa.services.ProduitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produit")
public class ProduitController extends HttpServlet {

    @Inject
    private ProduitService produitService; // ✅ CDI s’en charge

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        HttpSession session = request.getSession();
        Internaute internaute = (Internaute) session.getAttribute("internaute");

        if (internaute == null) {
            response.sendRedirect("internaute?action=loginForm");
            return;
        }

        switch (action) {
            case "addToCart": {
                Long produitId = Long.parseLong(request.getParameter("id"));
                Produit produit = produitService.findById(produitId);

                List<LignePanier> panier = (List<LignePanier>) session.getAttribute("panier");
                if (panier == null) {
                    panier = new ArrayList<>();
                }

                boolean found = false;
                for (LignePanier lp : panier) {
                    if (lp.getProduit().getId().equals(produit.getId())) {
                        lp.setQuantite(lp.getQuantite() + 1);
                        lp.setSousTotal(lp.getQuantite() * produit.getPrix());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    LignePanier ligne = new LignePanier();
                    ligne.setProduit(produit);
                    ligne.setQuantite(1);
                    ligne.setSousTotal(produit.getPrix());
                    panier.add(ligne);
                }

                session.setAttribute("panier", panier);
                response.sendRedirect("produit?action=list");
                break;
            }

            default: {
                List<Produit> produits = produitService.getAllProduits();
                request.setAttribute("produits", produits);
                request.getRequestDispatcher("/WEB-INF/views/internaute/dashboard.jsp")
                        .forward(request, response);
                break;
            }
        }
    }
}
