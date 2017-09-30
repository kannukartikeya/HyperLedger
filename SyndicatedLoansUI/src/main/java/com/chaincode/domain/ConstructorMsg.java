package com.chaincode.domain;
import javax.persistence.*;

public class ConstructorMsg {
    public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	private String function;
    private String[] args;
   
	public ConstructorMsg() {
		super();
    }

}