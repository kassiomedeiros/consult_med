package br.com.consultemed.service;

import java.io.Serializable;
import java.util.List;

import br.com.consultemed.model.Consulta;
import dao.ConsultaDAO;
import dao.ContatoDAO;

public class ConsultaService implements IConsulta, Serializable{

	@Inject
	private ConsultaDAO dao;
	
	public ConsultaService() {
		this.dao = new ConsultaDAO();
	}
	
	
	@Override
	public void salve(Consulta consulta) {
		this.dao.salvar(consulta);
		
	}

	@Override
	public void removerPorId(Long idConsulta) {
		this.dao.remover(idConsulta);
		
	}

	@Override
	public void editar(Consulta consulta) {
		this.dao.editar(consulta);
		
	}

	@Override
	public List<Consulta> listcolsultas() {
		return this.dao.consutas();
	}

	@Override
	public Consulta buscaPorId(Long idConsulta) {
		return this.buscaPorId(idConsulta);
	}
	
	public ConsultaDAO getDao() {
		return dao;
	}

	public void setDao(ConsultaDAO dao) {
		this.dao = dao;
	}

}
