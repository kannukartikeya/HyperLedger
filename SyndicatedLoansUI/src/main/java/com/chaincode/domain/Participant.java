package com.chaincode.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Asset> AssetList = new ArrayList<Asset>();
	
	public List<Asset> getAssetList() {
		return AssetList;
	}

	public void setAssetList(List<Asset> assetList) {
		AssetList = assetList;
	}

	private String id;
    private String name;
    private int share;

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public Participant() {
		super();
    }
	
	

}