package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.utils.JPAUtils;

public class AgendamentoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public void salvar(Agendamento agendamento) {
		
		this.factory.getTransaction().begin();
		this.factory.persist(agendamento);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idAgendamento) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscaPorId(idAgendamento));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Agendamento buscaPorId(Long idAgendamento) {
		this.factory.getTransaction().begin();
		Agendamento agendamentoRemover = this.factory.find(Agendamento.class, idAgendamento);
		return agendamentoRemover;
	}
	
	public Agendamento buscaPorData(Date dataConsulta) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT a FROM Agendamento a WHERE a.data_hora = :nome");
		query.setParameter("Data", dataConsulta);
		Agendamento agendamento = (Agendamento) query.getSingleResult();
		return agendamento;
	}
	
	
	
	public void editar(Agendamento agendamento) {
		this.factory.getTransaction().begin();
		this.factory.merge(agendamento);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Agendamento> agendamentos(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT a FROM Agendamento a");
		List<Agendamento> agendamentos = query.getResultList(); 
		for (Agendamento agendamento : agendamentos) {
			System.out.println(agendamento.getDataConsulta());
		}
		
		this.factory.close();
		return agendamentos;
	}
}