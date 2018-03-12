package org.wecancodeit.Customer.Order.Database;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("c", orderRepo.findAll());
		return "customerorders";
	}
}
