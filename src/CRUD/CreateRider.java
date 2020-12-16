package CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import CRUD.entity.Rider;

public class CreateRider {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Rider.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//Utworzenie obiektu nowego motocyklisty
			Rider rider = new Rider("20","Fabio Quartararo", "FRA", "Petronas Yamaha SRT", "Yamaha");
			session.beginTransaction();
			//Zapisanie go w bazie
			session.save(rider);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
