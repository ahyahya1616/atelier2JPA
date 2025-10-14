package ma.fstt.firstjpa.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ma.fstt.firstjpa.entities.LignePanier;
import ma.fstt.firstjpa.entities.Panier;

import java.util.List;

public class PanierService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstJPA");

    public void ajouterPanier(Panier panier) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(panier);
        em.getTransaction().commit();
        em.close();
    }

    public List<Panier> getAllPaniers() {
        EntityManager em = emf.createEntityManager();
        List<Panier> paniers = em.createQuery("SELECT p from Panier p", Panier.class).getResultList();
        em.close();
        return paniers;
    }

    public Panier getPanierById(Long id) {
        EntityManager em = emf.createEntityManager();
        Panier panier = em.find(Panier.class, id);
        em.close();
        return panier;
    }

    public void mettreAJourTotal(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Panier panier = em.find(Panier.class, id);
        if (panier != null) {
            double total = panier.getLignesPanier().stream()
                    .mapToDouble(LignePanier::getSousTotal)
                    .sum();
            panier.setTotal(total);
        }
        em.getTransaction().commit();
        em.close();
    }
}
