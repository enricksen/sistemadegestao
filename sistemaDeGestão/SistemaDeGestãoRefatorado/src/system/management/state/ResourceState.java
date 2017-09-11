package system.management.state;

public interface ResourceState {
	
	ResourceState changeState();
	
	String stateInfo();
}
