package com.chaincode.domain;

public class FinancialInfo {
	public String getSpRating() {
		return spRating;
	}
	public void setSpRating(String spRating) {
		this.spRating = spRating;
	}
	public String getMoodyRating() {
		return moodyRating;
	}
	public void setMoodyRating(String moodyRating) {
		this.moodyRating = moodyRating;
	}
	public int getDcr() {
		return dcr;
	}
	public void setDcr(int dcr) {
		this.dcr = dcr;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	String spRating;
	String moodyRating;
	int dcr;
	int turnover;

}
