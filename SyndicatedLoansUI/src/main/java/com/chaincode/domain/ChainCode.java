package com.chaincode.domain;
import javax.persistence.*;

public class ChainCode {
    public String getJsonrpc() {
		return jsonrpc;
	}

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}
	 public Result getResult() {
			return result;
	}

	public void setResult(Result result) {
			this.result = result;
	}

	private String jsonrpc;
    private String method;
   
	private Result result;
    
    @Id
    private int id;
    
    private Params params;

	public ChainCode() {
		super();
    }

}