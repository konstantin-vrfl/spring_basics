package hibernate_01_basics;

import hibernate_01_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = session
                .createNativeQuery("select * from employees", Employee.class)
                .getResultList();
//            List<Employee> employees = session
////                    .createNativeQuery("select * from employees where name = 'name2'", Employee.class) //<-value is not case sensitive
//                    .createNativeQuery("select * from employees where salary >= 2000", Employee.class)
//                    .getResultList();

            employees.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
