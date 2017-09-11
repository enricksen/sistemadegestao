package system.management.prototype;

import java.util.Random;
import java.util.Scanner;

import system.management.state.OnProcess;

public class LabPrototype extends ResourcePrototype {

	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	protected LabPrototype(LabPrototype labPrototype) {
		this.id = labPrototype.getId();
		this.responsible = labPrototype.getResponsible();
		this.begin = labPrototype.getBegin();
		this.end = labPrototype.getEnd();
		this.resourceActivities = labPrototype.getResourceActivities();
		this.state = labPrototype.getState();
	}
	
	public LabPrototype() {
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
		System.out.println("Esse é um Laboratório. ID: "+this.id);
	}

	@Override
	public ResourcePrototype resourceClone() {
		
		return new LabPrototype(this);
	}

}
