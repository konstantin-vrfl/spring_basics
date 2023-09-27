package hibernate_06_many_to_many;

import hibernate_06_many_to_many.entity.Child;
import hibernate_06_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Section section1 = new Section("Section1");
            Child child1 = new Child("Name1", 11);
            Child child2 = new Child("Name1", 12);
            Child child3 = new Child("Name1", 13);
            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);

            Child child4 = new Child("Name4", 14);
            Section section4 = new Section("Section2");
            Section section5 = new Section("Section3");
            Section section6 = new Section("Section4");
            child4.addSection(section4);
            child4.addSection(section5);
            child4.addSection(section6);

            session.beginTransaction();

            session.persist(section1);
            session.persist(child4);

//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());

            session.getTransaction().commit();
        }
    }
}
