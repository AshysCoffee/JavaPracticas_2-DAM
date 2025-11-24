package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Persona persona = new Persona("Sofia", 20);
		session.save(persona);
		
		transaction.commit();
		session.close();
		
		HibernateUtil.shutdown();
	}

}
