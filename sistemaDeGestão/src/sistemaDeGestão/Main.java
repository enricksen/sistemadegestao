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
		int[] aloc_man = new int[1000];
		int[] aloc_activity_numberpart = new int[1000];
		int[][] aloc_activity_parts = new int[1000][1000];
		String[] aloc_activity_title = new String[1000];
		String[] aloc_activity_material = new String[1000];
		String[] aloc_activity_description = new String[1000];
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
							System.out.println("Qual o responsável pela alocação? (Digite seu código)");
							aloc_numb++;
							aloc_man[aloc_numb] = input.nextInt();
							if(aloc_man[aloc_numb] > prof_numb)
							{
								aloc_numb--;
								System.out.println("Alocação não disponível");
							}
							else
							{
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
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Sala "+questions;
						} else if(questions == 2) {
							System.out.println("Qual laboratório você deseja alocar? (Sala de 1 até 4)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Laboratório "+questions;
						} else if(questions == 3) {
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Auditório";
						} else if(questions == 4) {
							System.out.println("Qual projetor você deseja alocar? (Sala de 1 até 10)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da alocação");
							System.out.println("Digite a data de fim da alocação");
							aloc_status[aloc_numb] = "Em processo de alocação";
							aloc_thing[aloc_numb] = "Projetor "+questions;
						}
					} else if(questions == 2) {
						System.out.println("");
					} else if(questions == 3) {
						
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
						
					} else if(questions == 2) {
						
					} else if(questions == 3) {
						
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
				System.out.println("Menu de administrador:");
				break;
			}
			System.out.println("Você deseja sair do sistema? (1 - Sim / 2 - Não)");
			end = input.nextInt();
			if(end == 2) end = 0;
		}
		input.close();
	}

}
