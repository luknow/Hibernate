package EagerLazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;

public class EagerLazy {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Pobranie instruktora ktorego id = 1
			Instructor instructor = session.get(Instructor.class, 1);
			//Wyswietlenie informacji o kursach instruktora
			System.out.println("Kursy: "+instructor.getCourses());
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
