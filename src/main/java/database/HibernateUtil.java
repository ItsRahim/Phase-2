package database;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static boolean checkLogin(String email, String pass) {
        //TODO: Implement a login validation
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(entity.Users.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.build());

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("FROM users WHERE email_address =: email AND password =: pass");
            query.setParameter("email", email);
            query.setParameter("pass", pass);

            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return true;
    }
}
