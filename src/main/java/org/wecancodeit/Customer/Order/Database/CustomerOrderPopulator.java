package org.wecancodeit.Customer.Order.Database;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderPopulator implements CommandLineRunner {

	@Resource
	private CustomerRepository customerRepo;

	@Resource
	OrderRepository orderRepo;

	@Resource
	ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {

		Customer customer = new Customer("Brooke", "Robin", 2880, "Burch Road", "Columbus", "Ohio", 43212);
		customer = customerRepo.save(customer);
		Customer customer2 = new Customer("Alex", "Smith", 2550, "Elm Street", "Carmel", "Indiana", 45676);
		customer2 = customerRepo.save(customer2);
		Customer customer3 = new Customer("Sam", "Henry", 1570, "Lane Ave", "Columbus", "Ohio", 43212);
		customer3 = customerRepo.save(customer3);
		Product product = new Product("Paper Towels 12pk", 15.00, 3.00, "A5");
		product = productRepo.save(product);
		Product product2 = new Product("Dish Soap 12oz", 4.00, 2.00, "B7");
		product2 = productRepo.save(product2);
		Product product3 = new Product("Peanut Butter 16oz", 10.00, 7.50, "E8");
		product3 = productRepo.save(product3);
		Product product4 = new Product("Bottled Water 24pk", 7.00, 3.00, "E5");
		product4 = productRepo.save(product4);
		Product product5 = new Product("Gum Spearmint 12pc", 4.75, 3.00, "E6");
		product5 = productRepo.save(product5);
		CustomerOrder order = new CustomerOrder("3/12/2018", customer, product);
		order = orderRepo.save(order);
		CustomerOrder order2 = new CustomerOrder("3/11/2018", customer2, product2, product3);
		order2 =orderRepo.save(order2);
		CustomerOrder order3 = new CustomerOrder("3/12/2018", customer3, product4, product5);
		order3 =orderRepo.save(order3);
		
	}

}
