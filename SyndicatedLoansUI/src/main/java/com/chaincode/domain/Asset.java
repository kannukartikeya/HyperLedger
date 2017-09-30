package com.chaincode.domain;
import javax.persistence.*;

public class Asset {


	public int getShare() {
		return share;
	}


	public void setShare(int share) {
		this.share = share;
	}


	public int getShareAmount() {
		return shareAmount;
	}


	public void setShareAmount(int shareAmount) {
		this.shareAmount = shareAmount;
	}


	public int getSyndicatedAmount() {
		return syndicatedAmount;
	}


	public void setSyndicatedAmount(int syndicatedAmount) {
		this.syndicatedAmount = syndicatedAmount;
	}


	private String loanId;
    public String getLoanId() {
		return loanId;
	}


	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}


	private int  share;
    private int shareAmount;
    private int syndicatedAmount;
    private float settlementFees;
   


	public float getSettlementFees() {
		return settlementFees;
	}


	public void setSettlementFees(float settlementFees) {
		this.settlementFees = settlementFees;
	}


	public Asset() {
		super();
    }
	
	

}