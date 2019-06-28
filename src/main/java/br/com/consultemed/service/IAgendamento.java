package br.com.consultemed.service;

import java.util.Date;
import java.util.List;

import br.com.consultemed.model.Agendamento;

public interface IAgendamento {

	public void salvar(Agendamento agendamento);
	public void remover(Long idAgendamento);
	public Agendamento buscaPorId(Long idAgendamento);
	public List<Agendamento>listAgendamentos();
	public void editar(Agendamento agendamento);
	public Agendamento buscaPorData(Date dataConsulta);
}
