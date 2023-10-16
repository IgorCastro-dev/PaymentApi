package com.igor.payment.domain.repository;

import com.igor.payment.domain.model.CreditCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreditCardRepository extends MongoRepository<CreditCardModel,String> {
    List<CreditCardModel> findByNumber(String number);
}
