import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main (String[] args){
		
		//Creating reference to point to  the object
		//when the object is received from the client	
		Couple c = null;
		
		try{
			
			//Creating a server socket that is bound to port
			//specified on the Client (4790)
			@SuppressWarnings("resource")
			ServerSocket socketConnection = new ServerSocket(47901);
			
			System.out.println("Server is UP, waiting for"
			+ " incoming object...");
			
			//Accept the connection that is made
			Socket pipe = socketConnection.accept();
			
			//Server input stream to connect to clients output stream
			ObjectInputStream serverInputStream = new
			ObjectInputStream(pipe.getInputStream());
	
			//Server output stream to connect to clients input stream
			ObjectOutputStream serverOutputStream = new
			ObjectOutputStream(pipe.getOutputStream());
			
			//Reading object from server's input stream.
			c = (Couple) serverInputStream.readObject();
			
			try{
				System.out.println("\n *********************************************** \n"
				+ "Person One attributes after server received it from client (Expected): Jhon, Texas, 1999"
				+ "\nPerson One attributes after server received it from client (Actual)"
				+ "\nName: " + c.personOneName()
				+ "\nPlace: " + c.personOnePlace()
				+ "\nYear: " + c.personOneYear());
			} catch (NullPointerException e){System.out.println(e + ": Person One attributes "
				+ "are still not added by server");}
			
			try{
				System.out.println("\n ************************************************ \n"
		            + "Person Two attributes after server received it from client (Expected): Ben, Toronto, 1997"
		            + "\nPerson Two attributes after server received it from client (Actual)"
					+ "\nName: " + c.personTwoName()
					+ "\nPlace: " + c.personTwoPlace()
					+ "\nYear: " + c.personTwoYear());
			} catch (NullPointerException e){System.out.println(e + ": Person Two attributes "
					+ "are still not added by server");}
			

			//Now we add person two to Couple
			c.two = new Person("Ben", "Toronto", 1997);
			

			//Write the changed (Adding person two) to
			//servers output stream.
			serverOutputStream.writeObject(c);
			
			serverInputStream.close();
			serverOutputStream.close();
	
		}	catch(Exception e) {System.out.println(e);}
	}
	
}
