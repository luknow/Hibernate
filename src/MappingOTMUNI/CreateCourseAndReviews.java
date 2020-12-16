package MappingOTMUNI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
import Mapping.entity.Review;
/*
 * Mapowanie one to many uni directional
 */
public class CreateCourseAndReviews {

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
			//Utworzenie obiektu Course
			Course course = new Course("C++ dla pocz¹tkuj¹cych");
			//Pobranie Instruktora ktorego id = 1
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.add(course);
			//Stworzenie opinii do stworzonego kursu
			Review firstReview = new Review("Œwietny kurs");
			Review secondReview = new Review("Polecam!");
			//Dodanie opinii do stworzonego kursu
			course.AddReview(firstReview);
			course.AddReview(secondReview);
			session.save(course);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
