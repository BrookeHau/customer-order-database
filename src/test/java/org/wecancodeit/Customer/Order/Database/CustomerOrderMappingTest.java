package org.wecancodeit.Customer.Order.Database;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CustomerOrderMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CustomerRepository custRepo;

	@Resource
	private OrderRepository orderRepo;

	@Resource
	private ProductRepository prodRepo;

	@Test
	public void saveAndLoadProduct() {
		Product product = new Product("Name", 125.00, 120.00, "A5");
		product = prodRepo.save(product);
		long productId = product.getProductId();

		entityManager.flush();
		entityManager.clear();

		product = prodRepo.findOne(productId);
		assertThat(product.getProductName(), is("Name"));
	}

	@Test
	public void saveAndLoadCustomer() {
		Customer customer = new Customer("FName", "LName", 2248, "Club Road", "Columbus", "OH", 43221);
		customer = custRepo.save(customer);
		long customerId = customer.getCustomerId();

		entityManager.flush();
		entityManager.clear();

		customer = custRepo.findOne(customerId);
		assertThat(customer.getFullName(), is("FName LName"));
	}

	@Test
	public void saveAndLoadOrder() {
		Customer customer = new Customer("FName", "LName", 2248, "Club Road", "Columbus", "OH", 43221);
		customer = custRepo.save(customer);
		Product product = new Product("Name", 125.00, 120.00, "A5");
		product = prodRepo.save(product);
		CustomerOrder order = new CustomerOrder("09/21/17", customer, product);
		order = orderRepo.save(order);
		long orderId = order.getOrderId();

		entityManager.flush();
		entityManager.clear();

		order = orderRepo.findOne(orderId);
		assertThat(order.getCustomer().getFullName(), is("FName LName"));
	}

	@Test
	public void getCustomerAddress() {
		Customer customer = new Customer("FName", "LName", 2248, "Club Road", "Columbus", "OH", 43221);
		customer = custRepo.save(customer);
		Product product = new Product("Name", 125.00, 120.00, "A5");
		product = prodRepo.save(product);
		CustomerOrder order = new CustomerOrder("09/21/17", customer, product);
		order = orderRepo.save(order);
		long orderId = order.getOrderId();

		entityManager.flush();
		entityManager.clear();

		order = orderRepo.findOne(orderId);
		assertThat(order.getCustomer().getAddress(), is("2248 Club Road Columbus OH 43221"));
	}

	@Test
	public void getProductFromOrder() {
		Customer customer = new Customer("FName", "LName", 2248, "Club Road", "Columbus", "OH", 43221);
		customer = custRepo.save(customer);
		Product product = new Product("Name", 125.00, 120.00, "A5");
		product = prodRepo.save(product);
		CustomerOrder order = new CustomerOrder("09/21/17", customer, product);
		order = orderRepo.save(order);
		long orderId = order.getOrderId();

		entityManager.flush();
		entityManager.clear();

		order = orderRepo.findOne(orderId);
		assertThat(order.getProducts(), contains(product));
	}
	
	@Test
	public void getCustomerFromOrder() {
		Customer customer = new Customer("FName", "LName", 2248, "Club Road", "Columbus", "OH", 43221);
		customer = custRepo.save(customer);
		Product product = new Product("Name", 125.00, 120.00, "A5");
		product = prodRepo.save(product);
		CustomerOrder order = new CustomerOrder("09/21/17", customer, product);
		order = orderRepo.save(order);
		long orderId = order.getOrderId();

		entityManager.flush();
		entityManager.clear();

		order = orderRepo.findOne(orderId);
		assertThat(order.getCustomer().getFullName(), is("FName LName"));
	}

}
