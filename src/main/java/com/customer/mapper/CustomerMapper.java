package com.customer.mapper;

import com.customer.dao.CustomerEntity;
//import com.customer.model.AddressDto;
import com.customer.model.CustomerDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CustomerMapper {
    private  CustomerMapper(){

    }

    public static CustomerDto customerEntityToCustomerDto(CustomerEntity customerEntity) {
        return CustomerDto.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .birthday(customerEntity.getBirthday())
                .email(customerEntity.getEmail())
                .pinCode(customerEntity.getPinCode())
               .addressDto(AddressMapper.mapEntityToDto(customerEntity.getAddress()))
                .build();
    }

    public static CustomerEntity customerDtoToCustomerEntity(CustomerDto customerDto) {
        return CustomerEntity.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .birthday(customerDto.getBirthday())
                .email(customerDto.getEmail())
                .pinCode(customerDto.getPinCode())
                .address(AddressMapper.mapDtoToEntity(customerDto.getAddressDto()))
                .build();
    }

    public static List<CustomerDto> customerEntitiesToCustomerDtos(Iterable<CustomerEntity> customerEntities) {
        return StreamSupport.stream(customerEntities.spliterator(), false)
                .map(CustomerMapper::customerEntityToCustomerDto)
                .collect(Collectors.toList());
    }

    public static List<CustomerEntity> customerDtosToCustomerEntities(Iterable<CustomerDto> customerDtos) {
        return StreamSupport.stream(customerDtos.spliterator(), false)
                .map(CustomerMapper::customerDtoToCustomerEntity)
                .collect(Collectors.toList());
    }

    public static Page<CustomerDto> PageCustomerEntitiesToCustomerDtos(Page<CustomerEntity> page){
        return page.map(CustomerMapper::customerEntityToCustomerDto);
    }

    public static Page<CustomerEntity> PageCustomerDtosToPageCustomersEntities(Page<CustomerDto> page){
        return page.map(CustomerMapper::customerDtoToCustomerEntity);
    }
}
