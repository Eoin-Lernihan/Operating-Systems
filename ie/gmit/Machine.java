package ie.gmit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Machine {
	private static final int Max = 1000000;
	private String name, vendor;
	private int Age, machineId, clubId,lastServiceinKilometres, nextServiceInKilometres, currentKilometres;
	private float valuation;
	private Date lastServiceDate;
	List<ServiceRecord> serviceRecords = new ArrayList<>();
	
	public Machine(String name, String vendor, int age, int clubId, int lastServiceinKilometres,
			int nextServiceInKilometres, int currentKilometres, float valuation, Date lastServiceDate) {
		super();
		this.name = name;
		this.vendor = vendor;
		Age = age;
		this.machineId =(int)(Math.random() * ((Max) + 1));
		this.clubId = clubId;
		this.lastServiceinKilometres = lastServiceinKilometres;
		this.nextServiceInKilometres = nextServiceInKilometres;
		this.currentKilometres = currentKilometres;
		this.valuation = valuation;
		this.lastServiceDate = lastServiceDate;
	}


	public void updateServiceRecord(String nameOfServiceAgent, String descriptionOfTheServer, int kilometersOnTheMachine) {
		serviceRecords.add(new ServiceRecord(nameOfServiceAgent, descriptionOfTheServer, kilometersOnTheMachine));
		int intervale = this.nextServiceInKilometres-this.lastServiceinKilometres;
		this.lastServiceinKilometres = this.currentKilometres;
		this.nextServiceInKilometres = this.currentKilometres + intervale;
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public int getMachineId() {
		return machineId;
	}


	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}


	public int getClubId() {
		return clubId;
	}


	public void setClubId(int clubId) {
		this.clubId = clubId;
	}


	public int getLastServiceinKilometres() {
		return lastServiceinKilometres;
	}


	public void setLastServiceinKilometres(int lastServiceinKilometres) {
		this.lastServiceinKilometres = lastServiceinKilometres;
	}


	public int getNextServiceInKilometres() {
		return nextServiceInKilometres;
	}


	public void setNextServiceInKilometres(int nextServiceInKilometres) {
		this.nextServiceInKilometres = nextServiceInKilometres;
	}


	public int getCurrentKilometres() {
		return currentKilometres;
	}


	public void setCurrentKilometres(int currentKilometres) {
		this.currentKilometres = currentKilometres;
	}


	public float getValuation() {
		return valuation;
	}


	public void setValuation(float valuation) {
		this.valuation = valuation;
	}


	public Date getLastServiceDate() {
		return lastServiceDate;
	}


	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}



}
