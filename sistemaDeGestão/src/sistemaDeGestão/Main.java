package sistemaDeGestão;

import java.util.Date;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int tipo;
		int atual;
		int end = 0;
		int end2 = 0;
		int questions;
		
		String[] prof_name = new String[1000];
		String[] prof_email = new String[1000];
		int prof_numb = 0;
		
		String[] pes_name = new String[1000];
		String[] pes_email = new String[1000];
		int pes_numb = 0;
		
		String[] alu_name = new String[1000];
		String[] alu_email = new String [1000];
		int alu_numb = 0;
		
		String[] adm_name = new String[1000];
		String[] adm_email = new String[1000];
		int adm_numb = 0;
		
		int aloc_numb = 0;
		String[] aloc_status = new String[1000];
		String[] aloc_thing = new String[1000];
		String[] aloc_man = new String[1000];
		
		int[] aloc_activity_numberpart = new int[1000];
		int aloc_activity_numb = 0;
		String[] aloc_activity_title = new String[1000];
		String[] aloc_activity_material = new String[1000];
		String[] aloc_activity_description = new String[1000];
		String[] aloc_activity_type = new String[1000];
		
		Date[] aloc_date_start = new Date[1000];
		Date[] aloc_date_end = new Date[1000];
		
		while(end == 0) {
			end2 = 0;
			System.out.println("========== Sistema de Gestão ==========");
			System.out.println("");
			System.out.println("Qual o seu nível de acesso?");
			System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador, 4 - Administrador)");
			
			tipo = input.nextInt();
			
			switch (tipo) {
			case 1:
				System.out.println("");
				System.out.println("====================");
				System.out.println("");
				System.out.println("Você é um aluno.");
				System.out.println("Já se cadastrou? (1 - Sim / 2 - Não)");
				questions = input.nextInt();
				input.nextLine();
				if(questions == 2){
					alu_numb++;
					System.out.println("Você é o aluno "+alu_numb+". Escreva seu nome:");
					alu_name[alu_numb] = input.nextLine();
					System.out.println("Escreva seu email:");
					alu_email[alu_numb] = input.nextLine();
					System.out.println("Você está cadastrado "+alu_name[alu_numb]+"!");
					atual = alu_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+alu_name[alu_numb]+"!");
				}
				while(end2 == 0) {
					System.out.println("Menu de aluno:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Sair");
					questions = input.nextInt();
					if(questions == 1){
						System.out.println("Recursos disponíveis:");
						System.out.println("1 - Sala");
						questions = input.nextInt();
						if(questions == 1) {
							System.out.println("Qual sala você deseja alocar? (Sala de 1 até 7)");
							questions = input.nextInt();
							System.out.println("Qual o professor responsável pela alocação? (Digite seu código)");
							aloc_numb++;
							int temp = input.nextInt();
							if(temp > prof_numb)
							{
								aloc_numb--;
								System.out.println("Alocação não disponível");
							}
							else
							{
								aloc_man[temp] = "Prof "+temp;
								System.out.println("Digite a data de inicio da alocação");
								System.out.println("Digite a data de fim da alocação");
								aloc_status[aloc_numb] = "Em processo de alocação";
								aloc_thing[aloc_numb] = "Sala "+questions;
							}
						}
					} else if(questions == 2) {
						end2 = 1;
					}
				}
				break;
			case 2:
				System.out.println("");
				System.out.println("====================");
				System.out.println("");
				System.out.println("Você é um professor.");
				System.out.println("Já se cadastrou? (1 - Sim / 2 - Não)");
				questions = input.nextInt();
				input.nextLine();
				if(questions == 2){
					prof_numb++;
					System.out.println("Você é o professor "+prof_numb+". Escreva seu nome:");
					prof_name[prof_numb] = input.nextLine();
					System.out.println("Escreva seu email:");
					prof_email[prof_numb] = input.nextLine();
					System.out.println("Você está cadastrado "+prof_name[prof_numb]+"!");
					atual = prof_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+prof_name[prof_numb]+"!");
				}
				while(end2 == 0)
				{
					System.out.println("Menu de professor:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Confirmar alocação");
					System.out.println("3 - Adicionar atividade as alocações");
					System.out.println("4 - Sair");
					questions = input.nextInt();
					if(questions == 1){
						System.out.println("Recursos disponíveis:");
						System.out.println("1 - Sala");
						System.out.println("2 - Laboratório");
						System.out.println("3 - Auditório");
						System.out.println("4 - Projetor");
						questions = input.nextInt();
						if(questions == 1)
						{
							System.out.println("Qual sala você deseja alocar? (Sala de 1 até 7)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Prof "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Sala "+questions;
						} else if(questions == 2) {
							System.out.println("Qual laboratório você deseja alocar? (Laboratório de 1 até 4)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Prof "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Laboratório "+questions;
						} else if(questions == 3) {
							aloc_numb++;
							aloc_man[aloc_numb] = "Prof "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Auditório";
						} else if(questions == 4) {
							System.out.println("Qual projetor você deseja alocar? (Projetores de 1 até 10)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Prof "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Projetor "+questions;
						}
					} else if(questions == 2) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_man[cont].equals("Prof "+atual)  && aloc_status[cont] == "Alocado") {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							int aloc2 = questions;
							int aloc_in = 0;
							for(int cont = 1; cont <= aloc_numb; cont++) {
								if(aloc_man[cont].equals("Prof "+atual) && aloc_status[cont] == "Em Andamento")
								{
									aloc_in = 1;
								}
							}
							if(aloc_in == 0) {
								System.out.println("Deseja confirmar a alocação "+aloc2+"? (1 - Sim / 2 - Não)");
								questions = input.nextInt();
								if(questions == 1) {
									aloc_status[aloc2] = "Em Andamento";
								}
							} else {
								System.out.println("Você já tem uma alocação em andamento!");
							}
							
						}
					} else if(questions == 3) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_man[cont].equals("Prof "+atual) && aloc_status[cont] == "Em Andamento") {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							System.out.println("Deseja adicionar a atividade a alocação"+questions+"? (1 - Sim / 2 - Não)");
							int aloc2 = questions;
							questions = input.nextInt();
							if(questions == 1) {
								System.out.println("Qual o tipo de atividade? (1 - Aula tradicional, 2 - Apresentação, 3 - Laboratório)");
								questions = input.nextInt();
								input.nextLine();
								if(questions == 1) {
									aloc_activity_type[aloc2] = "Aula tradicional";
								} else if(questions == 2) {
									aloc_activity_type[aloc2] = "Apresentação";
								} else if(questions == 3) {
									aloc_activity_type[aloc2] = "Laboratório";
								}
								System.out.println("Digite o titulo da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Digite a descrição da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Digite o link para o material da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Quantos participantes na atividade?");
								aloc_activity_numberpart[aloc2] = input.nextInt();
								System.out.println("Atividade cadastrada com sucesso.");
								aloc_activity_numb++;
							}
						}
					} else if(questions == 4) {
						end2 = 1;
					}
				}
				break;
			case 3:
				System.out.println("");
				System.out.println("====================");
				System.out.println("Você é um pesquisador.");
				System.out.println("Já se cadastrou? (1 - Sim / 2 - Não)");
				questions = input.nextInt();
				if(questions == 2){
					pes_numb++;
					System.out.println("Você é o pesquisador "+pes_numb+". Escreva seu nome:");
					pes_name[pes_numb] = input.next();
					System.out.println("Escreva seu email:");
					pes_email[pes_numb] = input.next();
					System.out.println("Você está cadastrado "+pes_name[pes_numb]+"!");
					atual = pes_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+pes_name[pes_numb]+"!");
				}
				while(end2 == 0)
				{
					System.out.println("Menu de pesquisador:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Confirmar alocação");
					System.out.println("3 - Adicionar informação as alocações");
					System.out.println("4 - Sair");
					questions = input.nextInt();
					if(questions == 1){
						System.out.println("Recursos disponíveis:");
						System.out.println("1 - Sala");
						System.out.println("2 - Laboratório");
						System.out.println("3 - Auditório");
						System.out.println("4 - Projetor");
						questions = input.nextInt();
						if(questions == 1)
						{
							System.out.println("Qual sala você deseja alocar? (Sala de 1 até 7)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Pes "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Sala "+questions;
						} else if(questions == 2) {
							System.out.println("Qual laboratório você deseja alocar? (Laboratório de 1 até 4)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Pes "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Laboratório "+questions;
						} else if(questions == 3) {
							aloc_numb++;
							aloc_man[aloc_numb] = "Pes "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Auditório";
						} else if(questions == 4) {
							System.out.println("Qual projetor você deseja alocar? (Projetores de 1 até 10)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = "Pes "+atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Projetor "+questions;
						}
					} else if(questions == 2) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_man[cont].equals("Pes "+atual)  && aloc_status[cont] == "Alocado") {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							int aloc2 = questions;
							int aloc_in = 0;
							for(int cont = 1; cont <= aloc_numb; cont++) {
								if(aloc_man[cont].equals("Pes "+atual) && aloc_status[cont] == "Em Andamento")
								{
									aloc_in = 1;
								}
							}
							if(aloc_in == 0) {
								System.out.println("Deseja confirmar a alocação "+aloc2+"? (1 - Sim / 2 - Não)");
								questions = input.nextInt();
								if(questions == 1) {
									aloc_status[aloc2] = "Em Andamento";
								}
							} else {
								System.out.println("Você já tem uma alocação em andamento!");
							}
							
						}
					} else if(questions == 3) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_man[cont].equals("Pes "+atual) && aloc_status[cont] == "Em Andamento") {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							System.out.println("Deseja adicionar a atividade a alocação"+questions+"? (1 - Sim / 2 - Não)");
							int aloc2 = questions;
							questions = input.nextInt();
							input.nextLine();
							if(questions == 1) {
								aloc_activity_type[aloc2] = "Apresentação";
								System.out.println("Digite o titulo da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Digite a descrição da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Digite o link para o material da atividade:");
								aloc_activity_description[aloc2] = input.nextLine();
								System.out.println("Quantos participantes na atividade?");
								aloc_activity_numberpart[aloc2] = input.nextInt();
								System.out.println("Atividade cadastrada com sucesso.");
								aloc_activity_numb++;
							}
						}
					} else if(questions == 4) {
						end2 = 1;
					}
				}
				break;
			case 4:
				System.out.println("");
				System.out.println("====================");
				System.out.println("Você é um administrador.");
				System.out.println("Já se cadastrou? (1 - Sim / 2 - Não)");
				questions = input.nextInt();
				if(questions == 2){
					adm_numb++;
					System.out.println("Você é o administrador "+adm_numb+". Escreva seu nome:");
					adm_name[adm_numb] = input.next();
					System.out.println("Escreva seu email:");
					adm_email[adm_numb] = input.next();
					System.out.println("Você está cadastrado "+adm_name[adm_numb]+"!");
					atual = adm_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+adm_name[adm_numb]+"!");
				}
				while(end2 == 0) {
					System.out.println("Menu de administrador:");
					System.out.println("1 - Número de usuários");
					System.out.println("2 - Número de recursos/alocações");
					System.out.println("3 - Número de atividades");
					System.out.println("4 - Consulta por usuário");
					System.out.println("5 - Consulta por recurso/alocação");
					System.out.println("6 - Concluir alocação");
					System.out.println("7 - Alocar processo de alocação");
					System.out.println("8 - Sair");
					questions = input.nextInt();
					if(questions == 1) {
						int sum = adm_numb+prof_numb+alu_numb+pes_numb;
						System.out.println("O número de usuários do sistema é: "+sum);
					} else if(questions == 2) {
						System.out.println("O número total de recursos/alocações é: "+aloc_numb);
						System.out.println("Sendo eles:");
						int count1 = 0;
						int count2 = 0;
						int count3 = 0;
						int count4 = 0;
						for(int i = 1; i <= aloc_numb; i++)
						{
							if(aloc_status[i] == "Alocado"){
								count1++;
							} else if(aloc_status[i] == "Em Andamento") {
								count2++;
							} else if(aloc_status[i] == "Concluído") {
								count3++;
							}else if(aloc_status[i] == "Em processo de alocação") {
								count4++;
							}
						}
						System.out.println(count4+" do tipo 'Em processo de alocação'");
						System.out.println(count1+" do tipo 'Alocado'");
						System.out.println(count2+" do tipo 'Em Andamento'");
						System.out.println(count3+" do tipo 'Concluído'");
						
					} else if(questions == 3) {
						System.out.println("O número total de atividades é: "+aloc_activity_numb);
						System.out.println("Sendo elas:");
						int count1 = 0;
						int count2 = 0;
						int count3 = 0;
						for(int i = 1; i <= aloc_activity_numb; i++)
						{
							if(aloc_activity_type[i] == "Aula tradicional"){
								count1++;
							} else if(aloc_activity_type[i] == "Apresentação") {
								count2++;
							} else if(aloc_activity_type[i] == "Laboratório") {
								count3++;
							}
						}
						System.out.println(count1+" do tipo 'Aula tradicional'");
						System.out.println(count2+" do tipo 'Apresentação'");
						System.out.println(count3+" do tipo 'Laboratório'");
						
					} else if(questions == 4) {
						System.out.println("Qual o seu nível de acesso do usuário?");
						System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador)");
						questions = input.nextInt();
						if(questions == 1) {
							System.out.println("Digite o código do aluno");
							questions = input.nextInt();
							System.out.println("Informações do usuário:");
							System.out.println("Nome: "+alu_name[questions]);
							System.out.println("E-mail: "+alu_email[questions]);
							System.out.println("Recursos onde ele é responsável:");
						} else if(questions == 2) {
							System.out.println("Digite o código do professor");
							questions = input.nextInt();
							System.out.println("Informações do usuário:");
							System.out.println("Nome: "+prof_name[questions]);
							System.out.println("E-mail: "+prof_email[questions]);
							System.out.println("Recursos onde ele é responsável:");
							for(int count = 1; count <= aloc_numb; count++) {
								if(aloc_man[count].equals("Prof "+questions)) {
									System.out.println("Recurso "+count+" — Informações: ");
									System.out.println(aloc_status[count]);
									System.out.println(aloc_thing[count]);
									if(aloc_status[count].equals("Concluído")) {
										System.out.println(aloc_activity_title[count]);
										System.out.println(aloc_activity_material[count]);
										System.out.println(aloc_activity_description[count]);
										System.out.println(aloc_activity_type[count]);
										System.out.println(aloc_activity_numberpart[count]);
									}
								}
							}
						} else if(questions == 3) {
							System.out.println("Digite o código do pesquisador");
							questions = input.nextInt();
							System.out.println("Informações do usuário:");
							System.out.println("Nome: "+pes_name[questions]);
							System.out.println("E-mail: "+pes_email[questions]);
							System.out.println("Recursos onde ele é responsável:");
							for(int count = 1; count <= aloc_numb; count++) {
								if(aloc_man[count].equals("Pes "+questions)) {
									System.out.println("Recurso "+count+" — Informações: ");
									System.out.println(aloc_status[count]);
									System.out.println(aloc_thing[count]);
									if(aloc_status[count].equals("Concluído")) {
										System.out.println(aloc_activity_title[count]);
										System.out.println(aloc_activity_material[count]);
										System.out.println(aloc_activity_description[count]);
										System.out.println(aloc_activity_type[count]);
										System.out.println(aloc_activity_numberpart[count]);
									}
								}
							}
						}
						
					} else if(questions == 5) {
						System.out.println("Digite o código da alocação");
						questions = input.nextInt();
						System.out.println("Recurso "+questions+" — Informações: ");
						System.out.println(aloc_status[questions]);
						System.out.println(aloc_thing[questions]);
						System.out.println(aloc_man[questions]);
						if(aloc_status[questions].equals("Concluído")) {
							System.out.println(aloc_activity_title[questions]);
							System.out.println(aloc_activity_material[questions]);
							System.out.println(aloc_activity_description[questions]);
							System.out.println(aloc_activity_type[questions]);
							System.out.println(aloc_activity_numberpart[questions]);
						}
					} else if(questions == 6) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_status[cont].equals("Em Andamento")) {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							int aloc2 = questions;
								System.out.println("Deseja confirmar a alocação "+aloc2+"? (1 - Sim / 2 - Não)");
								questions = input.nextInt();
								if(questions == 1) {
									aloc_status[aloc2] = "Concluído";
						}
						}
					} else if(questions == 7) {
						System.out.println("Lista de alocações:");
						for(int cont = 1; cont <= aloc_numb; cont++) {
							if(aloc_status[cont] == "Em processo de alocação") {
								System.out.println("— "+cont+" "+aloc_thing[cont]);
							}
						}
						System.out.println("Digite o numero da alocação, caso não tenha nenhuma ou não queira alguma, digite 0");
						questions = input.nextInt();
						if(questions != 0) {
							int aloc2 = questions;
								System.out.println("Deseja confirmar a alocação "+aloc2+"? (1 - Sim / 2 - Não)");
								questions = input.nextInt();
								if(questions == 1) {
									aloc_status[aloc2] = "Alocado";
						}
						}
					} else if(questions == 8) {
						end2 = 1;
					}
				}
				break;
			}
			System.out.println("Você deseja sair do sistema? (1 - Sim / 2 - Não)");
			end = input.nextInt();
			if(end == 2) end = 0;
		}
		input.close();
	}

}
