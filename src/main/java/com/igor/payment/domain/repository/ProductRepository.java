package com.igor.payment.domain.repository;

import com.igor.payment.domain.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductModel,String> {
    Optional<ProductModel> findByAcronym(String acronym);
}
