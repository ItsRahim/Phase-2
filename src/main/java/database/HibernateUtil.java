package database;

import jakarta.persistence.*;
public class HibernateUtil {
    public static void HibernateConnection(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            /*
            Below is how you run a query through Hibernate, Stored Procedures can be created in the entity class directly
             */
            Query result = entityManager.createNativeQuery("SELECT airlines FROM Flights WHERE customer_id = ?");
            result.setParameter("customer_id", id);
            System.out.println(result.getSingleResult());

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
