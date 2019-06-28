package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

public class ConsultaDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public void salvar(Consulta consulta) {
		
		this.factory.getTransaction().begin();
		this.factory.persist(consulta);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idConsulta) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscaPorId(idConsulta));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Consulta buscaPorId(Long idConsulta) {
		this.factory.getTransaction().begin();
		Consulta consultaRemover = this.factory.find(Consulta.class, idConsulta);
		return consultaRemover;
	}
	
	
	public void editar(Consulta consulta) {
		this.factory.getTransaction().begin();
		this.factory.merge(consulta);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Consulta> consutas(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT co FROM Consulta co");
		List<Consulta> consultas = query.getResultList(); 
		for (Consulta consulta : consultas) {
			System.out.println(consulta.getId());
		}
		
		this.factory.close();
		return consultas;
	}
}
