package com.customer.controller;

import com.customer.model.CustomerDto;
import com.customer.service.CustomerService;
import com.customer.service.impl.CustomerServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Page<CustomerDto> getCustomers(Pageable pageable){
        return customerService.getCustomers(pageable);
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Long id,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(id,customerDto);
    }
}
