package org.wecancodeit.Customer.Order.Database;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerOrderController {

	@Resource
	CustomerRepository customerRepo;

	@Resource
	OrderRepository orderRepo;

	@Resource
	ProductRepository productRepo;

	@RequestMapping("/customerorders")
	public String findAllOrders(Model model) {
		model.addAttribute("orders", orderRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "customerorders";
	}

	@RequestMapping("/orderdetail")
	public String getAnOrder(@RequestParam Long id, Model model) {
		model.addAttribute("order", orderRepo.findOne(id));
		return "orderdetail";
	}

	@RequestMapping("/customer")
	public String getACustomer(@RequestParam Long id, Model model) {
		model.addAttribute("customer", customerRepo.findOne(id));
		return "customer";
	}

	@RequestMapping("/add-customerorder")
	public String addCourse(String customerFirstName, String customerLastName, int streetNumber, String streetName,
			String cityName, String stateName, int zipCode, String productName) {
		Product product = productRepo.findByProductName(productName);
		Customer newCustomer = new Customer(customerFirstName, customerLastName, streetNumber, streetName, cityName,
				stateName, zipCode);
		newCustomer = customerRepo.save(newCustomer);
		double productPrice = product.getProductPrice();
		double productCost = product.getProductCost();
		String productLocation = product.getProductLocation();
		if (!(product == null)) {
			Product newProduct = new Product(productName, productPrice, productCost, productLocation);
			newProduct = productRepo.save(newProduct);
			CustomerOrder newCustomerOrder = new CustomerOrder("11/11/11", newCustomer, newProduct);
			newCustomerOrder = orderRepo.save(newCustomerOrder);
		}
		return "redirect:/customerorders";
	}

}
