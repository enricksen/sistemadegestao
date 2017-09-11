package system.management;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean endOfTheProgram = false;
		boolean endOfTheLogin = false;
		boolean logicalQuestions;
		int numberQuestions;
		String textQuestions;
		User logado = null;
		
		Scanner input = new Scanner(System.in);
		List<User> allUsers = new ArrayList<User>();
		
		System.out.println("========== Sistema de Gestão ==========");
        System.out.println("");
        
		while(!endOfTheProgram) {
            
			endOfTheLogin = false;
            System.out.println("Você já possui cadastro? (true = sim / false = não)");
            logicalQuestions = input.nextBoolean();
            input.nextLine();
            
            if(logicalQuestions) {
            	
            	System.out.println("Digite o seu email:");
            	textQuestions = input.nextLine();
            	
            	for(User count: allUsers) {
            		
            		if(count.getEmail().equals(textQuestions)) logado = count;            			
        
            	}
            	
            	if(logado == null) System.out.println("E-mail não cadastrado.");
            	else {
            		
            		System.out.println("Seja bem-vindo de volta, "+logado.getName());
            		while(!endOfTheLogin) {
            			
            			logado.menu(allUsers);
            			
            			System.out.println("Você deseja deslogar? (true = sim / false = não)");
                        logicalQuestions = input.nextBoolean();
                        if(logicalQuestions) {
                        	endOfTheLogin = true;
                        	logado = null;
                        }
            		}
            	}
            } else {
            	
            	System.out.println("Qual o seu nível de acesso?");
            	System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador, 4 - Administrador)");
            	numberQuestions = input.nextInt();
            	boolean done = allUsers.add(new User(numberQuestions));
            	if(done) System.out.println("Cadastro feito com sucesso.");
            	else System.out.println("Cadastro deu errado, tente novamente mais tarde.");
            }
            
            System.out.println("Você deseja sair do programa? (true = sim / false = não)");
            logicalQuestions = input.nextBoolean();
            if(logicalQuestions) endOfTheProgram = true;
            
		}
		input.close();
	}
}
