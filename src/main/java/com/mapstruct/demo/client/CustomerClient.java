package com.mapstruct.demo.client;

import com.mapstruct.demo.dto.CustomerDto;

import java.util.List;

public interface CustomerClient {

    List<CustomerDto> findAll();
}
