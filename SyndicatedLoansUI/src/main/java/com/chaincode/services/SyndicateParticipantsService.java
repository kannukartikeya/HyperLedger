package com.chaincode.services;


import com.chaincode.domain.Loan;
import com.chaincode.domain.Participant;
import com.chaincode.domain.Product;

public interface SyndicateParticipantsService {

	Participant getParticipantDetails(String id);

	/*    Product getProductById(Integer id);

    Product saveProduct(Product product);*/
}
