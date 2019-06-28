package br.com.consultemed.utils;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.ConsultaService;
import br.com.consultemed.service.ContatoService;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;
import dao.PacienteDAO;

public class Main {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
			List<Medico> medicos = new ArrayList<>(); 
			List<Paciente> pacientes = new ArrayList<>();
			List<Consulta> consultas = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);

		int opcao = 0;
		
		do {
			
			System.out.println(">>>>>>>>>>>> Bem-vindo ao Hospital IMIP <<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			System.out.println("\nOpção 1 - Cadastros: pacientes, médicos e consultas.");
			System.out.println("Opção 2 - Remover pacientes, médicos e consultas");
			System.out.println("Opção 3 - Editar pacientes, médicos e consultas");
			System.out.println("Opção 4 - Buscar por id, paciente, médico, consulta");
			System.out.println("Opção 11 - Busca por Nome paciente, médico");
			System.out.println("Opção 13 - Lista de médicos");
			System.out.println("Opção 14 - Lista de pacientes");
			System.out.println("Opção 15 - Lista de consultas");
			System.out.println("Opção 0 - Sair do programa");
	        System.out.println("");
	        System.out.print("Informa opçao : ");
	        
	        opcao = Integer.parseInt(sc.nextLine());
		
	      if(opcao == 1) {
	    	   	PacienteService pacienteService = new PacienteService();
	        	Paciente paciente = new Paciente();
	        	
	        	MedicoService medicoService = new MedicoService();
	        	Medico medico = new Medico();
	        	
	        	ConsultaService consultaService = new ConsultaService();
	        	Consulta consulta = new Consulta();	        	
	        	Scanner scannerPMC = new Scanner(System.in);
	        	
	        	int tipoCadastro;
	        	
	        	System.out.println("Informe o tipo: ");
	        	System.out.println("\nOpção 1 - Cadastro Paciente");
				System.out.println("Opção 2 - Cadastro Médico ");
				System.out.println("Opção 3 - Cadastro Consulta");
		        System.out.println("");
		        System.out.print("Informa opçao : ");
	        	
	        	tipoCadastro = Integer.parseInt(scannerPMC.nextLine());
	        	
	        	switch(tipoCadastro) {
	        		
	        		case 1:
	        				System.out.println("Cadastrar Paciente");
	        		    System.out.println("");
	        		
	        			  System.out.println("Informe o nome : ");
	  		        	paciente.setNome(sc.nextLine());
	  		        	
	  		        		System.out.println("Informe o endereço : ");
			        	paciente.setEndereco(sc.nextLine());

			        		System.out.println("Informe o e-mail : ");
			        	paciente.setEmail(sc.nextLine());

			        		System.out.println("Informe o telefone : ");
			        	paciente.setTelefone(sc.nextLine());
			        	
			        	pacienteService.salve(paciente);
			        	
			        	System.out.println("Paciente cadastrado com suceso!");
			        	System.out.println("");
			        	System.out.println("Pressione qualquer tecla para continuar.");
			        	sc.nextLine();
			        	
						break;
			        	
	        		case 2:
	        				System.out.println("Cadastrando Médico");
						System.out.println("");
						
						 	System.out.println("Informe o nome : ");
		  		        medico.setNome(sc.nextLine());
		  		        	
		  		        	System.out.println("Informe o endereço : ");
				        medico.setEndereco(sc.nextLine());

				        	System.out.println("Informe o e-mail : ");
				        medico.setEmail(sc.nextLine());

				        	System.out.println("Informe o telefone : ");
				        medico.setTelefone(sc.nextLine());
				       
				        	System.out.println("Informe o CRM : ");
				        medico.setTelefone(sc.nextLine());
				        
				        medicoService.salve(medico);
				        
				        System.out.println("Médico cadastrado com suceso!");
			        	System.out.println("");
			        	System.out.println("Pressione qualquer tecla para continuar.");
			        	sc.nextLine();
			        	
			        	break;
			        	
	        		case 3:
	        			
	        				System.out.println("Cadastrando Consulta");
						System.out.println("");
						
						 	System.out.println("Informe o diagnóstico : ");
		  		        consulta.setDiagnostico(sc.nextLine());
		  		        	
		  		        	System.out.println("Médico responsável : ");
				        consulta.setMedico(medico);

				        	System.out.println("Paciente : ");
				        consulta.setPaciente(paciente);
				        
				        consultaService.salve(consulta);
				        
				        System.out.println("Consulta cadastrado com suceso!");
			        	System.out.println("");
			        	System.out.println("Pressione qualquer tecla para continuar.");
			        	sc.nextLine();
	        			
			        	break;
			        	
			        	default:			        	
			        	break;
	        			}
	        	
	        }else if(opcao == 2) {
	        	
	        	PacienteService pacienteService2 = new PacienteService();
	        	MedicoService medicoService2 = new MedicoService();	        	
	        	ConsultaService consultaService2 = new ConsultaService();	        
	        	Scanner scRemove = new Scanner(System.in);
	        	
	        	int tipoRemove;
	        	
	        	System.out.println("Informe o tipo: ");
	        	System.out.println("\nOpção 1 - Remover Paciente");
				System.out.println("Opção 2 - Remover Médico ");
				System.out.println("Opção 3 - Remover Consulta");
		        System.out.println("");
		        System.out.print("Informa opçao : ");
		        
		        tipoRemove = Integer.parseInt(scRemove.nextLine());
	        	
	        	switch(tipoRemove) {
	        	
	        	case 1:
	        		
	        	System.out.println("Remover Paciente");
	        	System.out.println("Informe o id do paciente a ser removido");
	        	Paciente removePorId =  pacienteService2.buscaPorId(scRemove.nextLong());
	        	if(removePorId == null || "".equals(removePorId)){
	        		System.out.println(" Funcionário não encontrado!");
	        	}else {	        		
	        		System.out.println("Paciente " + removePorId.getId() + " Será removido do sistema");
	        		 pacienteService2.removePorId(removePorId.getId());
	        		System.out.println("Paciente removido com sucesso!!!");
	        	}
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();
	        	
	        	break;
	        	
	        	case 2:        	
	        	
	        	System.out.println("Remover Médico");
	        	System.out.println("Informe o id do médico a ser removido");
	        	Medico removerPorId =  medicoService2.buscaPorId(scRemove.nextLong());
	        	if(removerPorId == null || "".equals(removerPorId)){
	        		System.out.println(" Médico não encontrado!");
	        	}else {	        		
	        		System.out.println("Médico " + removerPorId.getId() + " Será removido do sistema");
	        		 medicoService2.removerPorId(removerPorId.getId());
	        		System.out.println("Médico removido com sucesso!!!");
	        	}
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();
	        		
	        	break;
	        	
	        	case 3:       	
	        	
	        	System.out.println("Remover Consulta");
	        	System.out.println("Informe o id da consulta a ser removido");
	        	Consulta removerPorId1 =  consultaService2.buscaPorId(scRemove.nextLong());
	        	if(removerPorId1 == null || removerPorId1.equals("")){
	        		System.out.println(" Consulta não encontrado!");
	        	}else {	        		
	        		System.out.println("Consulta " + removerPorId1.getId() + " Será removido do sistema");
	        		 consultaService2.removerPorId(removerPorId1.getId());
	        		System.out.println("Médico removido com sucesso!!!");
	        	}
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();
	        	
	        	break;
	        	default:
	        	}
	        
	        }else if(opcao == 3) {
	        	
	        	PacienteService pacienteService3 = new PacienteService();
	        	Paciente paciente = new Paciente();
	           	MedicoService medicoService3 = new MedicoService();
	           	Medico medico = new Medico();
	        	ConsultaService consultaService3 = new ConsultaService();
	        	Consulta consulta = new Consulta();
	        	Scanner scEditar = new Scanner(System.in);
	        	
	        	int tipoEditar;
	        	
	        	
	        	System.out.println("Informe o tipo: ");
	        	System.out.println("\nOpção 1 - Editar Paciente");
				System.out.println("Opção 2 - Editar Médico ");
				System.out.println("Opção 3 - Editar Consulta");
		        System.out.println("");
		        System.out.print("Informa opçao : ");
		        
		        tipoEditar = Integer.parseInt(scEditar.nextLine());
	        	
	        	switch(tipoEditar) {
	        	
	        	case 1:
	        	System.out.println("Atualizar Paciente");
	        	System.out.println("Informe o nome do paciente a ser atualizado");
	        	paciente.setNome(scEditar.nextLine());
	        	System.out.println("Informe o endereço : ");
	        	paciente.setEndereco(scEditar.nextLine());
	        	System.out.println("Informe o e-mail : ");
	        	paciente.setEmail(scEditar.nextLine());
	        	System.out.println("Informe o telefone : ");
	        	paciente.setTelefone(scEditar.nextLine());  
	        	
	        	pacienteService3.editar(paciente);
	        	
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();       	
	        	
	        	break;
	        	
	        	case 2:  	
	        	
	        	System.out.println("Atualizar Médico");
	        	System.out.println("Informe o nome : ");
  		        medico.setNome(scEditar.nextLine());  		        	
  		        System.out.println("Informe o endereço : ");
		        medico.setEndereco(scEditar.nextLine());
		        System.out.println("Informe o e-mail : ");
		        medico.setEmail(scEditar.nextLine());
		        System.out.println("Informe o telefone : ");
		        medico.setTelefone(scEditar.nextLine());		       
		        System.out.println("Informe o CRM : ");
		        medico.setTelefone(scEditar.nextLine());
		        
		        medicoService3.salve(medico);
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();
	        	
	        	break;
	        
	        	case 3:
	        	
	        	System.out.println("Atualizar Consulta");
	        	System.out.println("Informe o novo diagnóstico : ");
  		        consulta.setDiagnostico(scEditar.nextLine());  		        	
  		        System.out.println("Médico responsável : ");
		        consulta.setMedico(medico);
		        System.out.println("Paciente : ");
		        consulta.setPaciente(paciente);
		        
		        consultaService3.salve(consulta);
		        
	        	System.out.println("Pressione qualquer tecla para continuar.");
	        	sc.nextLine();
	        	
	        	break;
	        	default:
	        	}
	        
	        }else if(opcao == 4) {
	        	PacienteService pacienteService4 = new PacienteService();
	        	MedicoService medicoService4 = new MedicoService();
	        	ConsultaService consultaService4 = new ConsultaService();
	        	Scanner scBusId = new Scanner(System.in);
	        	
	        	int tipoBuscPorId;
	        	
	        	System.out.println("Informe o tipo: ");
	        	System.out.println("\nOpção 1 - Busca por ID Paciente");
				System.out.println("Opção 2 - Busca por ID Médico ");
				System.out.println("Opção 3 - Busca por ID Consulta");
		        System.out.println("");
		        System.out.print("Informa opçao : ");
		        
		        tipoBuscPorId = Integer.parseInt(scBusId.nextLine());
	        	
		        switch(tipoBuscPorId) {
		        
		        case 1:
		        	
	        	System.out.print("Informe o id do paciente para consulta : ");
	        	Paciente buscaPorId = pacienteService4.buscaPorId(scBusId.nextLong());
	        	
	        	if(buscaPorId != null) {
	        		System.out.println("ID: " + buscaPorId.getId());
		        	 System.out.println("Nome: " + buscaPorId.getNome());
		        	 System.out.println("Endereço: " + buscaPorId.getEndereco());
		        	 System.out.println("E-mail: " + buscaPorId.getEmail());	
		        	 System.out.println("telefone: " + buscaPorId.getTelefone());
	        	
	        	}else {
	        		System.out.println("Nenhum paciente encontrado!");
	        	}
	        	
	        	break;
	        	
		        case 2:
	        
	        	System.out.print("Informe o id do médico para consulta : ");
	        	Medico buscaPorId1 = medicoService4.buscaPorId(scBusId.nextLong());
	        	if(buscaPorId1 != null) {
	        		System.out.println("ID: " + buscaPorId1.getId());
		        	 System.out.println("Nome: " + buscaPorId1.getNome());
		        	 System.out.println("Endereço: " + buscaPorId1.getEndereco());
		        	 System.out.println("E-mail: " + buscaPorId1.getEmail());	
		        	 System.out.println("telefone: " + buscaPorId1.getTelefone());
	        	
	        	}else {
	        		System.out.println("Nenhum médico encontrado!");
	        	}
	        
	        	break;
	        	
		        case 3:	        	
        	
	        	System.out.print("Informe o id da consulta: ");
	        	Consulta buscaPorId2 = consultaService4.buscaPorId(scBusId.nextLong());
	        	if(buscaPorId2 != null) {
	        		System.out.println("ID: " + buscaPorId2.getId());
	        		System.out.println("Nome médico: " + buscaPorId2.getMedico());
	        		System.out.println("Paciente: " + buscaPorId2.getPaciente());		        	 
		
	        	}else {
	        		System.out.println("Nenhuma consulta encontrado!");
	        	}
	        	
	        	break;
	        	default:
		        }
	        
	        }else if(opcao == 11) {
	        	PacienteService pacienteService5 = new PacienteService();
	        	Paciente paciente = new Paciente();
	        	
	        	 System.out.print("Informe o nome do paciente para consulta : ");
		         Paciente buscaPorNome = pacienteService5.buscaPorNome(sc.nextLine());
		         if(buscaPorNome != null){
		        	 System.out.println("ID: " + buscaPorNome.getId());
		        	 System.out.println("Nome: " + buscaPorNome.getNome());
		        	 System.out.println("Endereço: " + buscaPorNome.getEndereco());
		        	 System.out.println("E-mail: " + buscaPorNome.getEmail());	
		        	 System.out.println("telefone: " + buscaPorNome.getTelefone());	
		        	
		    }else {
		       System.out.println("Nenhum paciente encontrado!");    		
		    }

	        }else if(opcao == 12) {
	        	MedicoService medicoService5 = new MedicoService();
	        	Medico medico = new Medico();
	        	
	        	System.out.print("Informe o nome do médico para consulta : ");
		         Medico buscaPorNome = medicoService5.buscaPorNome(sc.nextLine());
		         if(buscaPorNome != null){
		        	 System.out.println("ID: " + buscaPorNome.getId());
		        	 System.out.println("Nome: " + buscaPorNome.getNome());
		        	 System.out.println("Endereço: " + buscaPorNome.getEndereco());
		        	 System.out.println("E-mail: " + buscaPorNome.getEmail());	
		        	 System.out.println("telefone: " + buscaPorNome.getTelefone());	
	        }else {
	        	 System.out.println("Nenhum médico encontrado!"); 
	        }
	        	
	        }else if(opcao == 13) {
	        	MedicoService medicoService6 = new MedicoService();
	        		        	
	        	 medicos = medicoService6.listMedicos(); 
	        	
		          if(medicos.isEmpty()){
		        	  System.out.println("Não exitem médicos cadastrados!");
		        	  
		          }else{
		        	  for(Medico m : medicos){
		        		  System.out.println("");
		        		  System.out.println("ID: " + m.getId());
		        		  System.out.println("Nome: " + m.getNome());
		        		  System.out.println("Email: " + m.getEmail());
		        		  System.out.println("Telefone: " + m.getTelefone());
		        		  System.out.println("");
		        		  
		        	  }
		          }
	        }else if(opcao == 14) {
	        	PacienteService pacienteService6 = new PacienteService();
	        	
	        	pacientes = pacienteService6.listarPacientes();
	        	
	        	if(pacientes.isEmpty()) {
	        		  System.out.println("Não exitem pacientes cadastrados!");
	        	
	        	}else {
	        		for(Paciente p : pacientes){
		        		  System.out.println("");
		        		  System.out.println("ID: " + p.getId());
		        		  System.out.println("Nome: " + p.getNome());
		        		  System.out.println("Email: " + p.getEmail());
		        		  System.out.println("Telefone: " +p.getTelefone());
		        		  System.out.println("");
		        		  
	        			}	        		
	        		}	        
	        }else if(opcao == 15) {
	        	ConsultaService consultaService6 = new ConsultaService();
	        	
	        	consultas = consultaService6.listcolsultas();
	        	
	        	if(consultas.isEmpty()) {
	        		 System.out.println("Não exitem consultas cadastrados!");
	        		 
	        	}else {
	        		for(Consulta c : consultas){
		        		  System.out.println("");
		        		  System.out.println("ID: " + c.getId());
		        		  System.out.println("Diagnóstico: " + c.getDiagnostico());
		        		  System.out.println("Médico: " + c.getMedico());
		        		  System.out.println("Paciente: " +c.getPaciente());
		        		  System.out.println("");
	        	}       	
	        	
	        }
	        	
	        	System.out.println("Pressione ENTER para continuar.");
	        	sc.nextLine();
	        }else if(opcao == 15) {
		    	  
		      }

		} while (opcao != 0);
		
		sc.close();
	}
}