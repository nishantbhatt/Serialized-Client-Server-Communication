import java.io.Serializable;


public class Couple implements Serializable{
	
	/**
	 * Version number for serializable class
	 */
	private static final long serialVersionUID = 1L;
	Person one;
	Person two;
	
	public Couple (Person a, Person b){
		
		one = a;
		two = b;
	}
	
	public String personOneName(){
		return one.getName();
	}
	
	public String personOnePlace(){
		return one.getPlace();
	}
	
	public int personOneYear(){
		return one.getYear();
	}
	
	public String personTwoName(){
		return two.getName();
	}
	
	public String personTwoPlace(){
		return two.getPlace();
	}
	
	public int personTwoYear(){
		return two.getYear();
	}
}
