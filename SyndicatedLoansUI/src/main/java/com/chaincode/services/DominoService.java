package com.chaincode.services;
    import java.io.IOException;

import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.client.RestTemplate;

import com.chaincode.domain.ChainCode;
import com.chaincode.domain.ChaincodeId;
import com.chaincode.domain.ConstructorMsg;
import com.chaincode.domain.Loan;
import com.chaincode.domain.Params;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
     
    public class DominoService {
/*  	public static void main(String[] args) throws UnirestException {
    	PDModel pdmodel = new PDModel(10,10,1.2,2,new Boolean(true),2000.0,2000.0);
    	getPBDetails(pdmodel);
    	}*/
        public static void getAllSyndicatedLoans() throws UnsatisfiedServletRequestParameterException, JsonProcessingException {
/*            HttpResponse<JsonNode> response = Unirest.post("https://app.dominodatalab.com/v1/kannu/iristest/endpoint")
                .header("X-Domino-Api-Key", "dnfc1TeQnffWAZHajlJNvmmJr8DMIXZVxIhWlUEMm9ZnTCe6d3qbhyhkBmMxRNET")
                .header("Content-Type", "application/json")
                .body(new JsonNode("{\"parameters\": [ 5.6, 3.2, 1.7,0.8]}"))
                .asJson();*/
        	
/*        	RestTemplate restTemplate = new RestTemplate();
            Map<String, String> params = new HashMap<String, String>();
            params.put("id", "1");*/
        	
        	ChainCode cd = new ChainCode();
        	ChaincodeId chaincodeID = new ChaincodeId();
        	chaincodeID.setName("86a9aeb8a65eefd21c76e7e44cf28c1894ef8137d90e6c1fb572e629abb1038a64df87fa91f1cf0c714a7c9608942b2857cdd61d8958cc9b948634af54c8ce93");
        	
        	ConstructorMsg ctorMsg = new ConstructorMsg();
        	ctorMsg.setFunction("GetLoanApplication");
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
            
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cd));
            
            RestTemplate restTemplate = new RestTemplate();
            
            ChainCode response = restTemplate.postForObject("https://54058f9fa0ef4db0a14b5bfd351cb0ef-vp0.us.blockchain.ibm.com:5003/chaincode", cd, ChainCode.class);
            
            System.out.println(response.getResult().getMessage());
            
            try {
				Loan chaincodeLoan = mapper.readValue(response.getResult().getMessage(), Loan.class);
				System.out.println("Converted Loan Object is " + chaincodeLoan.getLandId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            
            
            
            //System.out.println(mapper.writeValueAsString(pdModel));
            
        /*    
            restTemplate.postForObject("http://localhost:8080/aurest/rest/payment", pdModel, PDModel.class);
        	String requestbody = "{\"parameters\": [" + pdModel + "]}";
        	
        	System.out.println("Request body is "  + requestbody);
            HttpResponse<JsonNode> response = Unirest.post("https://app.dominodatalab.com/v1/kannu/defaulter/endpoint")
                    .header("X-Domino-Api-Key", "dnfc1TeQnffWAZHajlJNvmmJr8DMIXZVxIhWlUEMm9ZnTCe6d3qbhyhkBmMxRNET")
                    .header("Content-Type", "application/json")
                    .body(new JsonNode(requestbody))
                    .asJson();
            HttpResponse<JsonNode> response = Unirest.post("https://trial.dominodatalab.com/v1/kartik/defaulter/endpoint")
                    .header("X-Domino-Api-Key", "iiaPA42kplRz0lG8TRDOTmgHLDThnU3gJsOAK6SLB8U68VWDeCg5U5PcoF7zz9R9")
                    .header("Content-Type", "application/json")
                    .body(new JsonNode(requestbody))
                    .asJson();
            //.body(new JsonNode("{\"parameters\": [0,759,755,83.7,1,TRUE]}"))
            //System.out.println(response.getStatus());
            //System.out.println(response.getHeaders());
            System.out.println(response.getBody().getObject().toString(2));
            
            String classification = response.getBody().getObject().getJSONArray("result").get(0).toString();
            String probability_default = response.getBody().getObject().getJSONArray("result").get(1).toString();

            System.out.println(classification);
            System.out.println(probability_default);
            pdModel.setScore(classification);
            pdModel.setProb_default(probability_default);*/
            
           // return pdModel;
            
        }
      
        
    }

