package com.igor.payment.domain.repository;

import com.igor.payment.domain.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerModel,String> {
    Optional<CustomerModel> findByEmail(String email);

    Optional<CustomerModel> findByCpf(String cpf);
}
