package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Paciente;

public interface IPaciente {

	public void salve(Paciente paciente);
	public void editar(Paciente paciente);
	public void removePorId(Long idPaciente);
	public List<Paciente>listarPacientes();
	public Paciente buscaPorId(Long idPaciente);	
	public Paciente buscaPorEmail(String email);
	public Paciente buscaPorNome(String nome);	
	
}
