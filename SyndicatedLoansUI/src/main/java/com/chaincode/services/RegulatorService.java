package com.chaincode.services;


import java.util.List;

import com.chaincode.domain.BlockChain;
import com.chaincode.domain.Participant;
import com.chaincode.domain.Transaction;

public interface RegulatorService {

	List<Transaction> getChain();

	/*    Product getProductById(Integer id);

    Product saveProduct(Product product);*/
}
