package hibernate_01_basics;

import hibernate_01_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo2 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Name2", "Surname2", "Department2", 2000);

            session.beginTransaction();
//            session.save(employee); //deprecated
            session.persist(employee);
//            session.getTransaction().commit(); //we are doing several actions in one transaction

            int id = employee.getId();
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
            Employee storedEmployee = session.get(Employee.class, id);
            session.getTransaction().commit();

            System.out.println(storedEmployee);
        }
    }
}
