package ma.fstt.firstjpa.services;

import jakarta.persistence.*;
import ma.fstt.firstjpa.entities.Produit;
import java.util.List;

public class ProduitService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstJPA");

    public List<Produit> getAllProduits() {
        EntityManager em = emf.createEntityManager();
        List<Produit> produits = null;
        try {
            produits = em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
        } finally {
            em.close();
        }
        return produits;
    }

    public Produit findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Produit produit = em.find(Produit.class, id);
        em.close();
        return produit;
    }


}
