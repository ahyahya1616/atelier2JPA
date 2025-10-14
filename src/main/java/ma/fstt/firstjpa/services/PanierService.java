package ma.fstt.firstjpa.services;

import jakarta.persistence.EntityManager;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.entities.Panier;

import java.time.LocalDate;

public class PanierService {

    private EntityManager em;

    public PanierService(EntityManager em) {
        this.em = em;
    }

    public Panier creerPanier(Internaute internaute, double totalPanier) {
        Panier panier = new Panier();
        panier.setDateCreation(LocalDate.now().toString());
        panier.setTotal(totalPanier);
        panier.setInternaute(internaute);

        em.persist(panier);
        return panier;
    }
}
