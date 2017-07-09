package sistemaDeGestão;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int tipo;
		@SuppressWarnings("unused")
		int atual;
		int end = 0;
		int questions;
		String[] prof_name = new String[1000];
		int prof_numb = 0;
		String[] pes_name = new String[1000];
		int pes_numb = 0;
		String[] alu_name = new String[1000];
		int alu_numb = 0;
		String[] adm_name = new String[1000];
		int adm_numb = 0;
		int[] salas = new int[11];
		for(int cont : salas) salas[cont] = 0; 
		int[] labs = new int[11];
		for(int cont : labs) labs[cont] = 0;
		
		
		while(end == 0) {
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
				if(questions == 2){
					alu_numb++;
					System.out.println("Você é o aluno "+alu_numb+". Escreva seu nome:");
					alu_name[alu_numb] = input.next();
					System.out.println("Você está cadastrado "+alu_name[alu_numb]+"!");
					atual = alu_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+alu_name[alu_numb]+"!");
				}
				System.out.println("Menu de aluno:");
				break;
			case 2:
				System.out.println("");
				System.out.println("====================");
				System.out.println("Você é um professor.");
				System.out.println("Já se cadastrou? (1 - Sim / 2 - Não)");
				questions = input.nextInt();
				if(questions == 2){
					prof_numb++;
					System.out.println("Você é o professor "+prof_numb+". Escreva seu nome:");
					prof_name[prof_numb] = input.next();
					System.out.println("Você está cadastrado "+prof_name[prof_numb]+"!");
					atual = prof_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+prof_name[prof_numb]+"!");
				}
				System.out.println("Menu de professor:");
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
					System.out.println("Você está cadastrado "+pes_name[pes_numb]+"!");
					atual = pes_numb;
				}
				else {
					System.out.println("Qual seu número de acesso?");
					atual = input.nextInt();
					System.out.println("Bem-vindo de volta "+pes_name[pes_numb]+"!");
				}
				System.out.println("Menu de pesquisador:");
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
		
	}

}
