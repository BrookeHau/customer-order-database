package org.wecancodeit.Customer.Order.Database;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClassTest {

	private Customer customer = new Customer("FName", "LName", 280, "Club Road", "Columbus", "OH", 43210);

	@Test
	public void getProductInfo() {
		Product product = new Product("Name", 125.00, 120.00, "A5");
		String check = product.getProductName();
		double check2 = product.getProductPrice();
		double check3 = product.getProductCost();
		String check4 = product.getProductLocation();
		assertThat(check, is("Name"));
		assertThat(check2, is(125.00));
		assertThat(check3, is(120.00));
		assertThat(check4, is("A5"));
	}

	@Test
	public void getOrderInfo() {
		Product product = new Product("Name", 125.00, 120.00, "A5");
		CustomerOrder order = new CustomerOrder("11/11/11",customer, product);
		String check = order.getOrderDate();
		assertThat(check, is("11/11/11"));
	}

	@Test
	public void getCustomeNameInfo() {
		String check = customer.getFirstName();
		String check2 = customer.getLastName();
		String check3 = customer.getFullName();
		assertThat(check , is("FName"));
		assertThat(check2 , is("LName"));
		assertThat(check3 , is("FName LName"));	
	}
	
	@Test 
	public void customerAddressInfo() {
		String check = customer.getAddress();
		assertThat(check , is("280 Club Road Columbus OH 43210"));
		
	}

}
