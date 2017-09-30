package com.chaincode.domain;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
  
	private String id;
	private String dealtype;
	private String baseRateType;
	private int allInRate;	
	private int spread;	
	
  	private String propertyId;
  	private String landId;
  	private String permitId;
  	
	private String buyerId;
	private String appraiserApplicationId;
	private String salesContractId;

	private FinancialInfo financialInfo;
	private PersonalInfo personalInfo;
	
	private String lastModifiedDate;


	

	public Loan(String id, String propertyId, String landId, String permitId, String buyerId, int approvedAmount,int outstandingSettlementAmount ) {
		super();
		this.id = id;
		this.propertyId = propertyId;
		this.landId = landId;
		this.permitId = permitId;
		this.buyerId = buyerId;
		this.approvedAmount = approvedAmount;
		this.outstandingSettlementAmount = outstandingSettlementAmount;
	}
	private int approvedAmount;
	private int dealAmount;

	private int outstandingSettlementAmount;
	
   
   
	public Loan() {
		super();
    }

	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getPropertyId() {
		return propertyId;
	}





	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}





	public String getLandId() {
		return landId;
	}





	public void setLandId(String landId) {
		this.landId = landId;
	}





	public String getPermitId() {
		return permitId;
	}





	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}





	public String getBuyerId() {
		return buyerId;
	}





	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}





	public String getAppraiserApplicationId() {
		return appraiserApplicationId;
	}





	public void setAppraiserApplicationId(String appraiserApplicationId) {
		this.appraiserApplicationId = appraiserApplicationId;
	}





	public String getSalesContractId() {
		return salesContractId;
	}





	public void setSalesContractId(String salesContractId) {
		this.salesContractId = salesContractId;
	}

	
	public int getApprovedAmount() {
		return approvedAmount;
	}
	public void setApprovedAmount(int approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	public int getOutstandingSettlementAmount() {
		return outstandingSettlementAmount;
	}
	public void setOutstandingSettlementAmount(int outstandingSettlementAmount) {
		this.outstandingSettlementAmount = outstandingSettlementAmount;
	}

	
	public FinancialInfo getFinancialInfo() {
		return financialInfo;
	}

	public void setFinancialInfo(FinancialInfo financialInfo) {
		this.financialInfo = financialInfo;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public String getDealtype() {
		return dealtype;
	}

	public void setDealtype(String dealtype) {
		this.dealtype = dealtype;
	}

	public String getBaseRateType() {
		return baseRateType;
	}

	public void setBaseRateType(String baseRateType) {
		this.baseRateType = baseRateType;
	}

	public int getAllInRate() {
		return allInRate;
	}

	public void setAllInRate(int allInRate) {
		this.allInRate = allInRate;
	}

	public int getSpread() {
		return spread;
	}

	public void setSpread(int spread) {
		this.spread = spread;
	}

	public int getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(int dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}