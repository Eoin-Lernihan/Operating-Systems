package ie.gmit;

import java.util.ArrayList;
import java.util.List;

public class Business {
	private String name,email;
	private int businessId;
	List<Machine> fleet = new ArrayList<>();
	List<Machine> machineForSale = new ArrayList<>();
	
	public Business(String name, String email, int businessId) {
		super();
		this.name = name;
		this.email = email;
		this.businessId = businessId;
	}
	
	public List<Machine> getMachineWithin1000KmNextService() {
		
		List<Machine> machinesWithin1000KmNextService = new ArrayList<>();
		//Loops around all machines 
		for ( Machine machine : fleet) {
			//Checks if the machine has less than 1000km to next service
			
			if((machine.getNextServiceInKilometres()-machine.getCurrentKilometres() <= 1000))
			{
				machinesWithin1000KmNextService.add(machine);
			}
		}
		return machinesWithin1000KmNextService;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	
}
