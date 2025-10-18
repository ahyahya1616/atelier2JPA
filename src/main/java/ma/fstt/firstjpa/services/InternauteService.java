package ma.fstt.firstjpa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import ma.fstt.firstjpa.entities.Internaute;

@ApplicationScoped
public class InternauteService {

    @Inject
    private EntityManager em;

    public void inscrire(Internaute internaute) {
        try {
            em.getTransaction().begin();
            em.persist(internaute);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Internaute connexion(String email, String password) {
        Internaute internaute = null;
        try {
            internaute = em.createQuery(
                            "SELECT i FROM Internaute i WHERE i.email = :email AND i.password = :pwd",
                            Internaute.class)
                    .setParameter("email", email)
                    .setParameter("pwd", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            internaute = null; // Aucun internaute trouvé
        }
        return internaute;
    }
}
