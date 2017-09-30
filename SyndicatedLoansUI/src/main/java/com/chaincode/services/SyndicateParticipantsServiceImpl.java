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
import com.chaincode.domain.Participant;
import com.chaincode.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SyndicateParticipantsServiceImpl implements SyndicateParticipantsService {

    private String chainCode;
    private String url ; 


    
    public SyndicateParticipantsServiceImpl (){
    	this.chainCode = "744dce7c908d11fa5b71452d6e44391ffb6dfe62d0bad2fe55d24c9712ea3b1e4a1287921d41be11d6381ad1691c2416b939391899c37bf33633ddf1d98a9f0e";
    	this.url = "https://dbfd3b8eefaa4748ba1b03a2372b4283-vp0.us.blockchain.ibm.com:5004/chaincode";
    }

  
	@Override
	public Participant getParticipantDetails(String id) {
    	ChainCode cd = new ChainCode();
    	ChaincodeId chaincodeID = new ChaincodeId();
    	chaincodeID.setName(chainCode);
    	
    	ConstructorMsg ctorMsg = new ConstructorMsg();
    	ctorMsg.setFunction("GetLoanParticipant");
    	String[] args = new String[1];
    	if(id.equals("first"))    	
    	args[0] = "part1";
    	else
    	args[0] = "part2";
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
        Participant participant_details = null;
        
        try {
        	participant_details = mapper.readValue(response.getResult().getMessage(), Participant.class);
			System.out.println("Fetched participantDetails " + participant_details.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return participant_details;
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

