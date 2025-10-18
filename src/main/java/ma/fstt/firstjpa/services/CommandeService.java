package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.fstt.firstjpa.entities.Commande;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.entities.Panier;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CommandeService {

    @Inject
    private EntityManager em;

    @Inject
    private PanierService panierService;

    @Inject
    private LignePanierService lignePanierService;

    public void confirmerAchat(Internaute internaute, List<LignePanier> lignesSession) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Calcul du total du panier
            double totalPanier = 0.0;
            for (LignePanier lp : lignesSession) {
                totalPanier += lp.getSousTotal();
            }

            // Créer le panier
            Panier panier = panierService.creerPanier(internaute, totalPanier);

            // Ajouter les lignes du panier
            lignePanierService.ajouterLignesAuPanier(lignesSession, panier);

            // Créer la commande
            Commande commande = new Commande();
            commande.setDateCommande(LocalDate.now().toString());
            commande.setTotal(totalPanier);
            commande.setStatut("Confirmée");
            commande.setInternaute(internaute);

            em.persist(commande);

            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Commande> getCommandesByInternaute(Internaute internaute) {
        return em.createQuery(
                        "SELECT c FROM Commande c WHERE c.internaute = :internaute ORDER BY c.dateCommande DESC",
                        Commande.class)
                .setParameter("internaute", internaute)
                .getResultList();
    }
}
