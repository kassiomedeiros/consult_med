package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Medico;

public interface IMedico {

	public void salve(Medico medico);
	public void removerPorId(Long idMedico);
	public void editar(Medico medico);
	public Medico buscaPorId(Long idMedico);
	public Medico buscaPorNome(String nome);
	public Medico buscaPorEmail(String email);
	public List<Medico>listMedicos();
}
