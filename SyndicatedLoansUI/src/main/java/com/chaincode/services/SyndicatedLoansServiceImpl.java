package com.chaincode.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.client.RestTemplate;

import com.chaincode.domain.ChainCode;
import com.chaincode.domain.ChaincodeId;
import com.chaincode.domain.ConstructorMsg;
import com.chaincode.domain.Loan;
import com.chaincode.domain.Params;
import com.chaincode.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SyndicatedLoansServiceImpl implements SyndicatedLoansService {
    private String chainCode;
    private String url ; 

   
    public SyndicatedLoansServiceImpl (){
    	this.chainCode = "744dce7c908d11fa5b71452d6e44391ffb6dfe62d0bad2fe55d24c9712ea3b1e4a1287921d41be11d6381ad1691c2416b939391899c37bf33633ddf1d98a9f0e";
    	this.url = "https://dbfd3b8eefaa4748ba1b03a2372b4283-vp0.us.blockchain.ibm.com:5004/chaincode";
    }

    @Override
    public Iterable<Loan> getAllSyndicatedLoans() {

    		        	ChainCode cd = new ChainCode();
    		        	ChaincodeId chaincodeID = new ChaincodeId();
    		        	chaincodeID.setName(chainCode);
    		        	
    		        	ConstructorMsg ctorMsg = new ConstructorMsg();
    		        	ctorMsg.setFunction("GetParticipatedLoans");
    		        	String[] args = new String[1];
    		        	args[0] = "la1";
    		        	ctorMsg.setArgs(args);
    		        	Params params= new Params();
    		        	params.setType(1);
    		        	params.setChaincodeID(chaincodeID);
    		        	params.setCtorMsg(ctorMsg);
    		        	params.setSecureContext("user_type1_0");
    		                	
    		        	cd.setJsonrpc("2.0");
    		            cd.setMethod("query");
    		            cd.setParams(params);
    		            cd.setId(1);
    		            
    		            ObjectMapper mapper = new ObjectMapper();
    		            
    		            try {
							System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
						} catch (JsonProcessingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    		            
    		            RestTemplate restTemplate = new RestTemplate();
    		            
    		            ChainCode response = restTemplate.postForObject(url, cd, ChainCode.class);
    		            System.out.println(response.getResult().getStatus());
    		            System.out.println(response.getResult().getMessage());
    		            
    		            Loan[] chaincodeLoan = null;
    		            
    		            if(response.getResult().getMessage()!=null)
		            	{ 
    		            
    		            try {
    		            	
    		            		chaincodeLoan = mapper.readValue(response.getResult().getMessage(), Loan[].class);
    		            		System.out.println("Converted Loan Object is " + chaincodeLoan[0].getPropertyId());
    		            	
    						} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    						}
    		            	return new ArrayList<Loan>(Arrays.asList(chaincodeLoan));
		            	}
    		            else     	
    		            		            
    		            return new ArrayList<Loan>();

    		            
 		            
    		        }

	@Override
	public void saveProduct(Loan loan) {
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String loanJSON = null;
		try {
			loanJSON = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loan)).replaceAll("\r\n","");
		} catch (JsonProcessingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		System.out.println("Loan object JSON values are " + loanJSON);

       	ChainCode cd = new ChainCode();
    	ChaincodeId chaincodeID = new ChaincodeId();
    	chaincodeID.setName(chainCode);
    	
    	ConstructorMsg ctorMsg = new ConstructorMsg();
    	ctorMsg.setFunction("CreateLoanParticipation");
    	String[] args = new String[2];
    	args[0] = loan.getId();
    	args[1] = loanJSON;
    	ctorMsg.setArgs(args);
    	Params params= new Params();
    	params.setType(1);
    	params.setChaincodeID(chaincodeID);
    	params.setCtorMsg(ctorMsg);
    	params.setSecureContext("user_type1_0");
            	
    	cd.setJsonrpc("2.0");
        cd.setMethod("invoke");
        cd.setParams(params);
        cd.setId(1);
        
       
        
        try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        RestTemplate restTemplate = new RestTemplate();
        
        ChainCode response = restTemplate.postForObject(url, cd, ChainCode.class);
        
        System.out.println("Response from chaincode for loan Creation" + response.getResult().getStatus());
        /*Loan[] chaincodeLoan = null;
        
        try {
			chaincodeLoan = mapper.readValue(response.getResult().getMessage(), Loan[].class);
			System.out.println("Converted Loan Object is " + chaincodeLoan[0].getPropertyId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
                		
	}

	@Override
	public Loan getLoanById(String id) {
      	ChainCode cd = new ChainCode();
    	ChaincodeId chaincodeID = new ChaincodeId();
    	chaincodeID.setName(chainCode);
    	
    	ConstructorMsg ctorMsg = new ConstructorMsg();
    	ctorMsg.setFunction("GetLoanApplication");
    	String[] args = new String[1];
    	args[0] = id;
    	ctorMsg.setArgs(args);
    	Params params= new Params();
    	params.setType(1);
    	params.setChaincodeID(chaincodeID);
    	params.setCtorMsg(ctorMsg);
    	params.setSecureContext("user_type1_0");
            	
    	cd.setJsonrpc("2.0");
        cd.setMethod("query");
        cd.setParams(params);
        cd.setId(1);
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        RestTemplate restTemplate = new RestTemplate();
        
        ChainCode response = restTemplate.postForObject(url, cd, ChainCode.class);
        
        System.out.println("Response from server is" + response.getResult().getMessage());
        Loan chaincodeLoan = null;
        
        try {
			chaincodeLoan = mapper.readValue(response.getResult().getMessage(), Loan.class);
			System.out.println("Converted Loan Object is " + chaincodeLoan.getPropertyId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return chaincodeLoan;

        
	}

	@Override
	public void settleLoan(String loanId, int settlementAmount) {
		
	ChainCode cd = new ChainCode();
   	ChaincodeId chaincodeID = new ChaincodeId();
   	chaincodeID.setName(chainCode);
   	
   	ConstructorMsg ctorMsg = new ConstructorMsg();
   	ctorMsg.setFunction("SettleLoanSyndication");
   	String[] args = new String[2];
   	args[0] = loanId;
   	args[1] = String.valueOf(settlementAmount);
   	ctorMsg.setArgs(args);
   	Params params= new Params();
   	params.setType(1);
   	params.setChaincodeID(chaincodeID);
   	params.setCtorMsg(ctorMsg);
   	params.setSecureContext("user_type1_0");
           	
   	cd.setJsonrpc("2.0");
       cd.setMethod("invoke");
       cd.setParams(params);
       cd.setId(1);
       
       ObjectMapper mapper = new ObjectMapper();
       
       try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
       RestTemplate restTemplate = new RestTemplate();
       
       ChainCode response = restTemplate.postForObject(url, cd, ChainCode.class);
       
       System.out.println("Response from chaincode for loan Creation" + response.getResult().getStatus());
       /*Loan[] chaincodeLoan = null;
       
       try {
			chaincodeLoan = mapper.readValue(response.getResult().getMessage(), Loan[].class);
			System.out.println("Converted Loan Object is " + chaincodeLoan[0].getPropertyId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
    		      
    }

    /*@Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }*/

