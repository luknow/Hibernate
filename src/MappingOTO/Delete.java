package MappingOTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Mapping.entity.Instructor;
import Mapping.entity.InstructorDetail;

public class Delete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Uni directional
			/*Instructor instructor = session.get(Instructor.class, 3);
			if(instructor != null) {
				//Usunie rowniez instructor_detail przez adnotacje CascadeType.ALL w klasie Instructor
				session.delete(instructor);
			}*/
			//Bi directional 
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			if(instructorDetail != null) {
				//Usunie rowniez instructor przez adnotacje CascadeType.ALL w klasie InstructorDetail
				session.delete(instructorDetail);
			}
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
