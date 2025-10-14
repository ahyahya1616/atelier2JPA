package ma.fstt.firstjpa.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ma.fstt.firstjpa.entities.LignePanier;

public class LignePanierService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstJPA");

    public void ajouterLigne(LignePanier ligne) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ligne);
        em.getTransaction().commit();
        em.close();
    }
}
