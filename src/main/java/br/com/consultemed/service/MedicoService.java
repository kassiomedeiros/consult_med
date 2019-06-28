package br.com.consultemed.service;

import java.io.Serializable;
import java.util.List;

import br.com.consultemed.model.Medico;
import dao.ContatoDAO;
import dao.MedicoDAO;

public class MedicoService implements IMedico, Serializable {

	@Inject
	private MedicoDAO dao;

	public MedicoService() {
		this.dao = new MedicoDAO();
	}

	@Override
	public void salve(Medico medico) {
		this.dao.salvar(medico);
	}

	@Override
	public void removerPorId(Long idMedico) {
		this.dao.remover(idMedico);
	}

	@Override
	public void editar(Medico medico) {
		this.dao.editar(medico);
	}

	@Override
	public Medico buscaPorId(Long idMedico) {
		return this.dao.buscaPorId(idMedico);
	}

	@Override
	public Medico buscaPorNome(String nome) {
		return this.dao.buscaPorNome(nome);
	}

	@Override
	public Medico buscaPorEmail(String email) {
		return this.dao.buscaPorEmail(email);
	}

	@Override
	public List<Medico> listMedicos() {
		return this.dao.medicos();
	}
	
	public MedicoDAO getDao() {
		return dao;
	}

	public void setDao(MedicoDAO dao) {
		this.dao = dao;
	}

}
