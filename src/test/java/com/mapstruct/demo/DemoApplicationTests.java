package com.mapstruct.demo;

import com.mapstruct.demo.client.CustomerClient;
import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class DemoApplicationTests extends ConfigurationTest{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerClient client;

	@Test
	void shouldSaveCustomer() {
		final String msg = client.create(CustomerDto.builder()
				.alias("name")
				.build());

		List<Customer> customers = client.findAll();

		assertThat(customers).isNotEmpty();
	}

}
