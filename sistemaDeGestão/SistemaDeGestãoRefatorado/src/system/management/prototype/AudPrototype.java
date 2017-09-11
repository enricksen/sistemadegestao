package system.management.prototype;

import java.util.Random;
import java.util.Scanner;

import system.management.state.OnProcess;

public class AudPrototype extends ResourcePrototype {
	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	protected AudPrototype(AudPrototype audPrototype) {
		this.id = audPrototype.getId();
		this.responsible = audPrototype.getResponsible();
		this.begin = audPrototype.getBegin();
		this.end = audPrototype.getEnd();
		this.resourceActivities = audPrototype.getResourceActivities();
		this.state = audPrototype.getState();
	}
	
	public AudPrototype() {
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
		System.out.println("Esse é um auditório. ID: "+this.id);
	}

	@Override
	public ResourcePrototype resourceClone() {
		
		return new AudPrototype(this);
	}
}
