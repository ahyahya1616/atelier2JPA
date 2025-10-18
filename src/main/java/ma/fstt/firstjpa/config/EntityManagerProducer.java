package ma.fstt.firstjpa.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("firstJPA");

    @Produces
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
