package com.chaincode.services;


import com.chaincode.domain.Loan;
import com.chaincode.domain.Product;

public interface SyndicatedLoansService {
    Iterable<Loan> getAllSyndicatedLoans();

	void saveProduct(Loan loan);

	Loan getLoanById(String id);

	void settleLoan(String loanID, int settlementAmount);

	/*    Product getProductById(Integer id);

    Product saveProduct(Product product);*/
}
