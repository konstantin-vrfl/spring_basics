package hibernate_01_basics;

import hibernate_01_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo1 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Name", "Surname", "Department", 1000);

            session.beginTransaction();
//            session.save(employee); //deprecated
            session.persist(employee);
            session.getTransaction().commit();
        }
    }
}
