package system.management;

import java.util.Scanner;

public class Activity {
	
	Scanner input = new Scanner(System.in);
	int numberQuestions;
	
	private String title;
	private String description;
	private String members;
	private String materialLink;
	private int type;
	
	public Activity(int userType) {
		System.out.println("Qual o título da sua atividade?");
		this.title = input.nextLine();
		System.out.println("Descreva a sua atividade.");
		this.description = input.nextLine();
		System.out.println("Quem são os membros?");
		this.members = input.nextLine();
		System.out.println("Qual o link do material de apoio?");
		this.materialLink = input.nextLine();
		
		if(userType != 2) this.type = 2;
		else {
			System.out.println("Qual o tipo da atividade?");
			System.out.println("1 - Aula tradicional");
			System.out.println("2 - Apresentação");
			System.out.println("3 - Laboratório");
			this.type = input.nextInt();
		}
	}

	public int getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getMembers() {
		return members;
	}

	public String getMaterialLink() {
		return materialLink;
	}
	
	public void showInfo() {
		System.out.println("Informações da atividade:");
		System.out.println(this.title);
		System.out.println(this.description);
		System.out.println(this.members);
		System.out.println(this.materialLink);
		System.out.println(this.type);
	}
}
