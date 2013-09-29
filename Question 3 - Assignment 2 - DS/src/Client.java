import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Client {
	
	public static void main (String[] args){
		
		try{
			//Instantiate person one
			Couple c = new Couple (new Person("Jhon", "Texas", 1999), null);
			
			//Printing person one attributes to verify that
			//it is created properly.

			try{
					System.out.println("\n *********************************************** \n"
					+ "Person One attributes before sending to server (Expected): Jhon, Texas, 1999"
					+ "\nPerson One attributes before sending to server (Actual)"
					+ "\nName: " + c.personOneName()
					+ "\nPlace: " + c.personOnePlace()
					+ "\nYear: " + c.personOneYear());
			} catch (NullPointerException e){System.out.println(e + ": Person One attributes "
					+ "are still not added");}
		
			
			try{
					System.out.println("\n ************************************************ \n"
		            + "Person Two attributes before sending to server (Expected): Ben, Toronto, 1997"
		            + "\nPerson Two attributes before sending to server (Actual)"
					+ "\nName: " + c.personTwoName()
					+ "\nPlace: " + c.personTwoPlace()
					+ "\nYear: " + c.personTwoYear());
			} catch (NullPointerException e){System.out.println(e+ ": Person Two attributes "
					+ "are still not added");}
		
			
			//Creating a socket connection to connect with server using 
			//loop-back address
			@SuppressWarnings("resource")
			Socket socketConnection = new Socket("127.0.0.1", 47901);
			
			//Creating Clients output stream to pass object
			//information over the 'pipe'
			ObjectOutputStream clientOutputStream = new
					ObjectOutputStream(socketConnection.getOutputStream());
			
			//Creating clients input stream to retrieve object
			//information over the 'pipe'
			ObjectInputStream clientInputStream = new
					ObjectInputStream(socketConnection.getInputStream());
			
			//Writing state of object c to the stream
			clientOutputStream.writeObject(c);
			
			//Read object will restore the incoming stream from server
			c = (Couple) clientInputStream.readObject();
			
			//Printing person two attributes to verify that
			//server added person two attributes correctly.

			try{
					System.out.println("\n *********************************************** \n"
					+ "Person One attributes  when the client received the modified"
					+ "\nvalue of Couple from the server (Expected): Jhon, Texas, 1999"
					+ "\nPerson One attributes after modified by server (Actual)"
					+ "\nName: " + c.personOneName()
					+ "\nPlace: " + c.personOnePlace()
					+ "\nYear: " + c.personOneYear());
			} catch (NullPointerException e){System.out.println(e + ": Person One attributes "
					+ "are still not added by server");}
		
			
			try{
				System.out.println("\n ************************************************ \n"
		            + "Person Two attributes when the client received the modified"
		            + "\nvalue of Couple from the server(Expected): Ben, Toronto, 1997"
		            + "\nPerson Two attributes after modified by server (Actual)"
					+ "\nName: " + c.personTwoName()
					+ "\nPlace: " + c.personTwoPlace()
					+ "\nYear: " + c.personTwoYear());
			} catch (NullPointerException e){System.out.println(e + ": Person Two attributes "
					+ "are still not added by server");}
			

			
			clientOutputStream.close();
			clientInputStream.close();
			
		} catch(Exception e){System.out.println(e);}
	}
	
	
	
}
