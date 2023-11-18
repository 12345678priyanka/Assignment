package customers.usermanagent.module;
import java.sql.*;
import customers.usermanagent.module.*;
public class CustomerApp
{
	private String uuid;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String Email;
	private String Phone;
	
	
	public CustomerApp(String uuid, String firstName, String lastName, String address, String city, String state,
			String email, String phone) {
		super();
		this.uuid = uuid;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		City = city;
		State = state;
		Email = email;
		Phone = phone;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String toString() {
		return "CustomerApp{"+
				"uuid='"+uuid+'\''+
				",FirstName='"+FirstName+'\''+
				",LastName='"+LastName+'\''+
				",Address='"+Address+'\''+
				",City='"+City+'\''+
				",State='"+State+'\''+
				",Email='"+Email+'\''+
				",Phone='"+Phone+'\''+
		'}';
		}
	}



	
	