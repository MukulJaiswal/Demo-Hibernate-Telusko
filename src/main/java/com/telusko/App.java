package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
	public static void main(String[] args) {
		
		
		AlienName an = new AlienName();
		an.setFname("Mukul");
		an.setMname("Rockhard");
		an.setLname("Jaiswal");
		
		Alien alien = new Alien();
		
		alien.setAid(101);
		
		//This time name is an Object.
		//How many fields it can create.
		//Using @Embeddable we can make changes in existing tab
		alien.setAname(an); 
		
		alien.setColor("Green");

		
		Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry registry  = 
				 new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(registry);
		Session session = sf.openSession();
		
		Transaction tx =  session.beginTransaction();
		
		session.save(alien);
		tx.commit();
		
	}
}
