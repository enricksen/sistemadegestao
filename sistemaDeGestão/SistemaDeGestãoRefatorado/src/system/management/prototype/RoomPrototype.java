package system.management.prototype;

import java.util.Random;
import java.util.Scanner;

import system.management.state.OnProcess;

public class RoomPrototype extends ResourcePrototype {

	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	protected RoomPrototype(RoomPrototype roomPrototype) {
		this.id = roomPrototype.getId();
		this.responsible = roomPrototype.getResponsible();
		this.begin = roomPrototype.getBegin();
		this.end = roomPrototype.getEnd();
		this.resourceActivities = roomPrototype.getResourceActivities();
		this.state = roomPrototype.getState();
	}
	
	public RoomPrototype() {
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
		System.out.println("Essa é uma Sala. ID: "+this.id);
	}

	@Override
	public ResourcePrototype resourceClone() {
		
		return new RoomPrototype(this);
	}

}
