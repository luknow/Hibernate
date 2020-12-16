package MappingMTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Course;
import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
import Mapping.entity.Review;
import Mapping.entity.Student;

public class GetCoursesForStudent {

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
			//Wyswietlenie kursow studenta
			System.out.println(student.getCourses());
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





