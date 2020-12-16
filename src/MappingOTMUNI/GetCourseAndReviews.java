package MappingOTMUNI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
import Mapping.entity.Review;

public class GetCourseAndReviews {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Pobranie kursu
			Course course = session.get(Course.class, 13);
			//Wyswietlenie opinii o kursie
			System.out.println(course.getReviews());
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
