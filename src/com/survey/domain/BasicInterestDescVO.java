package com.survey.domain;

public class BasicInterestDescVO {
	
	private int socialFacilitating;
	private int managing;
	private int businessDetail;
	private int dataProcessing;
	private int mechanical;
	private int nature;
	private int artistic;
	private int helping;
	public int getSocialFacilitating() {
		return socialFacilitating;
	}
	public void setSocialFacilitating(int socialFacilitating) {
		this.socialFacilitating = socialFacilitating;
	}
	public int getManaging() {
		return managing;
	}
	public void setManaging(int managing) {
		this.managing = managing;
	}
	public int getBusinessDetail() {
		return businessDetail;
	}
	public void setBusinessDetail(int businessDetail) {
		this.businessDetail = businessDetail;
	}
	public int getDataProcessing() {
		return dataProcessing;
	}
	public void setDataProcessing(int dataProcessing) {
		this.dataProcessing = dataProcessing;
	}
	public int getMechanical() {
		return mechanical;
	}
	public void setMechanical(int mechanical) {
		this.mechanical = mechanical;
	}
	public int getNature() {
		return nature;
	}
	public void setNature(int nature) {
		this.nature = nature;
	}
	public int getArtistic() {
		return artistic;
	}
	public void setArtistic(int artistic) {
		this.artistic = artistic;
	}
	public int getHelping() {
		return helping;
	}
	public void setHelping(int helping) {
		this.helping = helping;
	}
	@Override
	public String toString() {
		return "BasicInterestDesc [socialFacilitating=" + socialFacilitating + ", managing=" + managing
				+ ", businessDetail=" + businessDetail + ", dataProcessing=" + dataProcessing + ", mechanical="
				+ mechanical + ", nature=" + nature + ", artistic=" + artistic + ", helping=" + helping + "]";
	}
	
	
	

}
