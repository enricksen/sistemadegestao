package system.management.state;

public class OnProcess implements ResourceState {


	public ResourceState changeState() {
		// TODO Auto-generated method stub
		return new Allocated();
	}

	public String stateInfo() {
		return "Em processo de alocação";
	}

}
