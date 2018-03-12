package org.wecancodeit.Customer.Order.Database;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long productId;
	private String productName;
	private double productPrice;
	private double productCost;
	private String productLocation;

	public Product() {

	}

	public Product(String productName, double productPrice, double productCost, String productLocation) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCost = productCost;
		this.productLocation = productLocation;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public double getProductCost() {
		return productCost;
	}

	public Long getProductId() {
		return productId;
	}

	// database mapping
	@ManyToMany(mappedBy = "products")
	public Collection<CustomerOrder> orders;

	public Collection<CustomerOrder> getOrders() {
		return orders;
	}

	// methods to get Product Info
	public String getProductLocation() {
		return productLocation;
	}

	@Override
	public int hashCode() {
		return ((Long) productId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return productId == ((Product) obj).productId;
	}

}
