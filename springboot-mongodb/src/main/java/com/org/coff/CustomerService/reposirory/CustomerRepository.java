package com.org.coff.CustomerService.reposirory;

import com.org.coff.CustomerService.model.CustomerModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerModel,Integer> {
}
