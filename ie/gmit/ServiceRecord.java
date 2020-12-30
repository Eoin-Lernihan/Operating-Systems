package ie.gmit;

public class ServiceRecord {
	private String nameOfServiceAgent, descriptionOfTheServer;
	private int kilometersOnTheMachine;
	public ServiceRecord(String nameOfServiceAgent, String descriptionOfTheServer, int kilometersOnTheMachine) {
		super();
		this.nameOfServiceAgent = nameOfServiceAgent;
		this.descriptionOfTheServer = descriptionOfTheServer;
		this.kilometersOnTheMachine = kilometersOnTheMachine;
	}
	
	
	public String getNameOfServiceAgent() {
		return nameOfServiceAgent;
	}
	public void setNameOfServiceAgent(String nameOfServiceAgent) {
		this.nameOfServiceAgent = nameOfServiceAgent;
	}
	public String getDescriptionOfTheServer() {
		return descriptionOfTheServer;
	}
	public void setDescriptionOfTheServer(String descriptionOfTheServer) {
		this.descriptionOfTheServer = descriptionOfTheServer;
	}
	public int getKilometersOnTheMachine() {
		return kilometersOnTheMachine;
	}
	public void setKilometersOnTheMachine(int kilometersOnTheMachine) {
		this.kilometersOnTheMachine = kilometersOnTheMachine;
	}
}
