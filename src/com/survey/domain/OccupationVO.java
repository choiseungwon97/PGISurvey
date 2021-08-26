package com.survey.domain;

import java.util.ArrayList;

public class OccupationVO {

	
	private String id;
	private ArrayList<OccupationDescVO> occValueList = new ArrayList<OccupationDescVO>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<OccupationDescVO> getOccValueList() {
		return occValueList;
	}
	public void setOccValueList(ArrayList<OccupationDescVO> occValueList) {
		this.occValueList = occValueList;
	}
	@Override
	public String toString() {
		return "OccupationVO [id=" + id + ", occValueList=" + occValueList + "]";
	}
	
}
