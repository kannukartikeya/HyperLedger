package com.chaincode.domain;
import javax.persistence.*;

public class Params {
    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSecureContext() {
		return secureContext;
	}

	public void setSecureContext(String secureContext) {
		this.secureContext = secureContext;
	}

	
	@Id
	private int type;
	private ChaincodeId chaincodeID;
    private ConstructorMsg ctorMsg;
    private String secureContext;
    public ChaincodeId getChaincodeID() {
		return chaincodeID;
	}

	public void setChaincodeID(ChaincodeId chaincodeID) {
		this.chaincodeID = chaincodeID;
	}

	public ConstructorMsg getCtorMsg() {
		return ctorMsg;
	}

	public void setCtorMsg(ConstructorMsg ctorMsg) {
		this.ctorMsg = ctorMsg;
	}



	public Params() {
		super();
    }

}