package ma.fstt.firstjpa.services;

import jakarta.persistence.*;
import ma.fstt.firstjpa.entities.Internaute;

public class InternauteService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstJPA");

    public void inscrire(Internaute internaute) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(internaute);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Internaute connexion(String email, String password) {
        EntityManager em = emf.createEntityManager();
        Internaute internaute = null;
        try {
            internaute = em.createQuery(
                            "SELECT i FROM Internaute i WHERE i.email = :email AND i.password = :pwd",
                            Internaute.class)
                    .setParameter("email", email)
                    .setParameter("pwd", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            internaute = null; // Aucun utilisateur trouvé
        } finally {
            em.close();
        }
        return internaute;
    }
}
