package system.management.prototype;
import java.util.ArrayList;
import java.util.List;

import system.management.Activity;
import system.management.state.ResourceState;

public abstract class ResourcePrototype {
	
	protected String id;
	protected String responsible;
	protected String begin;
	protected String end;
	protected ResourceState state;
	
	public ResourceState getState() {
		return state;
	}

	public void setState(ResourceState state) {
		this.state = state;
	}

	protected List<Activity> resourceActivities = new ArrayList<Activity>();
	
	public List<Activity> getResourceActivities() {
		return resourceActivities;
	}

	public void setResourceActivities(List<Activity> resourceActivities) {
		this.resourceActivities = resourceActivities;
	}

	public abstract void showInfo();
	
	public abstract ResourcePrototype resourceClone();

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getId() {
		return id;
	}

	public String getBegin() {
		return begin;
	}

	public String getEnd() {
		return end;
	}
	
	public void changeState() {
		this.state = this.state.changeState();
	}
	
	public void relate() {
		for(Activity count: this.resourceActivities) {
			count.showInfo();
			System.out.println("---------");
		}
	}
	
}
