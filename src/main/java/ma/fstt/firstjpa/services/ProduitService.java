package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import ma.fstt.firstjpa.entities.Produit;
import java.util.List;

@ApplicationScoped
public class ProduitService {

    @Inject
    private EntityManager em;

    public List<Produit> getAllProduits() {
        return em.createQuery("SELECT p FROM Produit p", Produit.class)
                .getResultList();
    }

    public Produit findById(Long id) {
        return em.find(Produit.class, id);
    }
}
