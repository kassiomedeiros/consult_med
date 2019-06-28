package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Consulta;


public interface IConsulta {
	
	public void salve(Consulta consulta);
	public void removerPorId(Long idConsulta);
	public void editar(Consulta consulta);
	public List<Consulta>listcolsultas();
	public Consulta buscaPorId(Long idConsulta);
	
}
