package com.customer.mapper;

import com.customer.dao.AddressEntity;
import com.customer.model.AddressDto;

public class AddressMapper {
    public AddressMapper() {
    }

    public static AddressEntity mapDtoToEntity(AddressDto addressDto) {
        return AddressEntity.builder()
                .id(addressDto.getId())
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .build();
    }

    public static AddressDto mapEntityToDto(AddressEntity addressEntity) {
        return AddressDto.builder()
                .id(addressEntity.getId())
                .country(addressEntity.getCountry())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .build();
    }
}
