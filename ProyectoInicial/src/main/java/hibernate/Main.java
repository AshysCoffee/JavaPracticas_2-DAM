package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void insertarDatos(Session session, Transaction transaction ) {
		
		Persona persona = new Persona("Sofia", 20);
		session.save(persona);
		transaction.commit();
		
	}
	
	public static void lecturaDatos(Session session, Transaction transaction, int clavePrimaria) {
		
		Persona personaRecuperada = session.get(Persona.class, clavePrimaria);
		if (personaRecuperada!=null) {
			System.out.println(personaRecuperada.toString());
		}
		transaction.commit();
	}
	
	
	public static void modificacionDatos(Session session, Transaction transaction, int clavePrimaria) {
		
		Persona personaModificada = session.get(Persona.class, clavePrimaria);
		if (personaModificada!=null) {
			personaModificada.setEdad(31);
			personaModificada.setNombre("Beatriz");
		}
		transaction.commit();
	}

	public static void borrarDatos(Session session, Transaction transaction, int clavePrimaria) {

		Persona personaBorrar = session.get(Persona.class, clavePrimaria);
		if (personaBorrar!=null) {
			session.remove(personaBorrar);
		}
		transaction.commit();

	}
	
	
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Main.insertarDatos(session, transaction);
		
		session.close();
		HibernateUtil.shutdown();
	}

}
