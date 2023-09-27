package hibernate_01_basics;

import hibernate_01_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo4 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSurname("NewSurname");

            session
                    .createNativeQuery("update employees set salary = 2500 where salary >= 2000", Employee.class)
                    .executeUpdate();

//            System.out.println(employee);

            session.getTransaction().commit();
        }
    }
}
