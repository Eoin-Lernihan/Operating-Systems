package ie.gmit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server extends Thread {

	private Socket conn;
	private int id;
	ObjectOutputStream out;
	ObjectInputStream in;
	String businessName = "default";
	String businessId = "default";
	String BusinessEmail;
	String regid = "default";
	String option;
	String response;
	String message;
	String name, email;
	int number;
	boolean logedIn = false, businessExist = false;
	//Share the business list across all severs
	static List<Business> businesses = new ArrayList<>();
	Business logedInBusiness = null;

	public Server(Socket c, int i) {
		conn = c;
		id = i;
		businesses.add(new Business("naem", "email", 1));
		businesses.add(new Business("nem", "email", 2));
	}

	public void run() {
		try {
			out = new ObjectOutputStream(conn.getOutputStream());
			in = new ObjectInputStream(conn.getInputStream());
			
			// Server Conversation

			do {
				message = (String) in.readObject();

				out.writeObject("Press 1 for Login or 2 for Register");
				out.flush();

				option = (String) in.readObject();

				if (option.equalsIgnoreCase("1")) {
					// Login
					out.writeObject("Please enter the Business name and Id");
					out.flush();

					name = (String) in.readObject();

					number = Integer.valueOf((String)in.readObject());
					
					for (Business business : businesses) {

						if (name.equalsIgnoreCase(business.getName()) && number == business.getBusinessId()) {
							response = "OK";
							logedIn = true;
							logedInBusiness = business;
							out.writeObject("OK");
							out.flush();
						
						}
					}
	
					if (logedIn != true) {
						response = "FAIL";
						out.writeObject("FAIL");
						out.flush();
					}
				}
				
				if (option.equalsIgnoreCase("2")) {
					out.writeObject("Please enter your Business name, Id and email");
					out.flush();
					name = (String) in.readObject();
					number = Integer.valueOf((String)in.readObject());
					email = (String) in.readObject();
					for (Business business : businesses) {
						if(name.equalsIgnoreCase(business.getName()) || number == business.getBusinessId()) {
							businessExist = true;
						}
					}
					
					if(!businessExist) {
						businesses.add(new Business(name, email, number));
						out.writeObject("Your business has now been register, we will send an email to verify it you");
						out.flush();
					}
					else {
						out.writeObject("This name or id has been taken");
					}
				}


			} while (!logedIn);
			
			do {
			message = (String) in.readObject();
			
			String string = "Please enter what you would like to do \n"
					+ "1.Add a new Machine\n"
					+ "2.Update the Machinery's Service Record\n"
					+ "3.Update the current kilometer\n"//check
					+ "4.Search all fleet items within 1000Km of their next service\n"
					+ "5.Remove a fleet item\n"
					+ "6.Register a fleet item for Sale\n"
					+ "7.Search all fleet items for Sale\n";
			out.writeObject(string);
			
			out.flush();

			option = (String) in.readObject();

			if (option.equalsIgnoreCase("1")) {
				// Login
				out.writeObject("Name of machine");
				out.flush();
				name = (String) in.readObject();
				
				out.writeObject("Age of machine");
				out.flush();
				int age = Integer.valueOf((String)in.readObject());	
				
				
				out.writeObject("The vendor");
				out.flush();
				String vendor = (String) in.readObject();
				
				out.writeObject("Last valuation");
				out.flush();
				float valuation = Float.valueOf((String)in.readObject());	
				
				out.writeObject("Last service in kilometres");
				out.flush();
				int lastServiceInKilometres = Integer.valueOf((String)in.readObject());
				
				out.writeObject("last Service Date IN DD/MM/YYYY");
				out.flush();
				Date lastServiceDate = new SimpleDateFormat("dd/MM/yyyy").parse((String)in.readObject());  
				
				out.writeObject("Next service in kilometres");
				out.flush();
				int nextServiceInKilometres = Integer.valueOf((String)in.readObject());	
				
				out.writeObject("Current kilometres");
				out.flush();
				int currentKilometres = Integer.valueOf((String)in.readObject());	

				Machine machine = new Machine(name, vendor, age,number, lastServiceInKilometres, 
												nextServiceInKilometres, currentKilometres, valuation, lastServiceDate);
				
				logedInBusiness.fleet.add(machine);
				
				string = machine.getName() + machine.getMachineId() + " has been added";
				out.writeObject(string);
				out.flush();
				
			}

			else if (option.equalsIgnoreCase("2")) {
				// Register
				out.writeObject("Please enter to numbers to subtrack");
				out.flush();
			
			}
			
			else if (option.equalsIgnoreCase("3")) {
				// Register
				out.writeObject("Please enter to numbers to multiply");
				out.flush();
				
			}
			
			
			else if (option.equalsIgnoreCase("4")) {
				
				for (Machine machine : logedInBusiness.getMachineWithin1000KmNextService()) {
					string += machine.getName() + " " + machine.getMachineId() + " " + machine.getCurrentKilometres() + "/n";
				} 
				
				out.writeObject(string);
				out.flush();
				
			}
			else {
				out.writeObject("Error");
			}
			
			
			
			} while (!option.equalsIgnoreCase("8"));	// Logged in menu
		}

		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket listener;
		Socket connection;
		int id = 0;

		try {
			listener = new ServerSocket(25000, 10);

			while (true) {

				System.out.println("Listening for a connection");
				connection = listener.accept();
				System.out.println("Received Connection from " + connection.getInetAddress());

				Server th = new Server(connection, id);
				id++;
				th.start();
			}

		} catch (Exception e) {

		}

	}

}
