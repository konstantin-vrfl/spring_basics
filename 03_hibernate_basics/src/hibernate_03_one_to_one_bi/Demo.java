package hibernate_03_one_to_one_bi;

import hibernate_03_one_to_one_bi.entity.Detail;
import hibernate_03_one_to_one_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

//            Employee employee = new Employee("Name4", "Surname4", "Department4", 4000);
//            Detail detail = new Detail("City4", "PhoneNumber4", "Email4");
//            detail.setEmployee(employee);
//            employee.setDetail(detail);
//
            session.beginTransaction();
//            session.persist(detail);
            Detail detail = session.get(Detail.class, 2);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
        }
    }
}
