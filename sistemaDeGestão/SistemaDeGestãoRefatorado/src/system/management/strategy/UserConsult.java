package system.management.strategy;

import java.util.List;
import java.util.Scanner;

import system.management.User;

public class UserConsult implements Consult {

	String textQuestions;
	Scanner input = new Scanner(System.in);
	
	public void SystemConsult(List<User> users) {
		
		System.out.println("Digite o e-mail do usuário que você deseja consultar:");
		textQuestions = input.nextLine();
		for(User count: users) {
			if(count.getEmail().equals(textQuestions)) count.relate();
		}
	}

}
