import java.io.Serializable;


public class Person implements Serializable{
	
	/**
	 * Version number for serializable class
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String place;
	private int year;
	
	public Person(String aName, String aPlace, int aYear){
		name = aName;
		place = aPlace;
		year = aYear;
	}
	
	/**
	 * getter method for persons name
	 * @return persons name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * setter method for persons name
	 * @param aName
	 */
	public void setName(String aName){
		name = aName;
	}
	
	/**
	 * getter method for persons place
	 * @return persons place
	 */
	public String getPlace(){
		return place;
	}
	
	/**
	 * setter method for persons place
	 * @param aPlace
	 */
	public void setPlace(String aPlace){
		place = aPlace;
	}
	
	/**
	 * getter method for persons year of birth
	 * @return birth year
	 */
	public int getYear(){
		return year;
	}
	
	/**
	 * setter method for persons year of birth
	 * @param aYear
	 */
	public void setYear(int aYear){
		year = aYear;
	}
}
