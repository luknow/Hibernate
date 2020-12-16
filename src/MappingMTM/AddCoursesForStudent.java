package MappingMTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
import Mapping.entity.Review;
import Mapping.entity.Student;

/*
 * Mapowanie many to many
 */
public class AddCoursesForStudent {

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
			//Pobranie studenta z bazy 
			Student student = session.get(Student.class, 1);
			//Utworzenie kursow 
			Course kursGitary = new Course("Gitara dla pocz¹tkuj¹cych");
			Course kursPrawaJazdy = new Course("Prawo jazdy dla pocz¹tkuj¹cych");
			//Przypisanie studenta do nowo utworzonych kursow
			kursGitary.AddStudent(student);
			kursPrawaJazdy.AddStudent(student);
			//Pobranie instruktora ktorego id = 1
			Instructor instructor = session.get(Instructor.class,1);
			//Przypisanie kursow do instruktora
			instructor.add(kursGitary);
			instructor.add(kursPrawaJazdy);
			//Zapisanie utworzonych kursow do bazy
			session.save(kursGitary);
			session.save(kursPrawaJazdy);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
