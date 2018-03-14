package org.wecancodeit.Customer.Order.Database;

import org.springframework.data.repository.CrudRepository;
import java.util.Collection;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	
	Collection<Customer> findByCustomerId(Customer customerId);

}
