package MappingOTMBI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
/*
 * Mapowanie one to many bi directional
 */
public class CreateCourses {

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
			//Stworzenie 2 kursow
			Course javaCourse = new Course("Java dla pocz¹tkuj¹cych");
			Course pythonCourse = new Course("Python dla pocz¹tkuj¹cych");
			//Powiazanie instruktora z kursami
			instructor.add(javaCourse);
			instructor.add(pythonCourse);
			//Zapisanie kursow do bazy
			session.save(javaCourse);
			session.save(pythonCourse);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
