package br.com.consultemed.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.consultemed.model.Agendamento;
import dao.AgendamentoDAO;

public class AgendamentoService implements IAgendamento, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendamentoDAO dao;
	
	public AgendamentoService() {
		this.dao = new AgendamentoDAO();
	}
	
	
	@Override
	public void salvar(Agendamento agendamento) {
		this.dao.salvar(agendamento);
		
	}

	@Override
	public void remover(Long idAgendamento) {
		this.dao.remover(idAgendamento);
		
	}

	@Override
	public Agendamento buscaPorId(Long idAgendamento) {
		return this.dao.buscaPorId(idAgendamento);
	}

	@Override
	public List<Agendamento> listAgendamentos() {
		return this.dao.agendamentos();
	}

	@Override
	public void editar(Agendamento agendamento) {
		this.dao.editar(agendamento);
		
	}


	@Override
	public Agendamento buscaPorData(Date dataConsulta) {
		return this.dao.buscaPorData(dataConsulta);
	}

}
