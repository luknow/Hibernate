package MappingMTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
import Mapping.entity.Review;
import Mapping.entity.Student;

public class CreateCourseAndStudents {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Utworzenie obiektu Course
			Course course = new Course("PHP dla pocz¹tkuj¹cych");
			//Pobranie Instruktora ktorego id = 1
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.add(course);
			//Zapisanie utworzonego kursu do bazy
			session.save(course);
			//Utworzenie studentow
			Student firstStudent = new Student("Lukas", "Nazwisko", "lukas@mail.com");
			Student secondStudent = new Student("Karolina", "Kot", "karolina@mail.com");
			//Dodanie studentow do kursu
			course.AddStudent(firstStudent);
			course.AddStudent(secondStudent);
			//Zapisanie utworzonych studentow do bazy
			session.save(firstStudent);
			session.save(secondStudent);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
