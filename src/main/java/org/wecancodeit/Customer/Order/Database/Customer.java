package org.wecancodeit.Customer.Order.Database;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	public Customer() {
	}

	@Id
	@GeneratedValue
	private long customerId;
	private String fName;
	private String lName;
	private int streetNumber;
	private String streetName;
	private int zipCode;
	private String city;
	private String state;

	public Customer(String fName, String lName, int streetNumber, String streetName, String city, String state,
			int zipCode) {
		this.fName = fName;
		this.lName = lName;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	// database mapping
	@OneToMany(mappedBy = "customer")
	private Collection<CustomerOrder> orders;

	public Collection<CustomerOrder> getOrders() {
		return orders;
	}

	// methods to get customer info
	public long getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public String getFullName() {
		return fName + " " + lName;
	}

	public String getAddress() {
		return streetNumber + " " + streetName + " " + city + " " + state + " " + zipCode;
	}

	@Override
	public int hashCode() {
		return ((Long) customerId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return customerId == ((Customer) obj).customerId;
	}

}
