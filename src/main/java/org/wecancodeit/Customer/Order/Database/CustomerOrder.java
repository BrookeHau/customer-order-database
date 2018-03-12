package org.wecancodeit.Customer.Order.Database;

import java.util.Collection;
import java.util.HashSet;
import static java.util.Arrays.asList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue
	private long orderId;
	private String orderDate;

	public CustomerOrder(String orderDate, Customer customer, Product... products) {
		this.orderDate = orderDate;
		this.customer = customer;
		this.products = new HashSet<>(asList(products));
	}

	public CustomerOrder() {
	}

	// database mapping
	@ManyToOne
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	@ManyToMany
	private Collection<Product> products;

	public Collection<Product> getProducts() {
		return products;
	}

	// methods to get Order Info
	public String getOrderDate() {
		return orderDate;
	}

	public long getOrderId() {
		return orderId;
	}

	@Override
	public int hashCode() {
		return ((Long) orderId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return orderId == ((CustomerOrder) obj).orderId;
	}

}
