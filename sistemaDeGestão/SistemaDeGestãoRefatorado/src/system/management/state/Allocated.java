package system.management.state;

public class Allocated implements ResourceState {
	
	public String stateInfo() {
		return "Alocado";
	}

	public ResourceState changeState() {
		return new OnGoing();
	}

}
