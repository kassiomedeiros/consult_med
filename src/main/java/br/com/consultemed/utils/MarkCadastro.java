package br.com.consultemed.utils;

import java.util.Date;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.AgendamentoService;
import br.com.consultemed.service.ConsultaService;

public class MarkCadastro {
	
	private Date dataAtual;
	
	
	

	public Consulta markConsulta(Agendamento agendamento) {
			Consulta consulta = new Consulta();
			consulta.setAgendamento(agendamento);
			consulta.setDiagnostico("Dor na garganta");
			
			ConsultaService consultaService = new ConsultaService();
			consultaService.salve(consulta);
			
			return consulta;		
			
	}
	
	public Agendamento markAgendamento(Medico medico) {
			Agendamento agendamento = new Agendamento();
			agendamento.setDataConsulta(this.dataAtual);
			agendamento.setMedico(medico);
		
			AgendamentoService agendaService = new AgendamentoService();
			agendaService.salvar(agendamento);
			
			return agendamento;
		
	}
}
