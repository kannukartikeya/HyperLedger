package com.chaincode.domain;

public class BlockChain {

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCurrentBlockHash() {
		return currentBlockHash;
	}
	public void setCurrentBlockHash(String currentBlockHash) {
		this.currentBlockHash = currentBlockHash;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	int height;
	String currentBlockHash;
	String previousBlockHash;
	

}
