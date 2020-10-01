package Model;

public class Staff {
	
	private int id;
	private String firstName;
	private String lastName;
	private String MI;
	private String Address;
	private String city;
	private String state;
	private int telephone;
	
	
	public Staff(int id, String firstName, String lastName, String mI, String address, String city, String state,
			int telephone) {
	
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.MI = mI;
		this.Address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
	}


	public int getId() {
		return id;
	}


	


	public String getFirstName() {
		return firstName;
	}


	


	public String getLastName() {
		return lastName;
	}


	


	public String getMI() {
		return MI;
	}


	


	public String getAddress() {
		return Address;
	}


	


	public String getCity() {
		return city;
	}


	


	public String getState() {
		return state;
	}


	


	public int getTelephone() {
		return telephone;
	}


	
	
	

	

}
