package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Fetch 
{
	public static void main(String[] args) {
		
		Alien alien = new Alien();
		alien.setAid(10101);
		//alien.setAname("Ricky Ponting");
		alien.setColor("Green");
		
		Configuration con =
				new Configuration().configure().addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg = 
				new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		alien = (Alien) session.get(Alien.class, 10101);
		
		tx.commit();
		System.out.println(alien);
		
	}
}

