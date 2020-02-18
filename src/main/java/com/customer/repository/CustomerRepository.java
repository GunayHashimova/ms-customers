package com.customer.repository;

import com.customer.dao.CustomerEntity;
import com.customer.model.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
