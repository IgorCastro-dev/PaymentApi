package com.igor.payment.domain.repository;

import com.igor.payment.domain.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderModel,String> {
}
