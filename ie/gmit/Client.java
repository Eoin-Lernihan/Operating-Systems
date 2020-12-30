package ie.gmit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		Socket connection;
		ObjectOutputStream out;
		ObjectInputStream in;
		String message;
		String response="";
		String option;
		
		try
		{
			connection = new Socket("127.0.0.1",25000);
			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
			
            //Conversation starts.....
			do
			{
			out.writeObject("GetMenu");
			out.flush();
			
			message = (String)in.readObject();
			System.out.println(message);
			option = input.nextLine();
			
			out.writeObject(option);
			out.flush();
			
			if(option.equalsIgnoreCase("1"))
			{
				getLabelResponse(input, out, in);
				
				//Password
				response = input.nextLine();
				out.writeObject(response);
				out.flush();
				
				response = (String)in.readObject();
				System.out.println(response);
			}
			
			else if(option.equalsIgnoreCase("2"))
			{
				getLabelResponse(input, out, in);
				
				//Business ID
				response = input.nextLine();
				out.writeObject(response);
				out.flush();
				
				//Email
				response = input.nextLine();
				out.writeObject(response);
				out.flush();
				
				response = (String)in.readObject();
				System.out.println(response);
			}
			
			}while(option.equalsIgnoreCase("2")||response.equalsIgnoreCase("FAIL"));
			
			
			
			do
			{
			out.writeObject("GetMenu");
			out.flush();
			
			message = (String)in.readObject();
			System.out.println(message);
			option = input.nextLine();
			
			out.writeObject(option);
			out.flush();
			
			if(option.equalsIgnoreCase("1"))
			{
				//label,name of machine
				getLabelResponse(input, out, in);
				//Age
				getLabelResponse(input, out, in);
				//vendor
				getLabelResponse(input, out, in);
				//Valuation
				getLabelResponse(input, out, in);
				//lastin
				getLabelResponse(input, out, in);
				//last ser
				getLabelResponse(input, out, in);
				//next
				getLabelResponse(input, out, in);
				//current
				getLabelResponse(input, out, in);
				
			}
			
			else if(option.equalsIgnoreCase("s"))
			{
				message = (String)in.readObject();
				System.out.println(message);
				
			}
			
			else if(option.equalsIgnoreCase("m"))
			{
				message = (String)in.readObject();
				System.out.println(message);
				
			}
			
			else if(option.equalsIgnoreCase("4"))
			{
				message = (String)in.readObject();
				System.out.println(message);
				
			}
			
			
			}while(!option.equalsIgnoreCase("8"));
			
		}
		
		catch(Exception e)
		{
		System.out.println("Error");	
		}
	}

	private static void getLabelResponse(Scanner input, ObjectOutputStream out, ObjectInputStream in)
			throws IOException, ClassNotFoundException {
		String message;
		String response;
		message = (String)in.readObject();
		System.out.println(message);
		response = input.nextLine();
		out.writeObject(response);
		out.flush();
	}

}
