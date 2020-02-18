package com.customer.service;

import com.customer.model.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<CustomerDto> getCustomers(Pageable pageable);

    void addCustomer(CustomerDto customerDto);

    void updateCustomer(Long id,CustomerDto customerDto);
}
