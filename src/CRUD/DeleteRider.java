package CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import CRUD.entity.Rider;

public class DeleteRider {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Rider.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Pobranie z bazy wpisu dla id = 4
			//Rider rider = session.get(Rider.class, 4);
			//Usuniecie z bazy wpisu dla id = 4 (pobrany obiekt)
			//session.delete(rider);
			
			//Usuniecie wpisu z bazy dla id = 4 bez wczesniejszego pobierania obiektu
			session.createQuery("delete from Rider where id=4").executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
