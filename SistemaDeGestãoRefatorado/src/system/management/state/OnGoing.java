package system.management.state;

public class OnGoing implements ResourceState {


	public ResourceState changeState() {
		
		return new Done();
	}

	public String stateInfo() {
		
		return "Em andamento";
	}

}
