package es.uma.informatica.ejb.proyecto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.jpa.proyecto.Expedientes;

@Stateless
public class ExpedientesEJB implements GestionExpedientes{
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public double leerNotaMedia(Long Num_Expediente) throws SecretariaException {
		
		Expedientes expedienteEntity = em.find(Expedientes.class, Num_Expediente);
		if(expedienteEntity==null) {
			throw new ExpedienteNoEncontradoException();
		}
		
		return expedienteEntity.getNota_Media_Provisional();
	}

	@Override
	public void cambiarNotaMedia(Long Num_Expediente, Double Nota_media) throws SecretariaException {
		Expedientes expedienteEntity = em.find(Expedientes.class, Num_Expediente);
		if(expedienteEntity==null) {
			throw new ExpedienteNoEncontradoException();
		}
		expedienteEntity.setNota_Media_Provisional(Nota_media);
		em.persist(expedienteEntity);
	}

	@Override
	public void borrarNotaMedia(Long Num_Expediente) throws SecretariaException {
		Expedientes expedienteEntity = em.find(Expedientes.class, Num_Expediente);
		if(expedienteEntity==null) {
			throw new ExpedienteNoEncontradoException();
		}
		expedienteEntity.setNota_Media_Provisional(null);
		em.persist(expedienteEntity);
	}

}
