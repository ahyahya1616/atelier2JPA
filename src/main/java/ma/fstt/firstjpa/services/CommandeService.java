package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ma.fstt.firstjpa.entities.Commande;

import java.util.List;

@ApplicationScoped
public class CommandeService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstJPA");

    public void ajouterCommande(Commande commande) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(commande);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Commande> getAllCommandes() {
        EntityManager em = emf.createEntityManager();
        List<Commande> commandes = em.createQuery("SELECT c FROM Commande c", Commande.class)
                .getResultList();
        em.close();
        return commandes;
    }

    public Commande getCommandeById(Long id) {
        EntityManager em = emf.createEntityManager();
        Commande commande = em.find(Commande.class, id);
        em.close();
        return commande;
    }

    public void supprimerCommande(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Commande commande = em.find(Commande.class, id);
            if (commande != null) {
                em.remove(commande);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void modifierCommande(Commande commande) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(commande);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
