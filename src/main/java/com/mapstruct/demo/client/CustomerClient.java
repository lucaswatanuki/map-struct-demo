package com.mapstruct.demo.client;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "customerClient", url = "${url}", configuration = ClientConfiguration.class)
public interface CustomerClient {

    @GetMapping("/customers/all")
    List<CustomerDto> findAll();

    @PostMapping(value = "/customers")
    CustomerDto create(CustomerDto dto);
}
