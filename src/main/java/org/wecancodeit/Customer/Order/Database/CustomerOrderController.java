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
		return "customerorders";
	}

	@RequestMapping("/customer")
	public String findCustomer(@RequestParam Long id, Model model) {
		Customer customer = customerRepo.findOne(id);
		model.addAttribute("customer", customer);
		model.addAttribute("customers", customerRepo.findByCustomerId(customer));
		return "customer";
	}
}
