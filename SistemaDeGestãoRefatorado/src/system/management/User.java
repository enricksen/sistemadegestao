package system.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import system.management.prototype.AudPrototype;
import system.management.prototype.LabPrototype;
import system.management.prototype.ProjPrototype;
import system.management.prototype.ResourcePrototype;
import system.management.prototype.RoomPrototype;
import system.management.strategy.Consult;
import system.management.strategy.ResourceConsult;
import system.management.strategy.UserConsult;



public class User {
	
	Scanner input = new Scanner(System.in);
	int numberQuestions;
	String textQuestions;
	
	private String name;
	private String email;
	private int type;
	private List<ResourcePrototype> userResources = new ArrayList<ResourcePrototype>();
	Consult strategy;
	
	public User(int userType) {
		
		super();
		System.out.println("Digite o seu nome:");
		this.name = input.nextLine();
		System.out.println("Digite o seu e-mail:");
		this.email = input.nextLine();
		this.type = userType;
		
	}

	public List<ResourcePrototype> getUserResources() {
		return userResources;
	}
	
	public void relate() {
		this.userInfo();
		System.out.println("*********");
		System.out.println("Recursos e atividades:");
		for(ResourcePrototype count:this.userResources) {
			count.relate();
			System.out.println("===========");
		}
	}

	public void setUserResources(List<ResourcePrototype> userResources) {
		this.userResources = userResources;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getType() {
		return type;
	}
	
	public void userInfo() {
		System.out.println(this.name);
		System.out.println(this.email);
	}
	
	public void resourceAllocate() {
		
		if(this.type == 1) {
			
            System.out.println("Recursos disponíveis:");
            System.out.println("1 - Sala");
            numberQuestions = input.nextInt();
            
            if(numberQuestions == 1) {
            	this.userResources.add(new RoomPrototype());
            }
            
		} else {
			
			System.out.println("Recursos disponíveis:");
            System.out.println("1 - Sala");
            System.out.println("2 - Laboratório");
            System.out.println("3 - Auditório");
            System.out.println("4 - Projetor");
            numberQuestions = input.nextInt();
            
			if(numberQuestions == 1) {
				this.userResources.add(new RoomPrototype());
			} else if(numberQuestions == 2) {
				this.userResources.add(new LabPrototype());
			} else if(numberQuestions == 3) {
				this.userResources.add(new AudPrototype());
			} else if(numberQuestions == 4) {
				this.userResources.add(new ProjPrototype());
			}
		}
	}
	
	public void resourceConfirm() {
		System.out.println("Lista de recursos:");
		
		for(ResourcePrototype count: userResources) {
			if(count.getState().stateInfo().equals("Alocado")) {
				count.showInfo();
				System.out.println(" ");
			}
		}
		
		System.out.println("Digite o ID do recurso que você quer confirmar:");
		textQuestions = input.nextLine();
		
		for(ResourcePrototype count: userResources) {
			if(count.getId().equals(textQuestions)) count.changeState();
		}
		
		System.out.println("Confirmação feita com sucesso.");
	}
	
	public void resourceAllocateProcess() {
		System.out.println("Lista de recursos:");
		
		for(ResourcePrototype count: userResources) {
			if(count.getState().stateInfo().equals("Em processo de alocação")) {
				count.showInfo();
				System.out.println(" ");
			}
		}
		
		System.out.println("Digite o ID do recurso que você quer confirmar:");
		textQuestions = input.nextLine();
		
		for(ResourcePrototype count: userResources) {
			if(count.getId().equals(textQuestions)) count.changeState();
		}
		
		System.out.println("Confirmação feita com sucesso.");
	}
	
	public void resourcesConclusion() {
		System.out.println("Lista de recursos:");
		
		for(ResourcePrototype count: userResources) {
			if(count.getState().stateInfo().equals("Em andamento")) {
				count.showInfo();
				System.out.println(" ");
			}
		}
		
		System.out.println("Digite o ID do recurso que você quer confirmar:");
		textQuestions = input.nextLine();
		
		for(ResourcePrototype count: userResources) {
			if(count.getId().equals(textQuestions)) count.changeState();
		}
		
		System.out.println("Confirmação feita com sucesso.");
	}
	
	public void addActivities() {
		System.out.println("Lista de recursos:");
		
		for(ResourcePrototype count: userResources) {
			if(count.getState().stateInfo().equals("Em andamento")) {
				count.showInfo();
				System.out.println(" ");
			}
		}
		
		System.out.println("Digite o ID do recurso que você quer adicionar atividade:");
		textQuestions = input.nextLine();
		
		for(ResourcePrototype count: userResources) {
			if(count.getId().equals(textQuestions)) count.getResourceActivities().add(new Activity(this.type));
		}
		
		System.out.println("Atividade cadastrada com sucesso.");
		
	}
	
	public void usersNumber(List<User> all) {
		System.out.println(all.size());
	}
	
	public void resourcesNumber(List<User> all) {
		int sum = 0;
		for(User count:all) {
			sum += count.userResources.size();
		}
		System.out.println(sum);
	}
	
	public void activitiesNumber(List<User> all) {
		int sum = 0;
		for(User count:all) {
			for(ResourcePrototype count2:count.userResources) {
				sum += count2.getResourceActivities().size();
			}
		}
		System.out.println(sum);
	}
	
	public void menu(List<User> allUsers) {
		
		System.out.println("*** Menu Principal ***");
		if(this.type == 1) {
			
			System.out.println("1 - Alocar Recursos");
			System.out.println("2 - Sair");
			numberQuestions = input.nextInt();
			
			if(numberQuestions == 1) this.resourceAllocate();
			
		} else if(this.type == 2 || this.type == 3) {
			
			System.out.println("1 - Alocar Recursos");
            System.out.println("2 - Confirmar recurso");
            System.out.println("3 - Adicionar atividade aos recursos");
            System.out.println("4 - Sair");
            numberQuestions = input.nextInt();
            
            if(numberQuestions == 1) this.resourceAllocate();
            else if(numberQuestions == 2) this.resourceConfirm();
            else if(numberQuestions == 3) this.addActivities();
            
		} else {
			
			System.out.println("Menu de administrador:");
            System.out.println("1 - Número de usuários");
            System.out.println("2 - Número de recursos");
            System.out.println("3 - Número de atividades");
            System.out.println("4 - Consulta por usuário");
            System.out.println("5 - Consulta por recurso/alocação");
            System.out.println("6 - Concluir alocação");
            System.out.println("7 - Alocar processo de alocação");
            System.out.println("8 - Alocar recursos");
            System.out.println("9 - Confirmar alocação");
            System.out.println("10 - Adicionar atividade as alocações");
            System.out.println("11 - Sair");
            numberQuestions = input.nextInt();
            
            if(numberQuestions == 1) this.usersNumber(allUsers);
            else if(numberQuestions == 2) this.resourcesNumber(allUsers);
            else if(numberQuestions == 3) this.activitiesNumber(allUsers);
            else if(numberQuestions == 4) {
            	
            	strategy = new UserConsult();
            	strategy.SystemConsult(allUsers);
            	
            } else if(numberQuestions == 5) {
            	
            	strategy = new ResourceConsult();
            	strategy.SystemConsult(allUsers);
            	
            } else if(numberQuestions == 6) this.resourcesConclusion();
            else if(numberQuestions == 7) this.resourceAllocateProcess();
            else if(numberQuestions == 8) this.resourceAllocate();
            else if(numberQuestions == 9) this.resourceConfirm();
            else if(numberQuestions == 10) this.addActivities();
		}
	}
}
