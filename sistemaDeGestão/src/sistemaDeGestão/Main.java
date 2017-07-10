package sistemaDeGest�o;

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
			System.out.println("========== Sistema de Gest�o ==========");
			System.out.println("");
			System.out.println("Qual o seu n�vel de acesso?");
			System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador, 4 - Administrador)");
			
			tipo = input.nextInt();
			
			switch (tipo) {
			case 1:
				System.out.println("");
				System.out.println("====================");
				System.out.println("");
				System.out.println("Voc� � um aluno.");
				System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
				questions = input.nextInt();
				input.nextLine();
				if(questions == 2){
					alu_numb++;
					System.out.println("Voc� � o aluno "+alu_numb+". Escreva seu nome:");
					alu_name[alu_numb] = input.nextLine();
					System.out.println("Escreva seu email:");
					alu_email[alu_numb] = input.nextLine();
					System.out.println("Voc� est� cadastrado "+alu_name[alu_numb]+"!");
					atual = alu_numb;
				}
				else {
					System.out.println("Qual seu n�mero de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+alu_name[alu_numb]+"!");
				}
				while(end2 == 0) {
					System.out.println("Menu de aluno:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Sair");
					questions = input.nextInt();
					if(questions == 1){
						System.out.println("Recursos dispon�veis:");
						System.out.println("1 - Sala");
						questions = input.nextInt();
						if(questions == 1) {
							System.out.println("Qual sala voc� deseja alocar? (Sala de 1 at� 7)");
							questions = input.nextInt();
							System.out.println("Qual o respons�vel pela aloca��o? (Digite seu c�digo)");
							aloc_numb++;
							aloc_man[aloc_numb] = input.nextInt();
							if(aloc_man[aloc_numb] > prof_numb)
							{
								aloc_numb--;
								System.out.println("Aloca��o n�o dispon�vel");
							}
							else
							{
								System.out.println("Digite a data de inicio da aloca��o");
								System.out.println("Digite a data de fim da aloca��o");
								aloc_status[aloc_numb] = "Em processo de aloca��o";
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
				System.out.println("Voc� � um professor.");
				System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
				questions = input.nextInt();
				input.nextLine();
				if(questions == 2){
					prof_numb++;
					System.out.println("Voc� � o professor "+prof_numb+". Escreva seu nome:");
					prof_name[prof_numb] = input.nextLine();
					System.out.println("Escreva seu email:");
					prof_email[prof_numb] = input.nextLine();
					System.out.println("Voc� est� cadastrado "+prof_name[prof_numb]+"!");
					atual = prof_numb;
				}
				else {
					System.out.println("Qual seu n�mero de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+prof_name[prof_numb]+"!");
				}
				while(end2 == 0)
				{
					System.out.println("Menu de professor:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Confirmar aloca��o");
					System.out.println("3 - Adicionar atividade as aloca��es");
					System.out.println("4 - Sair");
					questions = input.nextInt();
					if(questions == 1){
						System.out.println("Recursos dispon�veis:");
						System.out.println("1 - Sala");
						System.out.println("2 - Laborat�rio");
						System.out.println("3 - Audit�rio");
						System.out.println("4 - Projetor");
						questions = input.nextInt();
						if(questions == 1)
						{
							System.out.println("Qual sala voc� deseja alocar? (Sala de 1 at� 7)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da aloca��o");
							System.out.println("Digite a data de fim da aloca��o");
							aloc_status[aloc_numb] = "Em processo de aloca��o";
							aloc_thing[aloc_numb] = "Sala "+questions;
						} else if(questions == 2) {
							System.out.println("Qual laborat�rio voc� deseja alocar? (Sala de 1 at� 4)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da aloca��o");
							System.out.println("Digite a data de fim da aloca��o");
							aloc_status[aloc_numb] = "Em processo de aloca��o";
							aloc_thing[aloc_numb] = "Laborat�rio "+questions;
						} else if(questions == 3) {
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da aloca��o");
							System.out.println("Digite a data de fim da aloca��o");
							aloc_status[aloc_numb] = "Em processo de aloca��o";
							aloc_thing[aloc_numb] = "Audit�rio";
						} else if(questions == 4) {
							System.out.println("Qual projetor voc� deseja alocar? (Sala de 1 at� 10)");
							questions = input.nextInt();
							aloc_numb++;
							aloc_man[aloc_numb] = atual;
							System.out.println("Digite a data de inicio da aloca��o");
							System.out.println("Digite a data de fim da aloca��o");
							aloc_status[aloc_numb] = "Em processo de aloca��o";
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
				System.out.println("Voc� � um pesquisador.");
				System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
				questions = input.nextInt();
				if(questions == 2){
					pes_numb++;
					System.out.println("Voc� � o pesquisador "+pes_numb+". Escreva seu nome:");
					pes_name[pes_numb] = input.next();
					System.out.println("Escreva seu email:");
					pes_email[pes_numb] = input.next();
					System.out.println("Voc� est� cadastrado "+pes_name[pes_numb]+"!");
					atual = pes_numb;
				}
				else {
					System.out.println("Qual seu n�mero de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+pes_name[pes_numb]+"!");
				}
				while(end2 == 0)
				{
					System.out.println("Menu de pesquisador:");
					System.out.println("1 - Alocar Recursos");
					System.out.println("2 - Confirmar aloca��o");
					System.out.println("3 - Adicionar informa��o as aloca��es");
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
				System.out.println("Voc� � um administrador.");
				System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
				questions = input.nextInt();
				if(questions == 2){
					adm_numb++;
					System.out.println("Voc� � o administrador "+adm_numb+". Escreva seu nome:");
					adm_name[adm_numb] = input.next();
					System.out.println("Escreva seu email:");
					adm_email[adm_numb] = input.next();
					System.out.println("Voc� est� cadastrado "+adm_name[adm_numb]+"!");
					atual = adm_numb;
				}
				else {
					System.out.println("Qual seu n�mero de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+adm_name[adm_numb]+"!");
				}
				System.out.println("Menu de administrador:");
				break;
			}
			System.out.println("Voc� deseja sair do sistema? (1 - Sim / 2 - N�o)");
			end = input.nextInt();
			if(end == 2) end = 0;
		}
		input.close();
	}

}
