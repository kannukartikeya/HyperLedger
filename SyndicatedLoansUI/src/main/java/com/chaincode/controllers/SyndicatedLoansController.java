package com.chaincode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chaincode.domain.FinancialInfo;
import com.chaincode.domain.Loan;
import com.chaincode.domain.PersonalInfo;
import com.chaincode.domain.Product;
import com.chaincode.services.SyndicatedLoansService;

@Controller
public class SyndicatedLoansController {

    private SyndicatedLoansService syndicatedLoansService;

    @Autowired
    public void setProductService(SyndicatedLoansService syndicatedLoanService) {
        this.syndicatedLoansService = syndicatedLoanService;
    }

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("loans", syndicatedLoansService.getAllSyndicatedLoans());
        System.out.println("Returning loans:");
        return "loans";
    }

  @RequestMapping("loan/{id}")
    public String showProduct(@PathVariable String id, Model model){
        model.addAttribute("loan", syndicatedLoansService.getLoanById(id));
        return "loanshow";
    }

    @RequestMapping("loan/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        model.addAttribute("loan", syndicatedLoansService.getLoanById(id));
        return "loanSettle";
    }
    

    @RequestMapping("loan/new")
    public String newLoan(Model model){
    	

    	
    	Loan newLoan = new Loan("LN00001","NY PLAZA 1","LAND001","PR0001","BY0001",1000,0);
    	newLoan.setDealAmount(newLoan.getApprovedAmount());
    	newLoan.setDealtype("Loan");
    	newLoan.setBaseRateType("LIBOR");
    	newLoan.setAllInRate(5);
    	newLoan.setSpread(2);
    	newLoan.setLastModifiedDate("06/11/2017");
    	FinancialInfo finance = new FinancialInfo();
    	finance.setSpRating("BBB+");
    	finance.setMoodyRating("bba+");
    	finance.setDcr(2);
    	finance.setTurnover(4000);
    	
    	newLoan.setFinancialInfo(finance);
    	
    	PersonalInfo personalInfo = new PersonalInfo();
    	personalInfo.setFirstname("Reliance Industries");
    	personalInfo.setLastname("JIO");
    	personalInfo.setEmail("jio@relianceindustries.com");
    	personalInfo.setAddress("DhirubhaiAmbani KnowLedge City , Navi Mumbai");
    	personalInfo.setContact("+91-22612533/+91-9897216397");
    	
    	newLoan.setPersonalInfo(personalInfo);
    	
    	   	
        model.addAttribute("loan", newLoan);
        return "loanform";
    }

    @RequestMapping(value = "loan", method = RequestMethod.POST)
    public String saveProduct(Loan loan){
    	
    	List<Loan> existingdealList = (List<Loan>) syndicatedLoansService.getAllSyndicatedLoans();
    	
    	if(existingdealList.size()>0)
    	{
    	for(Loan deal:existingdealList)
    	{
    		if(deal.getId().equals(loan.getId()))
    			throw new RuntimeException("Deal Already Exists");
    	}
    	}

    	loan.setOutstandingSettlementAmount(loan.getDealAmount());
        syndicatedLoansService.saveProduct(loan);

        return "redirect:/loan/" + loan.getId();
    }

    
    @RequestMapping(value = "loanSettle", method = RequestMethod.POST)
    public String settleLoan(String loanId,int settlementAmount) throws Exception{
    	
    	if(loanId!=null){

        syndicatedLoansService.settleLoan(loanId,settlementAmount);

        return "redirect:/loan/" + loanId;
    	}
    	else throw new Exception("LoanID cannot be null");
    }
}
