package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	public static SessionFactory buildSessionFactory() {
		//El try-catch es lo mismo que un fichero, lo lee y lo carga si va bien sino erro
		try {
			//Carga todos los datos que hemos puesto en hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		}catch (Throwable e){
			System.err.println("Error: "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}	
	
	
	
	public static void shutdown() {
		getSessionFactory().close();
	}
	
	
	
}


