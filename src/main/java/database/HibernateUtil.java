package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateUtil {
    public static boolean checkLogin(String email, String pass) {
        Transaction transaction = null;
        Session session = null;
        List user = null;
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(entity.Users.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.build());

            session = factory.openSession();
            transaction = session.beginTransaction();

            user = session.createQuery("FROM entity.Users WHERE emailAddress =: email AND password =: pass")
                    .setParameter("email", email)
                    .setParameter("pass", pass)
                    .list();

            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            assert session != null;
            session.close();
        }
        return !user.isEmpty();
    }
}
