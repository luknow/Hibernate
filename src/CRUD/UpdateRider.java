package CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import CRUD.entity.Rider;

public class UpdateRider {

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
			//Zmiana motocykla z Yamaha na Ducati dla pobranego obiektu
			//Jako ze pobralismy wczesniej ten obiekt to nie trzeba pisac: session.save(rider)
			//rider.setBike("Ducati");
			
			//Aktualizacja u wszystkich motocyklistow ktorych narodowosc byla wloska na japonska
			//Odwolujemy sie w tym wpisie do obiektow i pol w obiekcie a nie do table i pol w tabeli  bo to HQL
			//patrz zapis Rider nation -> to pole nation obiektu Rider nie pole nation tabeli Rider
			session.createQuery("update Rider rider set rider.nation='JAP' where rider.nation='ITA'").executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
