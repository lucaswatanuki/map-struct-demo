package com.mapstruct.demo.controller;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CustomerDto dto) {
        customerService.create(dto);
        return ResponseEntity.ok().body("Customer created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

}
