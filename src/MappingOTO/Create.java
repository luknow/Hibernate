package MappingOTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;
/*
 * Mapowanie one to one
 */
public class Create {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//Utworzenie obiektu Instruktor
			Instructor instructor = new Instructor("Lukas","Nazwisko", "lukas@mail.com");
			//Utworzenie obiektu InstructorDetail
			InstructorDetail instructorDetail = new InstructorDetail("youtube/kanal", "MotoGP");
			//Powiazanie obiektow 1 do 1
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			//Zapisanie obiektu instructor ale i obiektu instructorDetail przez adnotacje CascadeType.ALL w klasie Instructor
			session.save(instructor);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
