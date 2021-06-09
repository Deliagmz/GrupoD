
//package es.uma.informatica.sii.proyecto.test;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import es.uma.informatica.jpa.proyecto.Alumno;
//import es.uma.informatica.jpa.proyecto.Asignaturas;
//import es.uma.informatica.jpa.proyecto.Titulacion;
//import es.uma.informatica.jpa.proyecto.Usuario;
//
//public class BaseDeDatos {
//
//		public static void incializar(String unidadPersistencia) {
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
//			EntityManager em = emf.createEntityManager();
//			
//			datos(em);
//			
//			em.close();
//			emf.close();
//			
//			
//		}
//
//		public static void datos(EntityManager em) {
//			// TODO Auto-generated method stub
//			Usuario usuario = new Usuario();
//			Usuario usuario2 = new Usuario();
//				
//			usuario.setCuenta("Secretaria");
//			usuario.setApellido("secretaria");
//			usuario.setContrasena("secretaria");
//			usuario.setDNI("00000000x");
//			usuario.setDireccion("uma");
//			usuario.setEmail("uma@uma.es");
//			usuario.setNombre("secretaria");
//			usuario.setTelefono("666777888");
//			
//			em.getTransaction().begin();
//			em.persist(usuario);
//			em.getTransaction().commit();
//			
//			usuario2.setCuenta("Pepe");
//			usuario2.setApellido("Pepon");
//			usuario2.setContrasena("pepaso");
//			usuario2.setDNI("12345678x");
//			usuario2.setDireccion("micasa");
//			usuario2.setEmail("pepe@uma.es");
//			usuario2.setNombre("PepeLu");
//			usuario2.setTelefono("666777888");
//			usuario2.setCadenaValidacion(null);
//			
//			em.getTransaction().begin();
//			em.persist(usuario2);
//			em.getTransaction().commit();
//			
//			Alumno alumno = new Alumno();
//			alumno.setID("1");
//			alumno.setDNI("12345678x");
//			alumno.setNombre("Pepito");
//			alumno.setApellido1("Gonzalez");
//			alumno.setEmail_institucional("pepito@uma.es");
//			
//			em.getTransaction().begin();
//			em.persist(alumno);
//			em.getTransaction().commit();
//			
//			Asignaturas asignatura = new Asignaturas();
//			asignatura.setReferencia(11223344);
//			asignatura.setCodigo(111);
//			asignatura.setCreditos(6);
//			asignatura.setOfertada("Si");
//			asignatura.setNombre("Estructura de Datos");
//			
//			em.getTransaction().begin();
//			em.persist(asignatura);
//			em.getTransaction().commit();
//			
//			Titulacion titulacion = new Titulacion();
//			titulacion.setCodigo(1041);
//			titulacion.setCreditos(240);
//			titulacion.setNombre("Ingenieria Informatica");
//			
//			em.getTransaction().begin();
//			em.persist(titulacion);
//			em.getTransaction().commit();
//			
//		}
//}

