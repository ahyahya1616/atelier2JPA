package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.entities.Panier;

import java.time.LocalDate;

@ApplicationScoped
public class PanierService {

    @Inject
    private EntityManager em;

    public Panier creerPanier(Internaute internaute, double totalPanier) {
        Panier panier = new Panier();
        panier.setDateCreation(LocalDate.now().toString());
        panier.setTotal(totalPanier);
        panier.setInternaute(internaute);

        em.getTransaction().begin();
        em.persist(panier);
        em.getTransaction().commit();

        return panier;
    }
}
