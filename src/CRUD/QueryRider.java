package CRUD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import CRUD.entity.Rider;

public class QueryRider {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Rider.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			List <Rider> riders = new ArrayList();
			session.beginTransaction();
			//Utworzenie zapytania zawierajacego slowo kluczowe or
			//riders = session.createQuery("from Rider rider where rider.number='46' or rider.number='93'").list();
			
			//Utworenie zapytania zawierajacego slowo kluczowe Like
			riders = session.createQuery("from Rider rider where rider.nation LIKE 'ITA'").list();
			session.getTransaction().commit();
			for(int i=0;i<riders.size();i++) {
				System.out.println(riders.get(i).toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
