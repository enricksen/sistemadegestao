package system.management.state;

public class Done implements ResourceState {


	public ResourceState changeState() {
		
		return this;
	}

	public String stateInfo() {
		
		return "Concluído";
	}

}
