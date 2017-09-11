package system.management.prototype;

import java.util.Random;
import java.util.Scanner;

import system.management.state.OnProcess;

public class ProjPrototype extends ResourcePrototype {

	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	protected ProjPrototype(ProjPrototype projPrototype) {
		this.id = projPrototype.getId();
		this.responsible = projPrototype.getResponsible();
		this.begin = projPrototype.getBegin();
		this.end = projPrototype.getEnd();
		this.resourceActivities = projPrototype.getResourceActivities();
		this.state = projPrototype.getState();
	}
	
	public ProjPrototype() {
		this.id = String.valueOf(Long.toHexString(rand.nextLong()));
		System.out.println("Digite o e-mail do responsável:");
		this.responsible = input.nextLine();
		System.out.println("Digite a data de inicio no seguinte formato: dd/mm/yy hh:mm");
		this.begin = input.nextLine();
		System.out.println("Digite a data de final no seguinte formato: dd/mm/yy hh:mm");
		this.end = input.nextLine();
		this.state = new OnProcess();
	}
	@Override
	public void showInfo() {
		System.out.println("Esse é um projetor. ID: "+this.id);
	}

	@Override
	public ResourcePrototype resourceClone() {
		
		return new ProjPrototype(this);
	}

}
