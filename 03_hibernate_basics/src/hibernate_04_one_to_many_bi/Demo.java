package hibernate_04_one_to_many_bi;

import hibernate_04_one_to_many_bi.entity.Employee;
import hibernate_04_one_to_many_bi.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

//            Department department = new Department("Department", 1000, 5000);
//            Employee employee1 = new Employee("Name1", "Surname1", 1000);
//            Employee employee2 = new Employee("Name2", "Surname2", 2000);
//            department.addEmployee(employee1);
//            department.addEmployee(employee2);

            session.beginTransaction();
//            session.persist(department);
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            department.getEmployees().forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
