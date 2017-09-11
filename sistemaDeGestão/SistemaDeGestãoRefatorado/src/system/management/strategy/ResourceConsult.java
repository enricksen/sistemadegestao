package system.management.strategy;

import java.util.List;
import java.util.Scanner;

import system.management.User;
import system.management.prototype.ResourcePrototype;

public class ResourceConsult implements Consult {
	
	String textQuestions;
	Scanner input = new Scanner(System.in);
	User temp;
	
	public void SystemConsult(List<User> users) {
		
		System.out.println("Digite o e-mail do usuário responsável pelo recurso:");
		textQuestions = input.nextLine();
		for(User count: users) {
			if(count.getEmail().equals(textQuestions)) {
				count.userInfo();
				temp = count;
			}
		}
		
		System.out.println("Lista de recursos:");
		
		for(ResourcePrototype count: temp.getUserResources()) {
			count.showInfo();
		}
		
		System.out.println("Digite o id do recurso que deseja consultar:");
		textQuestions = input.nextLine();
		
		for(ResourcePrototype count: temp.getUserResources()) {
			if(count.getId().equals(textQuestions)) count.relate();
		}
	}

}
