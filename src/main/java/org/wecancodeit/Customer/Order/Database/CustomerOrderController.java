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
	
}
