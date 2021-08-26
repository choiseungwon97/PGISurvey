package com.survey.domain;

public class OccupationDescVO {

	private String occNumber;
	private String occName;
	private int occValue;
	
	public String getOccNumber() {
		return occNumber;
	}
	public void setOccNumber(String occNumber) {
		this.occNumber = occNumber;
	}
	public String getOccName() {
		return occName;
	}
	public void setOccName(String occName) {
		this.occName = occName;
	}
	public int getOccValue() {
		return occValue;
	}
	public void setOccValue(int occValue) {
		this.occValue = occValue;
	}
	@Override
	public String toString() {
		return "OccupationDesc [occNumber=" + occNumber + ", occName=" + occName + ", occValue=" + occValue + "]";
	}

	
}
