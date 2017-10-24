package com.chaincode.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.client.RestTemplate;

import com.chaincode.domain.BlockChain;
import com.chaincode.domain.ChainCode;
import com.chaincode.domain.ChaincodeId;
import com.chaincode.domain.ConstructorMsg;
import com.chaincode.domain.Loan;
import com.chaincode.domain.Params;
import com.chaincode.domain.Participant;
import com.chaincode.domain.Product;
import com.chaincode.domain.SingleBlock;
import com.chaincode.domain.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Filter.Chain;

@Service
public class RegulatorServiceImpl implements RegulatorService {

    private String chainCode;
    private String url ; 
    private String blockurl;


    
    public RegulatorServiceImpl (){
    	this.chainCode = "35b999f07b55ac2f9051c2ebb1838dbe436932df5871db5fbffca226bf9ad2f99a2ce45d012baca1c900730929500ea0c94ac8ca148b425575b6d793336330b9";
    	this.url = "http://localhost:7050/chain";
    	this.blockurl = "http://localhost:7050/chain/blocks";
    }

  
	@Override
	public List<Transaction> getChain() {
/*        try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        
        RestTemplate restTemplate = new RestTemplate();
        
        BlockChain blockHeight = restTemplate.getForObject(url, BlockChain.class);
        
        System.out.println("Height of blockChain is" + blockHeight.getHeight());
        
        int block;
        String eachBlockUrl;
        SingleBlock response;
        
        List<Transaction> blockChainList = new ArrayList<Transaction>();
        
        //for (block=0 ; block<blockHeight.getHeight();block ++)
        for (block=1 ; block<blockHeight.getHeight();block ++)
        {
        	eachBlockUrl = this.blockurl+"/"+block;
        	response = restTemplate.getForObject(eachBlockUrl, SingleBlock.class);
        	if(response!=null)
        	{
        		System.out.println("Block Transaction is "+ response);
        		
        		if(response.getTransactions()!=null){
        			System.out.println("Payload is " + response.getTransactions().get(0).getPayload());
        			Transaction transaction = response.getTransactions().get(0);
        			
        			 byte[] base64decodedBytes = Base64.getDecoder().decode(transaction.getPayload());
        			String decodedString = null;
					try {
						decodedString = new String(base64decodedBytes, "utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			transaction.setPayload(decodedString.replaceAll("[^a-z0-9:,{}+A-Z_-|^\\n]+"," "));
					//transaction.setPayload(decodedString);
        			
        			blockChainList.add(transaction);
        		}
        	}
        }
        
        return blockChainList;
		
    		      
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

