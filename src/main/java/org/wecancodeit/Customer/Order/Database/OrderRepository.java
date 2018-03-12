package org.wecancodeit.Customer.Order.Database;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

}
