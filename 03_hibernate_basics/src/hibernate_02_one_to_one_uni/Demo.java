package hibernate_02_one_to_one_uni;

import hibernate_02_one_to_one_uni.entity.Detail;
import hibernate_02_one_to_one_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

            //to avoid connection leaks if get(employee) returns null, employee.getDetail() throws NPE
            Session session = sessionFactory.getCurrentSession()) {

            Employee employee = new Employee("Name", "Surname", "Department", 1000);
            Detail detail = new Detail("City", "PhoneNumber", "Email");
            employee.setDetail(detail);

            session.beginTransaction();
            session.persist(employee);

            employee = session.get(Employee.class, 1);
            System.out.println(employee.getDetail());

            session.getTransaction().commit();
        }
    }
}
