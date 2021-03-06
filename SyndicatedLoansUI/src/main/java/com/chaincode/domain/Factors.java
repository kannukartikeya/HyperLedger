package com.chaincode.domain;

import javax.persistence.*;

@Entity
public class Factors {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String label;
    private String description;
    private String status;

	public Factors() {
		super();
    }

    public Factors(String label, String description) {
		super();
		this.label = label;
		this.description = description;
	}
    
    public Factors(String label, String description,String status) {
 		super();
 		this.label = label;
 		this.description = description;
 		this.status = status;
 	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	   public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
}