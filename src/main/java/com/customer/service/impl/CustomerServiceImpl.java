package com.customer.service.impl;

import com.customer.dao.AddressEntity;
import com.customer.dao.CustomerEntity;
import com.customer.exception.NotFoundException;
import com.customer.mapper.CustomerMapper;
import com.customer.model.CustomerDto;
import com.customer.repository.AddressRepository;
import com.customer.repository.CustomerRepository;
import com.customer.service.AddressService;
import com.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
   private final CustomerRepository customerRepository;
   private final AddressRepository addressRepository;
   private AddressService addressService;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        return CustomerMapper.PageCustomerEntitiesToCustomerDtos(customerRepository.findAll(pageable));
    }

    @Override
    public void addCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity=CustomerMapper.customerDtoToCustomerEntity(customerDto);
        AddressEntity addressEntity=customerEntity.getAddress();
        addressEntity.setCustomer(customerEntity);
        customerRepository.save(customerEntity);
        addressRepository.save(addressEntity);
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        CustomerEntity customerEntity=customerRepository.findById(id).orElseThrow(()->new NotFoundException("not-found"));
        AddressEntity addressEntity=customerEntity.getAddress();
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setBirthday(customerDto.getBirthday());
        customerEntity.setPinCode(customerDto.getPinCode());
        customerEntity.setEmail(customerDto.getEmail());
       // addressEntity.setCustomer(customerEntity);
        addressEntity.setCountry(customerDto.getAddressDto().getCountry());
        addressEntity.setCity(customerDto.getAddressDto().getCity());
        addressEntity.setStreet(customerDto.getAddressDto().getStreet());
        customerRepository.save(customerEntity);
        addressRepository.save(addressEntity);
    }


}
