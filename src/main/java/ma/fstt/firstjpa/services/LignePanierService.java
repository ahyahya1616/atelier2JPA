package ma.fstt.firstjpa.services;

import jakarta.persistence.EntityManager;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.entities.Panier;

import java.util.List;

public class LignePanierService {

    private EntityManager em;

    public LignePanierService(EntityManager em) {
        this.em = em;
    }

    public void ajouterLignesAuPanier(List<LignePanier> lignesSession, Panier panier) {
        for (LignePanier ligne : lignesSession) {
            LignePanier lp = new LignePanier();
            lp.setProduit(ligne.getProduit());
            lp.setQuantite(ligne.getQuantite());
            lp.setSousTotal(ligne.getSousTotal());
            lp.setPanier(panier);
            em.persist(lp);
        }
    }
}
