package br.com.consultemed.service;
import java.io.Serializable;
import java.util.List;

import br.com.consultemed.model.Paciente;
import dao.PacienteDAO;

public class PacienteService implements IPaciente, Serializable {


	@Inject
	public PacienteDAO dao;
	
	public PacienteService() {
		this.dao = new PacienteDAO();
	}
	
	@Override
	public void salve(Paciente paciente) {
		this.dao.salvar(paciente);
		
	}

	@Override
	public void editar(Paciente paciente) {
		this.dao.editar(paciente);
		
	}

	@Override
	public void removePorId(Long idPaciente) {
		this.dao.remover(idPaciente);
		
	}

	@Override
	public List<Paciente> listarPacientes() {
		return this.dao.pacientes();
	}

	@Override
	public Paciente buscaPorId(Long idPaciente) {
		return this.dao.buscaPorId(idPaciente);
	}

	@Override
	public Paciente buscaPorEmail(String email) {
		return this.dao.buscaPorEmail(email);
	}

	@Override
	public Paciente buscaPorNome(String nome) {
		return this.dao.buscaPorNome(nome);
	}
	

	public PacienteDAO getDao() {
		return dao;
	}

	public void setDao(PacienteDAO dao) {
		this.dao = dao;
	}
	

}
