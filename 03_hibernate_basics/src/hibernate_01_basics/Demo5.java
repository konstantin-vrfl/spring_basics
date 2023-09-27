package hibernate_01_basics;

import hibernate_01_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo5 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, );
//            session.remove(employee);

            session
                    .createNativeQuery("delete from employees where id > 1", Employee.class)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }
}
