package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.entities.Panier;

import java.util.List;

@ApplicationScoped
public class LignePanierService {

    @Inject
    private EntityManager em;

    public void ajouterLignesAuPanier(List<LignePanier> lignesSession, Panier panier) {
        em.getTransaction().begin();
        for (LignePanier ligne : lignesSession) {
            LignePanier lp = new LignePanier();
            lp.setProduit(ligne.getProduit());
            lp.setQuantite(ligne.getQuantite());
            lp.setSousTotal(ligne.getSousTotal());
            lp.setPanier(panier);
            em.persist(lp);
        }
        em.getTransaction().commit();
    }
}
